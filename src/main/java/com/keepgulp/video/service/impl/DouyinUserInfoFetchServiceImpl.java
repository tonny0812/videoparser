package com.keepgulp.video.service.impl;

import blade.kit.http.HttpRequest;
import com.keepgulp.common.constants.AppType;
import com.keepgulp.common.constants.AppUrlConstant;
import com.keepgulp.common.util.JsonUtil;
import com.keepgulp.common.util.SignatureUtil;
import com.keepgulp.common.util.TextUtil;
import com.keepgulp.video.model.UserModel;
import com.keepgulp.video.service.UserInfoFetchService;
import okhttp3.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
public class DouyinUserInfoFetchServiceImpl implements UserInfoFetchService {

    @Override
    public UserModel fetchUserInfo(String uId, AppType appType) {
        UserModel userModel = new UserModel();
        OkHttpClient client = new OkHttpClient();
        try {
            String dytk = getDYTK(uId);
            String userVideoUrl = String.format("https://%s/aweme/v1/aweme/post/", AppUrlConstant.douyinHostName);

            HttpUrl.Builder urlBuilder = HttpUrl.parse(userVideoUrl).newBuilder();
            urlBuilder.addQueryParameter("user_id", uId)
                    .addQueryParameter("count", "21")
                    .addQueryParameter("max_cursor","0")
                    .addQueryParameter("min_cursor","-1")
                    .addQueryParameter("aid","1128")
                    .addQueryParameter("_signature", SignatureUtil.generateSignature(uId))
                    .addQueryParameter("dytk",dytk).build();

            String max_cursor = null;
            while(true) {
                if(!StringUtils.isEmpty(max_cursor)) {
                    urlBuilder.setQueryParameter("max_cursor",max_cursor);
                }
                userVideoUrl = urlBuilder.toString();

                Request request = new Request.Builder()
                        .url(userVideoUrl)
                        .headers(getHeaders())
                        .build();
                Response response = client.newCall(request).execute();
                if(response.isSuccessful()) {
                    String content = response.body().string();
                    System.out.println(content);
                    String aweme_list = JsonUtil.getJsonValue(content,"aweme_list");
                    String has_more = JsonUtil.getJsonValue(content,"has_more");
                    if("true".equals(has_more)) {
                        max_cursor = JsonUtil.getJsonValue(content,"max_cursor");
                        if(StringUtils.isEmpty(max_cursor)) {
                            max_cursor = "1";
                        }
                    } else {
                        break;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return userModel;
    }

    private Headers getHeaders() {
        return new Headers.Builder()
                .add("User-Agent", AppUrlConstant.userAgent)
                .add("Accept-Language","zh-CN,zh;q=0.9")
                .add("pragma","no-cache")
                .add("cache-contro","no-cache")
                .add("upgrade-insecure-requests","1")
//                .add("Accept-Encoding","gzip, deflate, br")
                .build();
    }

    private String getDYTK(String uId) throws IOException {
        String dytk = "";
        String url = AppUrlConstant.douyinUserUrl + uId;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .headers(getHeaders()).build();
        try {
            Response response = client.newCall(request).execute();
            if(response.isSuccessful()) {
                String content = response.body().string();
                dytk = TextUtil.getSubUtilSimple(content, "dytk: '(.*)'");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dytk;
    }




    public static void main(String[] args) throws IOException {
        String uId = "89923219116";
        new DouyinUserInfoFetchServiceImpl().fetchUserInfo(uId, AppType.DOUYIN);
    }
}
