package com.hehez.calendar.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hehez.calendar.entity.CalendarEvent;
import com.hehez.calendar.repositories.ICalendarEventRepo;

@Component
public class ReminderTaskService {
	private final static long ONE_HOUR = 60 * 60 * 1000;
	private final static long ONE_MIN = 60 * 1000;
	private final static long ONE_SEC = 1000;

	@Autowired
	ICalendarEventRepo calendarEventRepo;
	
	@Scheduled(fixedRate = ONE_MIN)
	public void reminderBgService() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime nowAfter31Mins = now.plusMinutes(31);
		
		System.out.println(now+ "\t"+nowAfter31Mins);
		List<CalendarEvent> res = calendarEventRepo.findByIsRemindedAndReminderTimeBetween(false, now, nowAfter31Mins);
		updateReminder(res);
	}
	
	@Async
	private void updateReminder(List<CalendarEvent> events) {
		if (events.size() == 0) return;
		for (CalendarEvent e : events) {
			if (sentNotification(e)) {
				System.out.println(e.getId());
				e.setReminded(true);
				calendarEventRepo.save(e);
			}
		}
	}
	
	private boolean sentNotification(CalendarEvent event) {
		try {
			System.out.println("I'm pretending to send Notification!");
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
