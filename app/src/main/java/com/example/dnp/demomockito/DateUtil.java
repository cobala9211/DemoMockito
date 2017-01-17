package com.example.dnp.demomockito;

import android.support.annotation.NonNull;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by DNP on 1/17/2017.
 */
public final class DateUtil {
    public static final String FORMAT_YEAR_MONTH_FOR_API = "yyyyMM";
    public static final String FORMAT_DAY_FOR_API = "yyyyMMdd";
    public static final String FORMAT_YEAR_MONTH = "yyyy年M月";
    public static final String FORMAT_MONTH = "M月";
    public static final String FORMAT_MONTH_DAY = "M月d日（E）";
    public static final String FORMAT_DATE = "yyyy年M月d日(E)";
    public static final String FORMAT_DATE_WITHOUT_DAY_OF_WEEK = "yyyy年M月d日";
    public static final String FORMAT_DATE_TIME = "M月d日（E）H:mm";
    public static final String FORMAT_DATE_FOR_PICKER = "M月d日 E";
    public static final String FORMAT_DAY_OF_WEEK_FULL = "EEEE";
    public static final String FORMAT_HOUR_MINUTE = "HH:mm";
    public static final String FORMAT_DATE_TIME_FROM_API = "yyyyMMddHH:mm";

    private DateUtil() {
    }

    public static int getYear(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth(Calendar calendar) {
        // Calendar.MONTHが実際の月より1少なく返却されるため、インクリメントして返却する
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDate(Calendar calendar) {
        return calendar.get(Calendar.DATE);
    }

    public static int getDaysYearMonth(Calendar calendar) {
        return calendar.getActualMaximum(Calendar.DATE);
    }

    public static int getDayPositionOffset(Calendar calendar) {
        // 月初めの日を設定する
        calendar.set(Calendar.DATE, 1);
        // DAY_OF_WEEK（日曜日が1で始まる1〜7の数字）を元にoffset値を算出する
        return (calendar.get(Calendar.DAY_OF_WEEK) + 5) % Calendar.DAY_OF_WEEK;
    }

    @NonNull
    public static Calendar parse(@NonNull String targetString,
                                 @NonNull @ParseDateFormat String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(formatter.parse(targetString));
            return calendar;
        } catch (ParseException e) {
            throw new IllegalArgumentException("non-parsable date format. target: " + targetString + ", format: " + format);
        }
    }

    @NonNull
    @Deprecated
    public static Calendar parseYearMonthDay(@NonNull String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(format.parse(date));
            return calendar;
        } catch (ParseException e) {
            throw new RuntimeException("不正な年月日: " + date, e);
        }
    }

    @NonNull
    public static String format(@NonNull Calendar calendar,
                                @NonNull @DateFormat String format) {
        SimpleDateFormat resultFormat = new SimpleDateFormat(format, Locale.getDefault());
        return resultFormat.format(calendar.getTime());

    }

    public static boolean isTutoringSchoolInProgress(Calendar currentCalendar, String lessonDate, String startTime, String endTime) {
        Calendar startCalendar = parse(lessonDate + startTime, FORMAT_DATE_TIME_FROM_API);
        Calendar endCalendar = parse(lessonDate + endTime, FORMAT_DATE_TIME_FROM_API);
        return currentCalendar.compareTo(startCalendar) >= 0 && currentCalendar.compareTo(endCalendar) <= 0;
    }

    // region: Deprecated

    @NonNull
    @Deprecated
    public static String getFormattedYearMonth(@NonNull Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月", Locale.JAPAN);
        return dateFormat.format(calendar.getTime());
    }

    @Deprecated
    public static String getFormattedMonth(@NonNull Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M月", Locale.JAPAN);
        return dateFormat.format(calendar.getTime());
    }

    // endregion

    @NonNull
    public static String getFormattedDayOfWeekKey(@NonNull Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE", Locale.US);
        return dateFormat.format(calendar.getTime()).toLowerCase(Locale.US);
    }

    public static float calculateMinuteDiff(@NonNull Calendar target, @NonNull String dateString, @NonNull String timeString) {
        Calendar calendar = parse(dateString + timeString, FORMAT_DATE_TIME_FROM_API);
        long diff = target.getTimeInMillis() - calendar.getTimeInMillis();
        return diff / 60.0f / 1000;
    }

    public static int calculateDuration(@NonNull String dateString, @NonNull String startTimeString, @NonNull String endTimeString) {
        Calendar endTime = parse(dateString + endTimeString, FORMAT_DATE_TIME_FROM_API);
        int duration = (int) calculateMinuteDiff(endTime, dateString, startTimeString);
        if (duration < 0) {
            // 日をまたいでいる場合
            duration = 24 * 60 + duration;
        }
        return duration;
    }

    @StringDef({FORMAT_YEAR_MONTH_FOR_API,
            FORMAT_DAY_FOR_API,
            FORMAT_YEAR_MONTH,
            FORMAT_MONTH,
            FORMAT_MONTH_DAY,
            FORMAT_DATE,
            FORMAT_DATE_WITHOUT_DAY_OF_WEEK,
            FORMAT_DATE_TIME,
            FORMAT_DATE_FOR_PICKER,
            FORMAT_DAY_OF_WEEK_FULL,
            FORMAT_HOUR_MINUTE})
    @Retention(RetentionPolicy.SOURCE)
    private @interface DateFormat {
    }

    @StringDef({FORMAT_YEAR_MONTH_FOR_API,
            FORMAT_DAY_FOR_API,
            FORMAT_DATE_TIME_FROM_API,
            FORMAT_YEAR_MONTH})
    @Retention(RetentionPolicy.SOURCE)
    private @interface ParseDateFormat {
    }
}
