# PROJECT DENTAL CLINIC
![technology Maven](https://img.shields.io/badge/technology-Maven-blue.svg)
![technology Java](https://img.shields.io/badge/technology-SDK17-blue.svg)

This project is for the subject of Back End 1, of the certified tech developer career of the program launched by Digital House, Globant and Mercado Libre.
In this opportunity I created a dental clinic using the mvc pattern.

It is desired to implement a system that allows managing the appointment reservation for a dental clinic. This must meet the following requirements:
- **Dentist data management:** list, add, modify and delete dentists. Register surname, name and registration of tuition
- **Patient data management:** list, add, modify and delete patients. For each one, the following are stored: name, surname, address, DNI and registration date
- **Record appointment:** it must be possible to assign a patient an appointment with a dentist at a certain date and time.
- **Login:** (*in progress*) validate entry to the system through a login with username and password. Any logged in user (ROLE_USER) must be allowed to register an appointment, but only those with an administration role (ROLE_ADMIN) can manage dentists and patients. A user may have a single role and they will be entered directly into the database.
 
### CONSIDERATIONS

- **SECURITY:** is configured with Spring Security dependency: `spring-boot-starter-security`.At the web level it asks you for a login. The possible users to log in are:
  user role and administrator role. Your settings are:
 1. userName: user@email, password: 1234
 2. userName: admin@email, pasword: 1234
 
authentication for endpoints: `/patients`, `/dentists`, `/appointments` and `/address` currently disabled  



### API
This application exposes the following endpoints:




#### PATIENTS

`Get /patients`

List all patients

Status code:
- **200:** if the request is ok
- **500:** Internal server error

`Get /patients/{id}` 

Find a patient by id

Status code:
- **200:** if the request is ok
- **404:** Patient with this id, is not found

`Post /patients`

Create a patient

Status code:
- **201:** Create 
- **500:** Internal server error

`Put /patients`

Update a patient (fields to modify: all the of patient. It is not possible to modify the address attributes)

Status code:
- **200:** if the request is ok
- **500:** Internal server error


`Delete /patients`

Delete a patient

Status code:
- **200:** if the request is ok
- **404:** Patient with this id, is not found


#### DENTISTS

`Get /dentists`

List all dentists

Status code:
- **200:** if the request is ok
- **500:** Internal server error

 `Get /dentists/{id}`
 
Find a dentist by id

Status code:
- **200:** if the request is ok
- **404:** Dentist with this id, is not found

`Post /dentists`

Create a dentist

Status code:
- **201:** Create 
- **500:** Internal server error

`Put /dentists`

Update a dentist (fields to modify: all the attributes)

Status code:
- **200:** if the request is ok
- **500:** Internal server error


`Delete /dentists`

Delete a dentist

Status code:
- **200:** if the request is ok
- **404:** Dentist with this id, is not found

#### APPOINTMENTS

`Get /appointments`

List all apointments

Status code:
- **200:** if the request is ok
- **500:** Internal server error

`Get /apointments/{id}`

Find an appointment by id

Status code:
- **200:** if the request is ok
- **404:** Appointment with this id, is not found
- 
`Post /appointments`

Create an appointment

Status code:
- **201:** Create 
- **500:** Internal server error

`Put /appointments`

Update an appointment (fields to modify only attribute dateTime)

Status code:
- **200:** if the request is ok
- **500:** Internal server error


`Delete /apointments`

Delete an appointment

Status code:
- **200:** if the request is ok
- **404:** Appointment with this id, is not found




### DEPENDENCIES, TOOLS AND FRAMEWORKS

- [Spring](https://spring.io/) 
- [h2](https://www.h2database.com/html/main.html) 
- [log4j](https://logging.apache.org/log4j/2.x/) 
- [JUnit5](https://junit.org/junit5/) 
- [Hibernate-Jpa](https://spring.io/projects/spring-data-jpa) 
- [lombok](https://projectlombok.org/) 
