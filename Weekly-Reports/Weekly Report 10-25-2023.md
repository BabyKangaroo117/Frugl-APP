# Date 10/25/2023
# Team Report

#### Previous Goals
- Ensure Connection to API is secure.
- Get the model and controller created in the API.
#### Key Points
- What was done
  - Created the model, view, and controller, folders in the API and populated them information from the database. Used a scaffold method to inport information from the database using an Azure library in the .Net Core.
  - Researched ways to use Azure Key Vaults to hide sensitive information.
- What worked
  - Creating the Azure Key Vaults.
  - Creating the model, view, and controller for the API.
  - Connecting the database to the API and having a connection to it.
- What was learned
  - How Azure handles private information that should not be pushed to repositories.
  - How a model, view, controller layout is handled.
- Have trouble with
  - Getting the Azure Key Vaults to be able to output the needed connection string.
- Stuck on
#### Next Week Goals
- Continue creating and improving the API functions, and try and input real data into the database.

# Individual Reports

### Tyler Thompson
##### Previous Goals
- Keep using the terminal.
- Continue working on the web API and reguardless if it is finished, give everyone a rundown of what each function will do as well as the parameters and what it returns. It will return a JSON format, but what type of information that is returned will be important.
- Keep researching best practices to see if there are better ways to complete the tasks I am doing.
##### Key Points
- Created the model, view, controller layout in the API and synced it with the database tables.
- Created an Azure Key Vault to store the connection to the database. This way the connection string is never exposed.
- Used the terminal to install the packages and set up the database connection.
- Researching everything that is needed so that this process goes smoothly. There is a lot to it.
##### Next Week Goals
- Still learn more in the terminal.
- Try and get the connection string to work in the Azure Key Vault.
- Test real data in the database which is input from the API. This will be a lot of testing to get this to work properly.
  
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
