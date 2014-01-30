package com.wt.calendarcardsample;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.wt.calendarcard.CalendarCard;
import com.wt.calendarcard.CardGridItem;
import com.wt.calendarcard.OnCellItemClick;

public class Sample1 extends Activity {
	
	private CalendarCard mCalendarCard;
	private TextView mTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sample1);
		mCalendarCard = (CalendarCard)findViewById(R.id.calendarCard1);
		
		final Calendar calendar = Calendar.getInstance();
		mCalendarCard.setDateDisplay(calendar);
		mCalendarCard.notifyChanges();
		
		Button btn = (Button)findViewById(R.id.btn_prev);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calendar.add(Calendar.MONTH, 1);
				mCalendarCard.setDateDisplay(calendar);
				mCalendarCard.notifyChanges();
			}
		});
		
		Button button = (Button) findViewById(R.id.btn_next);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calendar.add(Calendar.MONTH, -1);
				mCalendarCard.setDateDisplay(calendar);
				mCalendarCard.notifyChanges();
				
			}
		});
		
		mCalendarCard.setOnCellItemClick(new OnCellItemClick() {
			@Override
			public void onCellClick(View v, CardGridItem item) {
				mTextView.setText(getResources().getString(R.string.sel_date, new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(item.getDate().getTime())));
			}
		});
		
		
		mTextView = (TextView)findViewById(R.id.textView1);
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
		
		mCalendarCard.addEvents(calendarTimes);
	}

}
