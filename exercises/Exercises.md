## Exercises Spring Data and JPA
1. Start a new git project (or fork this one) with your new pair and implement this very example. Make it work all the way to your mysql db on both of your machines.
2. Add more attributes/fields to Student (name, lastname, age, email, occupation, ... and anything that makes sense to you). Make sure they are persisted to the database as well.
3. Display all Students with all attributes within a list (https://www.w3schools.com/html/html_lists.asp). This list should show up after adding a student (/students).
   * Try to find out what methods are offered by your repository and use it
   * Add a student manually into your database using a INSERT script and check if it shows up on your list
   * How are the data type in Java match up with those in mysql?
     * --> https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-type-conversions.html
4. Create a PostMapping where you can remove a student. 
5. Think of a way how you can update a student using a post request and implement it. 
6. Create a Button or Link for each student within your listview that deletes that very user. 
7. Create a Button or Link for each student within your listview that opens a form to edit that student.
----------
8. Refactor your code in a way that there is no repository call in your controller as well as the heavy string work abstracted away into services. Make it look clean and tidy.
9. Implement a way how you can find a student by name. I want to input the name into a input field in your webapp.
   * checkout the spring jpa documentation https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation 
10. Implement another search option where you can find a student by any of its attributes. 
    * you could be using multiple input fields to do so, where the input for each would optional
11. Let`s raise complexity a little here ;) Implement another Entity that represents a Course. 
    * One Course has multiple students. 
    * One student belongs to only one course
      * check out https://www.baeldung.com/hibernate-one-to-many#description it contains all the information you need to model this relation
    * Use Bidirectional relations with OneToMany and ManyToOne here. 
12. Implement a GET method that displays a student list per Course e.g.:(/course?name=maths or /course?id=...)
13. Also change your student view to print the course as well
14. (Bonus) make a course name within your student view clickable, so that by clicking on it you open the course view for that very course. Vice versa for the students. 