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
- implement the shopping list (ranking) activity which will provide a general overview of the total price of a user's shopping cart as well as some store statistics
- integrate passing of intent (store name) to Syed's Google Maps activity
- finish the ApiService interface (add functions for getting all items, store names, and user data) 
  
##### Key Points
- Learned how to parcelize and pass data between activities
- created diagrams to help us understand MVVM and the backend processing process
- Learned about kotlin's built int lazy loading which executes encapsulated code at run time only when needed 

What Im Stuck on
- deciding on the best way to share data between activities. Data thats recieved from the api is held in an object with methods to unpack it into item() objects used by the backend 

##### Next Week Goals
- finish setting up the final rank activity
- perform a test call to the API and have it display information correctly within the activity
- link the api to all other acitivities as needed
- prepare for the alpha demonstration by testing the basic functionality of our app 

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
