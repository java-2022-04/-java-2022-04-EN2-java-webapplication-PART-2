## Exercises Spring Data and JPA
1. Start a new git project (or fork this one) with your new pair and implement this very example. Make it work all the way to your mysql db on both of your machines.
2. Add more attributes/fields to Student (name, lastname, age, email, occupation, ... and anything that makes sense to you). Make sure they are persisted to the database as well.
3. Display all Students with all attributes within a list (https://www.w3schools.com/html/html_lists.asp). This list should show up after adding a student (/students).
   * Try to find out what methods are offered by your repository and use it
   * Add a student manually into your database using a INSERT script and check if it shows up on your list
   * How are the data type in Java match up with those in mysql?
4. Create a PostMapping where you can remove a student. 
5. Think of a way how you can update a student using a post request and implement it. 
6. (Bonus Task) Create a Button or Link for each student within your listview that deletes that very user. 
7. (Bonus Task) Create a Button or Link for each student within your listview that opens a form to edit that user.