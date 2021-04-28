package FrameWork.Report;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {

    public static String getDateTimeFormatt(){
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date now = new Date();
        return s.format(now);
    }
//    public static String getDateTimeFormatScreeanShot(){
//
//        DateTimeFormatter data = new DateTimeFormatter.ofPattern("dd-MMM-yyyy_hh'h'mm'm's's");
//        return getDateTimeFormatScreeanShot();
//    }

}
