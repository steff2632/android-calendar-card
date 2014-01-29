package com.wt.calendarcardsample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
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
		calendar.add(Calendar.MONTH, 1);
		mCalendarCard.setDateDisplay(calendar);
		mCalendarCard.notifyChanges();
		
		Button btn = (Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calendar.add(Calendar.MONTH, 1);
				mCalendarCard.setDateDisplay(calendar);
			}
		});
		
		Button button = (Button) findViewById(R.id.button2);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				calendar.add(Calendar.MONTH, -1);
				mCalendarCard.setDateDisplay(calendar);
				
			}
		});
		
		mCalendarCard.setOnCellItemClick(new OnCellItemClick() {
			@Override
			public void onCellClick(View v, CardGridItem item) {
				mTextView.setText(getResources().getString(R.string.sel_date, new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(item.getDate().getTime())));
			}
		});
		
		
		mTextView = (TextView)findViewById(R.id.textView1);
	}

}
