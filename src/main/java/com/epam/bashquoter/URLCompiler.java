package com.epam.bashquoter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class URLCompiler {

    public String numberCompile(String inputUserData) {
        StringBuilder stringBuilder = new StringBuilder(inputUserData);
        while (stringBuilder.length() < 6) {
            stringBuilder.insert(0, "0");
        }
        return stringBuilder.toString();
    }

    public String compileRightURLAddress(String inputUserData) {
        return "https://bash.im/quote/" + inputUserData + "/";
    }

    public String readURL(String compiledURLAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL bashorg = new URL(compiledURLAddress);
            // StandardCharsets.UTF_8 doesn't work :(
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(bashorg.openStream(), StandardCharsets.UTF_8));
            String inputLine;
            while ((inputLine = inputStream.readLine()) != null) {
                stringBuilder.append(inputLine);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
