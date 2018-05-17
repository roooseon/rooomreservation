Hotel Room Booking System

This hotel reservation system is a Maven project created in Spring Boot using spring data JPA along with integrated RESTful web service and well managed scopes . The project allows a system admin to add update or delete rooms in the resort and users/customers can book the room if available. A confirmation email is sent to the customer whenever s/he books a room. The booked room will be available automatically after the reservation period is over. Users/customers can login and view his profile and also see their room booking details.

Some additional features:
Apache tiles
Internalization
Spring Validation
Spring Security
Cookie
Login
Logout


Technologies Used : Java7, JSP, Maven, MySQL, HTML5, CSS3, JavaScript, Bootstrap, Eclipse, Git, Spring, Hibernate, CRUD data repository, JSON, RESTful, Spring Boot

Main Pages: 
localhost:8080 (root)
localhost:8080/adminlogin
localhost:8080/customerlogin
localhost:8080/allroomslist (only accessable by Admin)
localhost:8080/updateroom/{roomno} (only accessable by Admin)
localhost:8080/availableroomslist
localhost:8080/profile/
localhost:8080/roomdetail/{roomNo}
