package com.keepgulp.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SignatureUtil {
    public static String generateSignature(String uId) {
        String currentPath = SignatureUtil.class.getResource("/signature/").getFile();
        File file = new File(currentPath+ "fuck-byted-acrawler.js");
        String nodejsPath = file.getAbsolutePath();
        System.out.println(nodejsPath);
        String cmd = new StringBuffer().append("node").append(" ").append(nodejsPath).append(" ").append(uId).toString();
        System.out.println(cmd);
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            List<String> processList = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                processList.add(line);
            }
            input.close();
            if(processList.size()>0) {
                return processList.get(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(generateSignature("89923219116"));
    }
}
