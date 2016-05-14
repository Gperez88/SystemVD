package com.perezmejia.systemvd.helper;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by Guil on 5/14/2016.
 */
public class DateUtils {

    public static Long getNow() {
        LocalDate date = LocalDate.now();
        ZoneId zoneId = ZoneId.systemDefault();
        return date.atStartOfDay(zoneId).toEpochSecond();
    }
}
