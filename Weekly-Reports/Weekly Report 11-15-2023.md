# Date 11/15/2023
# Team Report

#### Previous Goals
- Create the Alpha build.
- Test API connection calls within the application. Also test web scrapper through API.
#### Key Points
- What was done
  - Lots of testing.
  - Inputing real world data.
  - Made the user manual.
- What worked
  - Taking data from the API.
- What was learned
  - How to bug test efficiently.
- Have trouble with
  - A nasty API bug that sometimes trys to insert more into the database then it should.

#### Next Week Goals
- The the beta release fully fleshed out and working.


# Individual Reports

### Tyler Thompson
##### Previous Goals
- Continue to work on Alpha build.
- Try and help debug any problems created from the API.
##### Key Points
- Continued to input real data into API.
- Fixed more bugs in API.
##### Next Week Goals
- Help ensure the beta build works with the API well.
- Continue testing everything.
  
### Aaron Feinberg
#### Previous Goals
- finish setting up the final rank activity
- perform a test call to the API and have it display information correctly within the activity
- link the api to all other acitivities as needed
- prepare for the alpha demonstration by testing the basic functionality of our app 
  
##### Key Points
- Successfully implemented the backend-to-api interface
- data is now "parcelized" between activities
- presented with my team for the alpha release

What Im Stuck on
- finding the best implementation for the final rank activity. Id like to be able to present the best option for users (which store to visit) as well as the price of their shopping cart for each store. 

##### Next Week Goals
- improve the rank activity for displaying the best store to visit
- write tests for the backend (might create util functions)
- try out some integration tests 

### Taazkir Nasir
##### Previous Goals
- Implement the user account activity where the user's address and search radius will be inputted. 
- Get image buttons in a grid layout to work on the homepage, if not implement it using a linear layout 
- Learn how to handle incoming data from the database 

##### Key Points
- Got the grid layout to work for the homepage with image buttons.
- Have to tinker with the design after the alpha release but functionally it works. Just looks ugly 
- User Account activity can show the user's address, but having some trouble sending the address from sign-up to the user account activity.
- The address was initially split into separate segments which is causing the issue. It is an easy fix that should be taken care of very soon
- Will have to work on creating dummy users in the database so the address can be grabbed from the database instead of the signup activity 
##### Next Week Goals
- Use the API to populate the search results with items from the database 
- Make sure the user's flow between activities is working according to design across the whole app 

### Syed Ahmed
##### Previous Goals
- Modify and refactor existing code to allow for smoother integration with backend-api

##### Key Points
- My goal this week is to work with Tyler to integrate the backend api layer with the android app. In general, the separate parts of the application work as intended so we just need to combine them altogether

##### Next Week Goals
- Finalize aplha build

### Joseph Porrino
##### Previous goals
- Finish the webscrapers and collect sample data to store as a json.
- Help Tyler with the database functions
##### Keypoints
- Created the controllers for the database
- Added more unit tests to the webscraper
- Still figuring out how to account for edge cases when standardizing units
##### Next Week Goals
- Connect to the database and add data
- Add more unit tests
- Figure out issue with standardizing units
- Help with finishing up kotlin development
