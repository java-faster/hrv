package org.sang.common.poi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Auther YCHD-JPC
 * @Date 2019/8/1 9:58
 **/

public class DateUtils {

    public static Date getYYYYddmm(Date date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateString=sdf.format(date);
        return sdf.parse(dateString);
    }
}
