package com.wt.calendarcardsample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.wt.calendarcard.CalendarCardPager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;

public class Sample2 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample2);
		
		ArrayList<Pair<Long, Long>> calendarTimes = new ArrayList<Pair<Long,Long>>();
		
		Pair pair;
		Calendar calender;
		Random random = new Random();
		
		for (int i = 0; i < 10; i++) {
			
			calender = Calendar.getInstance();
			calender.roll(Calendar.DAY_OF_MONTH, random.nextInt());
			
			pair = new Pair<Long, Long>(calender.getTimeInMillis(), calender.getTimeInMillis() + 86400000);
			
			calendarTimes.add(pair);
		}
		
		CalendarCardPager ccp = (CalendarCardPager) findViewById(R.id.calendarCard1);
		ccp.addEvents(calendarTimes);
		
	}

}
