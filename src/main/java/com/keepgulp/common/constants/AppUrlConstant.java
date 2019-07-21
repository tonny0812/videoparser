package com.keepgulp.common.constants;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class AppUrlConstant {

    public static final String douyinHostName = "www.iesdouyin.com";

    public static final String douyinUserUrl = "https://www.iesdouyin.com/share/user/";

    public static final String userAgent  = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1";

    public static Header[] getHeaders() {
        Header[] headers = new BasicHeader[6];
        headers[0] = new BasicHeader("User-Agent", userAgent);
        headers[1] = new BasicHeader("Accept-Language","zh-CN,zh;q=0.9");
        headers[2] = new BasicHeader("pragma","no-cache");
        headers[3] = new BasicHeader("cache-contro","no-cache");
        headers[4] = new BasicHeader("upgrade-insecure-requests","1");
        headers[5] = new BasicHeader("Accept-Encoding","gzip, deflate, br");
        return headers;
    }
}
