package com.example.wahyuajisantoso.animalserver.Common;


import com.example.wahyuajisantoso.animalserver.Model.Request;
import com.example.wahyuajisantoso.animalserver.Model.User;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Common {
    public static User currentUser;
    public static Request currentRequest;

    public static final String UPDATE = "Update";
    public static final String DELETE = "Delete";

    public static final int PICK_IMAGE_REQUEST = 71;

    public static String convertCodeToStatus (String code)
    {
        if (code.equals("0"))
            return "Menunggu Konfirmasi";
        else if (code.equals("1"))
            return "Pesanan Diantar";
        else
        return "Pesanan Sudah Sampai";
    }

    public static String getDate (long time)
    {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        StringBuilder date = new StringBuilder(
                android.text.format.DateFormat.format("dd-MM-yyyy HH:mm", calendar).toString());
        return date.toString();
    }
}