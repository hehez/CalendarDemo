# CalendarDemo
A calendar demo with spring boot.

## CRUD operation examples:

  * **search event:**  
  ```curl http://localhost:8090/calendarEvents/```  
  OR   
  ```curl http://localhost:8090/calendarEvents/allevents```  
  OR  
  ```curl http://localhost:8090/calendarEvents/1```  
  OR  
  ```curl http://localhost:8090/calendarEvents/events\?start\=2018-07-01\&end\=2018-09-31```
  
  * **create event:**  
  ```curl -i -H POST "Content-Type:application/x-www-form-urlencoded" -d "title=java" http://localhost:8090/calendarEvents/event```
  
  * **delete event:**  
  ```curl -X DELETE http://localhost:8090/calendarEvents/1```
  
## Background reminder service:
  Check if current time is 31 minutes prior to reminder time and pretend to send notification in console. Goto "data.sql" to insert some test data (reminder time afterforward current time), and the application will show the notification
  
## ToDo:
  Implement user authentication using a token-based mechanism of your choice so that users can only create/update/delete their own calendar events.
