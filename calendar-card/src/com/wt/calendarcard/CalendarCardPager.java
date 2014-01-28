package com.wt.calendarcard;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Pair;

public class CalendarCardPager extends ViewPager {
	
	private CardPagerAdapter mCardPagerAdapter;
	
	public CalendarCardPager(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs);
		init(context);
	}

	public CalendarCardPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}
	
	public CalendarCardPager(Context context) {
		super(context);
		init(context);
	}
	
	private void init(Context context) {
		 mCardPagerAdapter = new CardPagerAdapter(context);
		 setAdapter(mCardPagerAdapter);
	}
	
	public CardPagerAdapter getCardPagerAdapter() {
		return mCardPagerAdapter;
	}
	
	public void addEvents(ArrayList<Pair<Long, Long>> events) {
		mCardPagerAdapter.setEvents(events);
	}

}
