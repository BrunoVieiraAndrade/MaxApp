package com.example.bruno.maxapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String getDataEHora(){
        Date now = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return simpleDateFormat.format(now);
    }

    public static String getDataOuHora(String data) {
        return null;
    }
}
