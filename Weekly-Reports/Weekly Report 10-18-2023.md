# Date 10/18/2023
# Team Report

#### Previous Goals
- Keep trying to connect database and input sample data.
#### Key Points
- What was done
  - Discussed the entire structure of the project, including the overall goal and how each portion of the application will communicate with eachother. Since the application has multiple different parts to it, it was not completely apparent until now.
  - Set up the mobile API application to come online.   
- What worked
  - Using Azure web service to launch a web API.
- What was learned
  - How to manage the web services portion of Azure.
- Have trouble with
  - Creating the functions for the web API. This is what will handle all incoming requests and send outgoing requests all while ensuring the connection is stable.
- Stuck on
#### Next Week Goals

# Individual Reports

### Tyler Thompson
##### Previous Goals
- Fully learn JDoc documentation pages.
- Create a backend api to connect to database.
- Start adding test data to the database if everything goes smooth.
##### Key Points
- The C# backend for the web API requires C# coding standards to be followed. This includes try to use docstrings in which C# uses XML to format this.
- Deployed the web API, and set up a build file to push the newest changes as soon as commits to main happen.
- Started to try and use the terminal more when it comes to handling processes in each respective coding IDE as well as the shell used for the API and database. Trying to write down useful commands and keep them close by to learn them as fast as possible.
##### Next Week Goals
- Keep using the terminal.
- Continue working on the web API and reguardless if it is finished, give everyone a rundown of what each function will do as well as the parameters and what it returns. It will return a JSON format, but what type of information that is returned will be important.
- Keep researching best practices to see if there are better ways to complete the tasks I am doing.
  
### Aaron Feinberg
#### Previous Goals
- Have a the UI end of our minimum viable product finished 
- Have tests written for all util functions on for these activities 
- move onto integrated and ui testing 

##### Key Points
- Pivoting towards focusing on getting backends data functioning of app up and running
- working on using the REST API protocol to handle requests and incoming data from the db through Tyler's API
- Creating logic to handle smart recommendations to user (based on data from multiple stores...this will require some changes to the web scraper and the data base)

What Im Stuck on
- best way to implement the code (breaking down into classes, data classes, etc.)

##### Next Week Goals
- Have a grasp of REST Api calls
- understand how Syed ViewModel, View, and Data classes are implemented so i can supply them with data
- understand how to interact with tylers API 

### Taazkir Nasir
##### Previous Goals
- Implement final UI components 
- Review the non-functional requirements related to user experience (UX)
- Extending signup will overflow into next week  

##### Key Points
- Implemented nav bar and other UI component across all activities
- Since the app only performs two use cases after reaching the homepage, the homepage seems too bare. So homepage needs to be changed to have a grid layout in the center of the screen for navigation 
- Learned how to send data between activities. Variables are set to accept incoming data but need to be updated to get data from the database to the backend 
- The signup activity was extended but Firebase was not implemented. The signup process will be abandoned for the time being till the search and grocery list features are implemented. A few preset users will be added to the database for a mock login process.
- 
##### Next Week Goals
- Extend the search activity to dynamically update suggestions with user input
- Refactor existing code to follow the software architecture 
- Learn how to handle incoming data from the database  

### Syed Ahmed
##### Previous Goals
- Refactor code to be line with the architecture for our app
- Look into integration with google maps

##### Key Points
- Overall, I spent this week trying getting a good grasp on the architectural pattern our android app, and refactoring the code to follow those patterns and principles. Although the functionally the app is the same, the outcome is clean, organized, and modularized code that's also more conducive for convinient testing and debugging.
- Additionally, I spent a lot time in discussing the code and architecture with the group members.

##### Next Week Goals
- Collaborate with Tyler on writing functions for the API
- Collaborate with Aaron on test-driven development

### Joseph Porrino
##### Previous goals
- Fix issues with webscraper in codespaces
- Set up custom docker container
- Research github actions

##### Keypoints
- Codespaces is unable to run a python project that uses selenium so we will be manually running the python script for the time being
- I finished the webscraper and have the data formatted in a Json. The will be inserted into a text document until connected to the database
- I started looking into pytest for unit testing

##### Next Week Goals
- Work with Tyler on getting the database connected
- Start unittesting code
