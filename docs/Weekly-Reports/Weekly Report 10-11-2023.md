# Date 10/11/2023
# Team Report

#### Previous Goals
- Provide everyone with a way to connect to database through application. This would be without the temporary login information. Must be secure.
- Decide on how information will be stored. This will determine how much this appliaction will depend on the database. If not information is stored within the application, then the database will only store user information and orders.
#### Key Points
- What was done
  - Completed unit tests
  - Talked about how data is stored. Decided to go on unit price of items to get the best overall deal.
  - Redefined the way the webscraper returns information.
  - Set up and redefined the GitHub projects to make it like scrum sprints.
  - Set up teams which are appointed to certain aspects of the application.
- What worked
  - Creating more Azure services including a api app and a function app.
- What was learned
  - How we want to store item prices which is by unit price. It makes it easier to compare the best deals for each store.
- Have trouble with
  - Connecting the database with an api for Azure. There are a few Azure services that need to be created in order for this to work.
- Stuck on
  - Allowing access to the database through a pubilc network. Azure has a lot of security features.
  - Getting codespaces to run webscraper
#### Next Week Goals
- Keep trying to connect database and input sample data.

# Individual Reports

### Tyler Thompson
##### Previous Goals
- Fully learn how to make a scrum work flow in Github.
- Try and lock in how the database will be used within the application. This will depend on if the information is retrieved when a user processes an order or if a script will run in the morning to update the database with generic items.
- Will work with Joe to fully flesh out what the application does with the web scrapper data.
##### Key Points
- Refactored the JTDS driver and replaced it with api connection. This will ensure if a phone loses internet connection it will not crash the database.
- Created most of the tables for the database. Most of the way the information will be stored is now known.
- Set up a database team section in the GitHub projects section. Picked date estimates to try and have certain parts of the application completed by.
- Started to look into JDocs documentation pages that can be created.
##### Next Week Goals
- Fully learn JDoc documentation pages.
- Create a backend api to connect to database.
- Start adding test data to the database if everything goes smooth.

### Aaron Feinberg
#### Previous Goals
- write unit tests for UI Activities 
- collaborate with UI team to create a standardized layout for our app to be shared among activities 
- look into location data for our app (with Syed) 

##### Key Points
- Wrote unit tests for signup and login activities (validating username/password requirements were met)
- Developed the validator object (Util) using TDD
- collaborated with Syed and Tazkir about restructuring the files and finishing activities for testing

What Im Stuck on
- when checking out between branches i am sometimes having issues with the smart checkout function on android studio. 
it claims to shelve my changes but sometimes it turns out they are deleted and it is difficult to restore them, 
especially after i realized when i made a new commit already. 

##### Next Week Goals
- Have a the UI end of our minimum viable product finished 
- Have tests written for all util functions on for these activities 
- move onto integrated and ui testing 

### Taazkir Nasir
##### Previous Goals
- Extend signup activity to get all pertinent user information 
- Create a few more mockups of the search page to visualize the final output
- Create user stories to flush out all possible functional requirements

##### Key Points
- Views will be finalized based on the team's input after the next meeting to be implemented 
- Same with user stories. Once they're finalized and confirmed, they will be added to the living document 
- Will need to make better use of the GitHub projects to manage the workload and make effort estimates

##### Next Week Goals
- Implement final UI components 
- Review the non-functional requirements related to user experience (UX)
- Extending signup will overflow into next week  


### Syed Ahmed
##### Previous Goals
- Get an idea of how to integrate Google Maps API into our app
- Figure our what architecture we were using. We will separate components of the app into 3 layers: UI, logic, and data. 
We will take cues from google's guide to architectural principles <https://developer.android.com/topic/architecture>

##### Key Points
- I get the architecture in concept, but still not entirely sure how it looks like in code
- Collaborated with Aarron to understand our architecture and testing principles going forward

##### Next Week Goals
- Try to refactor some of the code to be in line
- Write code to implement google maps

### Joseph Porrino
##### Previous goals
- Automate the webscraper to search many items at once
- Connect to the database 
- Use github actions to automate webscraper

##### Keypoints
- I have not yet connected the webscraper to the database. Tyler had to make a design change on how we connect to the database. I am looking into the situation with him.
- I am working on setting up the webscraper in codespaces so that it can be automated but im running into issues with getting chrome to work. I may have to create
  a custom docker container to run the script.

##### Next Week Goals
- Fix issues with webscraper in codespaces
- Set up custom docker container
- Research github actions

