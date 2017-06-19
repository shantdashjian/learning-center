# learning-center
An AngularJS Spring REST API web application where students could take a course and track their progress towards completion

![alt text](login.png "Login")

![alt text](enrollments.png "Course Enrollments")

![alt text](course-launch.png "Course Launch")

## In This Document:
1. [Application URL](#application-url)
2. [How to Use the Application](#how-to-use-the-application)
3. [Technologies Used](#technologies-used)
4. [Data Model](#data-model)
5. [Showing Progress: End-to-End Exploration](#showing-progress-end-to-end-exploration)

## Application URL
http://shaundashjian.com:8080/LearningCenter

## How to Use the Application
* Student logs in with his email and password
* The landing page shows all the courses the student is currently enrolled in, each showing the progress as a percentage of completion 
* Student could click on "Launch Course" to open the course page
* In the course page, student learns by reading the material in each page and then taking a quiz to test his knowledge
* The progress graph on the left shows how much has the student completed as a percentage of the overall content of the course
* After answering each quiz correctly, the student could move to the next part in the course
* After the student answers the last question in the course correctly, he graduates from the course

## Technologies Used
  * AngularJS
  * Spring REST web services
  * Angular SVG round progressbar, by https://github.com/crisbeto/angular-svg-round-progressbar
  * AJAX, using AngularJS's $http service
  * Java
  * HTML, CSS, Bootstrap, and JavaScript
  * JPA and Hibernate
  * MySQL

## Data Model
![alt text](schema.png "Data Model")

## Showing Progress: End-to-End Exploration:
  * Purpose: This feature shows students what their progress is throuout the course
  * End-to-End Implementation Path:
    * 
    * Social aspects so that users could compare their stashes
    * Get data from other eCommerce sites
    * Develop the application as a smart phone app that uses RFID technology to scan item barcode and fill details automatically

  <hr>

[Up](README.md)
