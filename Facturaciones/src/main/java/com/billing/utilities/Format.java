package com.billing.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Format {

    public static int convertNumber(String data) {
        return Integer.parseInt(data);
    }

    public static Date convertDate(String data, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(data);
    }
}
