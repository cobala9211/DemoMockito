package com.example.dnp.demomockito;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

import static org.mockito.Mockito.mock;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by PhuongDN on 15/01/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DateUnitTest {
    @Mock
    Calendar mCalendar;

    /**
     * Case value min day of month if Calendar.DATE = 1
     */
    @Test
    public void valueDateMinOfMonth() {
        // Mock value for Calendar.DATE then return 1
        Mockito.when(mCalendar.get(Calendar.DATE)).thenReturn(1);
        // Mock result for DateUtil.getDate then return 1
        Mockito.when(DateUtil.getDate(mCalendar)).thenReturn(1);
        // Check result
        Assert.assertEquals(1, DateUtil.getDate(mCalendar));
    }

    /**
     * Case value max day of month if Calendar.DATE = 31
     */
    @Test
    public void valueDateMaxOfMonth() {
        // Mock value for Calendar.Date then return 31
        Mockito.when(mCalendar.get(Calendar.DATE)).thenReturn(31);
        // Mock result for DateUtil.getDate then return 31
        Mockito.when(DateUtil.getDate(mCalendar)).thenReturn(31);
        // Check result
        Assert.assertEquals(31, DateUtil.getDate(mCalendar));
    }

    /**
     * Case value day current of month Calendar.DATE
     */
    @Test
    public void valueDateCurrentOfMonth() {
        // Value of day current
        int dayCurrent = Calendar.getInstance().get(Calendar.DATE);
        // Mock value for Calendar.Date
        Mockito.when(mCalendar.get(Calendar.DATE)).thenReturn(dayCurrent);
        // Mock result for DateUtil.getDate then return day current
        Mockito.when(DateUtil.getDate(mCalendar)).thenReturn(dayCurrent);
        // Check result
        Assert.assertEquals(dayCurrent, DateUtil.getDate(mCalendar));
    }

    /**
     * Case value min month of year if Calendar.MONTH = 1
     * Calendar.get(Calendar.MONTH) = Calendar.MONTH +1
     */
    @Test
    public void valueMonthMinOfYear() {
        // Mock value 0 for Calendar.Month then return 1
        Mockito.when(mCalendar.get(Calendar.MONTH)).thenReturn(0);
        // Mock result 0 for DateUtil.getMonth then return 1
        Mockito.when(DateUtil.getMonth(mCalendar)).thenReturn(0);
        // Check result
        Assert.assertEquals(1, DateUtil.getMonth(mCalendar));
    }

    /**
     * Case value max month of year if Calendar.MONTH = 12
     * Calendar.get(Calendar.MONTH) = Calendar.MONTH + 1
     */
    @Test
    public void valueMonthMaxOfYear() {
        // Mock value 11 for Calendar.Month then return 12
        Mockito.when(mCalendar.get(Calendar.MONTH)).thenReturn(11);
        // Mock value 11 for DateUtil.getMonth then return 12
        Mockito.when((DateUtil.getMonth(mCalendar))).thenReturn(11);
        // Check result
        Assert.assertEquals(12, DateUtil.getMonth(mCalendar));
    }

    /**
     * Case value current month of year Calendar.MONTH
     * Calendar.get(Calendar.MONTH) = Calendar.MONTH + 1
     */
    @Test
    public void valueMonthCurrentOfYear() {
        // Value month current
        int monthCurrent = Calendar.getInstance().get(Calendar.MONTH);
        // Mock value current for Calendar.Month
        Mockito.when(mCalendar.get(Calendar.MONTH)).thenReturn(monthCurrent);
        // Mock value current for DateUtil.getMonth
        Mockito.when((DateUtil.getMonth(mCalendar))).thenReturn(monthCurrent);
        // Check result
        Assert.assertEquals(monthCurrent + 1, DateUtil.getMonth(mCalendar));
    }

    /**
     * Case value current of year Calendar.YEAR
     */
    @Test
    public void valueYearCurrent() {
        // Value year current
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        // Mock value current for Calendar.Year
        Mockito.when(mCalendar.get(Calendar.YEAR)).thenReturn(yearCurrent);
        // Mock value current for DateUtil.getYear
        Mockito.when((DateUtil.getYear(mCalendar))).thenReturn(yearCurrent);
        // Check result
        Assert.assertEquals(yearCurrent, DateUtil.getYear(mCalendar));
    }

    /**
     * Case max DayOfMonth of this month current random 28, 29, 30, 31
     */
    @Test
    public void valueMaxDayOfMonthIsCurrent() {
        // Value day of month current maximum
        int dayOfMonthCurrent = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        // Mock value for Calendar.getActualMaximum
        Mockito.when(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)).thenReturn(dayOfMonthCurrent);
        // Mock value for DateUtil.getDaysYearMonth
        Mockito.when(DateUtil.getDaysYearMonth(mCalendar)).thenReturn(dayOfMonthCurrent);
        // Check result
        Assert.assertEquals(dayOfMonthCurrent, DateUtil.getDaysYearMonth(Calendar.getInstance()));
    }

    /**
     * Case Max DayOfMonth value is 28
     */
    @Test
    public void valueMaxDayOfMonthIs28() {
        // Mock value for Calendar.getActualMaximum then return 28
        Mockito.when(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)).thenReturn(28);
        // Mock value for DateUtil.getDaysYearMonth then return 28
        Mockito.when(DateUtil.getDaysYearMonth(mCalendar)).thenReturn(28);
        // Check result
        Assert.assertEquals(28, DateUtil.getDaysYearMonth(mCalendar));
    }

    /**
     * Case Max DayOfMonth value is 29
     */
    @Test
    public void valueMaxDayOfMonthIs29() {
        // Mock value for Calendar.getActualMaximum then return 29
        Mockito.when(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)).thenReturn(29);
        // Mock value for DateUtil.getDaysYearMonth then return 29
        Mockito.when(DateUtil.getDaysYearMonth(mCalendar)).thenReturn(29);
        // Check result
        Assert.assertEquals(29, DateUtil.getDaysYearMonth(mCalendar));
    }

    /**
     * Case Max DayOfMonth value is 30
     */
    @Test
    public void valueMaxDayOfMonthIs30() {
        // Mock value for Calendar.getActualMaximum then return 30
        Mockito.when(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)).thenReturn(30);
        // Mock value for DateUtil.getDaysYearMonth then return 30
        Mockito.when(DateUtil.getDaysYearMonth(mCalendar)).thenReturn(30);
        // Check result
        Assert.assertEquals(30, DateUtil.getDaysYearMonth(mCalendar));
    }

    /**
     * Case Max DayOfMonth value is 31
     */
    @Test
    public void valueMaxDayOfMonthIs31() {
        // Mock value for Calendar.getActualMaximum then return 31
        Mockito.when(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)).thenReturn(31);
        // Mock value for DateUtil.getDaysYearMonth then return 31
        Mockito.when(DateUtil.getDaysYearMonth(mCalendar)).thenReturn(31);
        // Check result
        Assert.assertEquals(31, DateUtil.getDaysYearMonth(mCalendar));
    }

    /**
     * Case day position offset of day of week current
     */
    @Test
    public void dayPositionOffsetCurrent() {
        // Set value the first day of month
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        // Value day current for dayPositionOffset
        int date = calendar.get(Calendar.DAY_OF_WEEK);
        // Value dateOffset for dayPositionOffset
        int dateOffset = (date + 5) % Calendar.DAY_OF_WEEK;
        // Moc value for DateUtil.getDayPositionOffset
        Mockito.when(DateUtil.getDayPositionOffset(mCalendar)).thenReturn(dateOffset);
        // Check result
        Assert.assertEquals(dateOffset, DateUtil.getDayPositionOffset(calendar));
    }

    /**
     * Case parse calendar by format FORMAT_YEAR_MONTH_FOR_API
     * Test with date value 201701
     */
    @Test
    public void parseFormatYearMonthForApi() throws ParseException {
        // Value date parse
        String dateValue = "201701";
        // SetTime for Calendar
        SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.FORMAT_YEAR_MONTH_FOR_API, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse(dateValue));

        // Mock value test
        Iterator iterator = mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn(dateValue).thenReturn(DateUtil.FORMAT_YEAR_MONTH_FOR_API);
        Mockito.when(DateUtil.parse((String) iterator.next(), DateUtil.FORMAT_YEAR_MONTH_FOR_API)).thenReturn(calendar);
        // Check result
        Assert.assertEquals(calendar, DateUtil.parse(dateValue, DateUtil.FORMAT_YEAR_MONTH_FOR_API));
    }

    /**
     * Case parse calendar by format FORMAT_DAY_FOR_API
     * Test with date value 20170101
     */
    @Test
    @SuppressWarnings("unchecked")
    public void parseFormatDayForApi() throws ParseException {
        // Value date parse
        String dateValue = "20170101";
        // SetTime for Calendar
        SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.FORMAT_DAY_FOR_API, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse(dateValue));

        // Mock value test
        Iterator iterator = mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn(dateValue).thenReturn(DateUtil.FORMAT_DAY_FOR_API);
        Mockito.when(DateUtil.parse((String) iterator.next(), DateUtil.FORMAT_DAY_FOR_API)).thenReturn(calendar);
        // Check result
        Assert.assertEquals(calendar, DateUtil.parse(dateValue, DateUtil.FORMAT_DAY_FOR_API));
    }

    /**
     * Case parse calendar by format FORMAT_YEAR_MONTH
     * Test with date value 2017年1月
     */
    @Test
    @SuppressWarnings("unchecked")
    public void parseFormatYearMonth() throws ParseException {
        // Value date parse
        String dateValue = "2017年1月";
        // SetTime for Calendar
        SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.FORMAT_YEAR_MONTH, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse(dateValue));

        // Mock value test
        Iterator iterator = mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn(dateValue).thenReturn(DateUtil.FORMAT_YEAR_MONTH);
        Mockito.when(DateUtil.parse((String) iterator.next(), DateUtil.FORMAT_YEAR_MONTH)).thenReturn(calendar);
        // Check result
        Assert.assertEquals(calendar, DateUtil.parse(dateValue, DateUtil.FORMAT_YEAR_MONTH));
    }

    /**
     * Case parse calendar by format FORMAT_DATE_TIME_FROM_API
     * Test with date value 2017011613:43
     */
    @Test
    @SuppressWarnings("unchecked")
    public void parseFormatDateTimeFromApi() throws ParseException {
        // Value date parse
        String dateValue = "2017011613:43";
        // SetTime for Calendar
        SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.FORMAT_DATE_TIME_FROM_API, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse(dateValue));

        // Mock value test
        Iterator iterator = mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn(dateValue).thenReturn(DateUtil.FORMAT_DATE_TIME_FROM_API);
        Mockito.when(DateUtil.parse((String) iterator.next(), DateUtil.FORMAT_DATE_TIME_FROM_API)).thenReturn(calendar);
        // Check result
        Assert.assertEquals(calendar, DateUtil.parse(dateValue, DateUtil.FORMAT_DATE_TIME_FROM_API));
    }

    /**
     * Case parse calendar by format day month yyyyMMdd
     * Test with date value 20170101
     */
    @Test
    @SuppressWarnings("deprecation")
    public void parseYearMonthDay() throws ParseException {
        // Value date parse
        String dateValue = "20170101";
        // SetTime for Calendar
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(format.parse(dateValue));
        // Value DateUtil.parseYearMonthDay
        Calendar calendarTest = DateUtil.parseYearMonthDay(dateValue);
        // Check result is the same
        Assert.assertSame(calendarTest, calendarTest);
    }

    /**
     * Case format calendar by FORMAT_YEAR_MONTH_FOR_API
     */
    @Test
    public void formatYearMonthForApi() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_YEAR_MONTH_FOR_API, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance().getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_YEAR_MONTH_FOR_API, formatTest);
    }

    /**
     * Case format calendar by FORMAT_DAY_FOR_API
     */
    @Test
    public void formatDayForApi() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DAY_FOR_API, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance().getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_DAY_FOR_API, formatTest);
    }

    /**
     * Case format calendar by FORMAT_YEAR_MONTH
     */
    @Test
    public void formatYearMonth() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_YEAR_MONTH, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance(Locale.JAPAN).getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_YEAR_MONTH, formatTest);
    }

    /**
     * Case format calendar by FORMAT_MONTH
     */
    @Test
    public void formatMonth() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_MONTH, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance(Locale.JAPAN).getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_MONTH, formatTest);
    }

    /**
     * Case format calendar by FORMAT_MONTH_DAY
     */
    @Test
    public void formatMonthDay() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_MONTH_DAY, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance(Locale.JAPAN).getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_MONTH_DAY, formatTest);
    }

    /**
     * Case format calendar by FORMAT_DATE
     */
    @Test
    public void formatDay() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DATE, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance(Locale.JAPAN).getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_DATE, formatTest);
    }

    /**
     * Case format calendar by FORMAT_DATE_WITHOUT_DAY_OF_WEEK
     */
    @Test
    public void formatDateWithoutDayOfWeek() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DATE_WITHOUT_DAY_OF_WEEK, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance(Locale.JAPAN).getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_DATE_WITHOUT_DAY_OF_WEEK, formatTest);
    }

    /**
     * Case format calendar by FORMAT_DATE_TIME
     */
    @Test
    public void formatDateTime() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DATE_TIME, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance(Locale.JAPAN).getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_DATE_TIME, formatTest);
    }

    /**
     * Case format calendar by FORMAT_DATE_FOR_PICKER
     */
    @Test
    public void formatDateForPicker() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DATE_FOR_PICKER, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance(Locale.JAPAN).getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_DATE_FOR_PICKER, formatTest);
    }

    /**
     * Case format calendar by FORMAT_DAY_OF_WEEK_FULL
     */
    @Test
    public void formatDayOfWeekFull() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DAY_OF_WEEK_FULL, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance().getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_DAY_OF_WEEK_FULL, formatTest);
    }

    /**
     * Case format calendar by FORMAT_HOUR_MINUTE
     */
    @Test
    public void formatHourMinute() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_HOUR_MINUTE, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance().getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_HOUR_MINUTE, formatTest);
    }

    /**
     * Case format calendar by FORMAT_DATE_TIME_FROM_API
     */
    @Test
    public void formatDateTimeFormApi() {
        // Set format for calendar
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.FORMAT_DATE_TIME_FROM_API, Locale.getDefault());
        String formatTest = format.format(Calendar.getInstance().getTime());
        Calendar calendar = mock(Calendar.class);
        // Call test Mock value
        testFormatString(calendar, DateUtil.FORMAT_DATE_TIME_FROM_API, formatTest);
    }

    /**
     * TestFormatString : test mock value calendar by format
     *
     * @param calendar   calendar current
     * @param format     format calendar
     * @param formatTest format date test
     */
    private void testFormatString(Calendar calendar, String format, final String formatTest) {
        Mockito.when(DateUtil.format(calendar, format)).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return formatTest;
            }
        });
        Assert.assertEquals(formatTest, DateUtil.format(Calendar.getInstance(), format));
    }

    /**
     * Case Check tutorial School in progress
     * If Calendar setTime 2017011619:00 and startTime 19:00, endTime 21:00
     */
    @Test
    public void isTutoringSchoolInProgress() throws ParseException {
        // Moc value for String parameter
        Iterator iteratorTrue = mock(Iterator.class);
        SimpleDateFormat formatterTrue = new SimpleDateFormat(DateUtil.FORMAT_DATE_TIME_FROM_API, Locale.getDefault());
        Calendar calendarTrue = Calendar.getInstance();
        calendarTrue.setTime(formatterTrue.parse("2017011619:00"));
        Mockito.when(iteratorTrue.next()).thenReturn("20170116").thenReturn("19:00").thenReturn("21:00");
        // Value DateUtil.isTutoringSchoolInProgress
        boolean isTutorial = DateUtil.isTutoringSchoolInProgress(calendarTrue, (String) iteratorTrue.next(),
                (String) iteratorTrue.next(), (String) iteratorTrue.next());
        // Check result
        Assert.assertTrue(isTutorial);
    }

    /**
     * Case Check tutorial School not in progress
     * If Calendar setTime 20170116 and startTime 19:00, endTime 21:00
     */
    @Test
    public void isNotTutoringSchoolInProgress() throws ParseException {
        // Moc value for String parameter
        Iterator iteratorFalse = mock(Iterator.class);
        Mockito.when(iteratorFalse.next()).thenReturn("20170116").thenReturn("19:00").thenReturn("21:00");
        // Value DateUtil.isTutoringSchoolInProgress
        boolean isNotTutorial = DateUtil.isTutoringSchoolInProgress(Calendar.getInstance(), (String) iteratorFalse.next(),
                (String) iteratorFalse.next(), (String) iteratorFalse.next());
        // Check result
        Assert.assertFalse(isNotTutorial);
    }

    /**
     * Case year month with format yyyy年M月
     * MonthYear is 2017年3月, if Calendar setTime 201703
     */
    @Test
    @SuppressWarnings("deprecation")
    public void formattedYearMonth() {
        // String format year month
        final String yearMonth = "2017年3月";
        // Set value for Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 12);
        // Mock value for DateUtil.getFormattedYearMonth
        Mockito.when(DateUtil.getFormattedYearMonth(mCalendar)).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return yearMonth;
            }
        });
        // Check result
        Assert.assertEquals(yearMonth, DateUtil.getFormattedYearMonth(calendar));
    }

    /**
     * Case month with format M月
     * Month is 03月 ,if Calendar.setMonth is 02月
     */
    @Test
    @SuppressWarnings("deprecation")
    public void testFormattedMonth() {
        // String format month
        final String monthTest = "3月";
        // Set value for Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 12);
        // Mock value for DateUtil.getFormattedMonth
        Mockito.when(DateUtil.getFormattedMonth(mCalendar)).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return monthTest;
            }
        });
        // Check result
        Assert.assertEquals(monthTest, DateUtil.getFormattedMonth(calendar));
    }

    /**
     * Case format day of week key is sunday
     * If Calendar set time 20170212
     */
    @Test
    public void testFormattedDayOfWeekKey() {
        // String format day of week
        final String dayOfWeek = "sunday";
        // Set value for Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DATE, 12);
        // Mock value for DateUtil.getFormattedDayOfWeekKey
        Mockito.when(DateUtil.getFormattedDayOfWeekKey(mCalendar)).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return dayOfWeek;
            }
        });
        // Check result
        Assert.assertEquals(dayOfWeek, DateUtil.getFormattedDayOfWeekKey(calendar));
    }

    /**
     * Case calculate minute different of Calendar target
     * And Calendar current with date time input
     */
    @Test
    public void testCalculateMinuteDiff() throws ParseException {
        // set number different for 2 day
        float diffNumber = 38773.0f;
        // Mock value for String parameter
        Iterator iterator = mock(Iterator.class);
        Calendar calendarTest = Calendar.getInstance(Locale.getDefault());
        String dateTimeInput = "20161220";
        String timeInput = "15:30";
        // SetTime value for Calendar
        SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.FORMAT_DATE_TIME_FROM_API, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse("2017011613:43"));
        // Mock for parameter
        Mockito.when(iterator.next()).thenReturn(dateTimeInput).thenReturn(timeInput);
        // Mock for DateUtil.calculateMinuteDiff
        Mockito.when(DateUtil.calculateMinuteDiff(calendarTest, (String) iterator.next(), (String) iterator.next())).thenReturn(diffNumber);
        // Check result
        Assert.assertEquals(diffNumber, DateUtil.calculateMinuteDiff(calendar, dateTimeInput, timeInput), 1);
    }

    /**
     * Case Calculate duration of startTime and endTime Calendar
     * If dateTime : 20170101 and startTime 16:20, endTime 21:20 duration is 300
     */
    @Test
    public void testCalculateDuration() {
        // Set Value for dateTime
        String dateTime = "20170101";
        // Set Value for startTime
        String startTime = "16:20";
        // Set value for endTime
        String endTime = "21:20";
        // Mock value for parameter
        Iterator iterator = mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn(dateTime).thenReturn(startTime).thenReturn(endTime);
        // Mock value for DateUtil.calculateDuration is 300
        Mockito.when(DateUtil.calculateDuration((String) iterator.next(),
                (String) iterator.next(), (String) iterator.next())).thenReturn(300);
        // Check result
        Assert.assertEquals(300, DateUtil.calculateDuration(dateTime, startTime, endTime));
    }

}
