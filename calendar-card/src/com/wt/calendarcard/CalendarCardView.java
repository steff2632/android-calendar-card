package com.wt.calendarcard;

import java.util.Calendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.wt.calendar_card.R;

public class CalendarCardView extends RelativeLayout {

	private Calendar mCalendar;
	private CalendarCard mCalendarCard;
	
	public CalendarCardView(Context context) {
		super(context);
		
		init(context);
	}
	
	public CalendarCardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		init(context);
	}
	
	public CalendarCardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		init(context);
	}
	
	private void init(Context context) {
		
		mCalendar = Calendar.getInstance();
		
		LayoutInflater inflater = LayoutInflater.from(context);
		
		View view = inflater.inflate(R.layout.calendar_card_view, null);
		
		mCalendarCard = (CalendarCard) view.findViewById(R.id.calendarCard1);
		
		Button btn_next = (Button) view.findViewById(R.id.btn_next);
		btn_next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCalendar.add(Calendar.MONTH, 1);
				mCalendarCard.setDateDisplay(mCalendar);
				mCalendarCard.notifyChanges();
			}
		});
		
		Button btn_prev = (Button) view.findViewById(R.id.btn_prev);
		btn_prev.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mCalendar.add(Calendar.MONTH, -1);
				mCalendarCard.setDateDisplay(mCalendar);
				mCalendarCard.notifyChanges();
			}
		});
		
		addView(view);
	}

}
