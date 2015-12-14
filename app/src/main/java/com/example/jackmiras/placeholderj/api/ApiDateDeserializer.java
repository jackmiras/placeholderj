package com.example.jackmiras.placeholderj.api;

import android.os.Build;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by jackson on 14/12/15.
 */
public class ApiDateDeserializer implements JsonDeserializer<Date> {

    public static final String API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZZZZZ"; //usado principalmente para envio de datas a api
    public static final String API_DATE_FORMAT_SECONDARY = "yyyy-MM-dd'T'HH:mm:ss"; //usado para formatar datas de inicio, termino, validades, etc.
    private static final String TIME_ZONE_ZERO = "00:00";

    @Override
    public Date deserialize(JsonElement jsonElement, Type typeOF, JsonDeserializationContext context) throws JsonParseException {
        String dateString = jsonElement.getAsString();
        if (dateString.length() > API_DATE_FORMAT_SECONDARY.length()) {
            try {
                String timezoneDate = dateString.replace("Z", "+00:00");
                int floatSecondsStart = timezoneDate.lastIndexOf('.');
                if (floatSecondsStart != -1) {
                    int timezoneStart = timezoneDate.lastIndexOf('+');
                    if (timezoneStart == -1) {
                        timezoneStart = timezoneDate.lastIndexOf('-');
                    }
                    timezoneDate = timezoneDate.substring(0, floatSecondsStart) + timezoneDate.substring(timezoneStart);
                }
                return new SimpleDateFormat(API_DATE_FORMAT).parse(timezoneDate);
            } catch (ParseException pe) {
                pe.printStackTrace();
            }
        }
        try {
            return new SimpleDateFormat(API_DATE_FORMAT_SECONDARY).parse(dateString);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        JsonParseException e = new JsonParseException("Unparseable date: \"" + dateString);
        e.printStackTrace();
        throw e;
    }

    public static String format(Date date) {
        String formattedDate = new SimpleDateFormat(API_DATE_FORMAT).format(date);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            int length = formattedDate.length();
            formattedDate = formattedDate.substring(0, length - 2) + ":" + formattedDate.substring(length - 2, length);
        }
        String[] stringArray = formattedDate.split(Pattern.quote("+"));
        if (stringArray.length > 1 && TIME_ZONE_ZERO.equals(stringArray[1])) {
            formattedDate = stringArray[0] + "-" + stringArray[1];
        }
        return formattedDate;
    }
}
