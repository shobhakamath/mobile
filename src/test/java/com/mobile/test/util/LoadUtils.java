package com.mobile.test.util;

import com.mobile.entities.Brand;
import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadUtils {

    public Brand[] getMobiles() {
        String str = readFromFile();
        Gson g = new Gson();
       return g.fromJson(str, Brand[].class);

    }
    public static String readFromFile() {
        try {
            Path currentDir = Paths.get("src","test");
            String filePath = currentDir.toAbsolutePath() + "/java/resources/mobiles.json";
            return readFile(filePath);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static String readFile(String filePath) throws IOException {
        FileInputStream fin = new FileInputStream(filePath);
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            String line = null;
            while ((line = reader.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

}
