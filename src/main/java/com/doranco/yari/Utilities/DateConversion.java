package com.doranco.yari.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {

    // Convert from Date("yyyy-MM-dd") to Date("dd-MM-yyyy")
    public Date convertDateA(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date date = null;

        try {
            date = formatter.parse(dateString);
            formatter.applyPattern("dd-MM-yyyy");
            dateString = formatter.format(date);
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return date;
    }

}
