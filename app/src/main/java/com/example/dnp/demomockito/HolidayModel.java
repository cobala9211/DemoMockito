package com.example.dnp.demomockito;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DNP on 1/17/2017.
 */

//@Value
public class HolidayModel implements Serializable {

    private List<Holiday> holidays;

//    @Value
    public static class Holiday implements Serializable {

        private String month;
        private List<String> days;
    }
}