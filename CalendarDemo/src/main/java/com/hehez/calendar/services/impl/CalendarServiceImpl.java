package com.hehez.calendar.services.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hehez.calendar.entity.CalendarEvent;
import com.hehez.calendar.repositories.ICalendarEventRepo;
import com.hehez.calendar.services.ICalendarService;

@Service
public class CalendarServiceImpl implements ICalendarService {

	@Autowired
	ICalendarEventRepo calendarEventRepo;

	@Override
	public List<CalendarEvent> allEvents() {
		return calendarEventRepo.findAll();
	}

	@Override
	public CalendarEvent save(CalendarEvent e) {
		CalendarEvent ne = calendarEventRepo.save(e);
		return ne;
	}

	@Override
	public void delete(CalendarEvent e) {
		calendarEventRepo.delete(e);
	}

	@Override
	public List<CalendarEvent> getEventsByDateBetween(String s, String e) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate sd = LocalDate.parse(s, formatter);
		LocalDate ed = LocalDate.parse(e, formatter);
		return calendarEventRepo.findByEventDateBetween(sd, ed);
	}

}
