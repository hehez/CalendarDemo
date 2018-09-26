package com.hehez.calendar.services;

import java.util.List;

import com.hehez.calendar.entity.CalendarEvent;

public interface ICalendarService {
	List<CalendarEvent> allEvents();
	CalendarEvent save(CalendarEvent e);
	void delete(CalendarEvent e);
	List<CalendarEvent> getEventsByDateBetween(String s, String e);
}
