package com.axiom.mobile.test.util;

import com.axiom.mobile.entities.Brand;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadUtils {

    public Brand[] getMobiles() {
        String str = ReadFileUtil.readFromFile();
        Gson g = new Gson();
       return g.fromJson(str, Brand[].class);

    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
