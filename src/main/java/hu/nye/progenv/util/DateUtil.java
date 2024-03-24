package hu.nye.progenv.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Slf4j
public class DateUtil {
    public Long stringToLong(String date) {
        Date result=new Date();
        try {
            result=new SimpleDateFormat("yyyy/MM/dd:hh:mm").parse(date);
        } catch (ParseException e) {
            log.error("string to date error :" + date );
            e.printStackTrace();
        }  
        return result.getTime();
    }

    public String longToString(Long date) {
        Date dateObject=new Date(date);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd:hh:mm");
        String result = formatter.format(dateObject);

        return result;
    }
}
