package com.zzz.pgn.sfishelper.db;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author zengsl
 */
public class MyTest {

    public static void main(String[] args) throws Exception {
        Process process = Runtime.getRuntime().exec(" /bin/sh cat  ~/Library/USM/sso/log/`date +%Y.%m`.log");
        int waitFor = process.waitFor();

        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuilder output = new StringBuilder();
        String line = "";
        while (line != null) {
            line = bufferedReader.readLine();
            output.append(line).append("\n");
        }

        inputStreamReader.close();
        bufferedReader.close();
        System.out.println("output:" + output);
    }
}
