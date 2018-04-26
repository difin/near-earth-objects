package org.difin.neo.services;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateRetrievalService {

    public String getTodaysDate(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
