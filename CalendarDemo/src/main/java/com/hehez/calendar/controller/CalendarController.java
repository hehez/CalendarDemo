package com.hehez.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hehez.calendar.entity.CalendarEvent;
import com.hehez.calendar.services.ICalendarService;

@RestController
@RequestMapping("/calendarEvents")
public class CalendarController {

	@Autowired
	ICalendarService calendarService;

	@RequestMapping(value = "/allevents", method = RequestMethod.GET)
	public List<CalendarEvent> allEvent() {
		return calendarService.allEvents();
	}

	@RequestMapping(value = "/event", method = {RequestMethod.POST, RequestMethod.PATCH})
	@ResponseBody
	public CalendarEvent addEvent(CalendarEvent e) {
		return calendarService.save(e);
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.DELETE)
	@ResponseBody
	public void delEvent(CalendarEvent e) {
		calendarService.delete(e);
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public List<CalendarEvent> getAllEventsByDateBetween(
			@RequestParam(value = "start", required = true) String start,
			@RequestParam(value = "end", required = true) String end) {
		return calendarService.getEventsByDateBetween(start, end);
	}
}
