package com.hehez.calendar.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "calendar_event")
public class CalendarEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate eventDate;
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime eventTime;
	private String location;
	private LocalDateTime reminderTime;
	private boolean isReminded;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public LocalTime getEventTime() {
		return eventTime;
	}
	public void setEventTime(LocalTime eventTime) {
		this.eventTime = eventTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getReminderTime() {
		return reminderTime;
	}
	public void setReminderTime(LocalDateTime reminderTime) {
		this.reminderTime = reminderTime;
	}
	public boolean isReminded() {
		return isReminded;
	}
	public void setReminded(boolean isReminded) {
		this.isReminded = isReminded;
	}
}
