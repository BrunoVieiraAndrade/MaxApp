package com.example.bruno.maxapp.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    public static String getJsonString(Context context, String fileName){
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
