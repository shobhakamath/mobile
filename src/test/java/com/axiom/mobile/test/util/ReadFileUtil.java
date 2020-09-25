package com.axiom.mobile.test.util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileUtil {
    public static String readFromFile() {
        try {
            Path path = Paths.get("", "src");
            String filePath = path.getFileName().toAbsolutePath() + "test/java/resources/mobiles.json";
            return readFile(filePath);
        }
        catch (Exception e) {
            Path path = Paths.get("", "test");
            String filePath = path.getFileName().toAbsolutePath() + "test/java/resources/mobiles.json";
            System.out.println(filePath);
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


    private String readFromInputStream(String path)
            throws IOException {
        //"\\src\\test\\java\\resources\\mobiles.json"
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);

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