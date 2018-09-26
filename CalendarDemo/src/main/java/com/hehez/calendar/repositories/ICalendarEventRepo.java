package com.hehez.calendar.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hehez.calendar.entity.CalendarEvent;

@RepositoryRestResource
public interface ICalendarEventRepo extends JpaRepository<CalendarEvent, Long> {
	List<CalendarEvent> findByEventDate(LocalDate date);
	List<CalendarEvent> findByEventDateBetween(LocalDate startDate, LocalDate endDate);
	List<CalendarEvent> findByEventDateAndEventTimeBetween(LocalDate date,
			LocalTime startTime, LocalTime endTime);
	List<CalendarEvent> findByIsRemindedAndReminderTimeBetween(boolean isReminded,
			LocalDateTime startTime, LocalDateTime endTime);
}
