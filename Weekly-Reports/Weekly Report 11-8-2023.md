# Date 11/8/2023
# Team Report

#### Previous Goals
- Work with everyone to try and get Data from the API into the database.
- Create a plan for anything that might not be finished in time.
#### Key Points
- What was done
  - Successfully deployed the controller class into the API. This allows calls to be made to the database.
  - Made calls from the Frugl application to the API and got a response.
  - Updated security features for API.
- What worked
  - Deploying the controllers to the API.
  - Make a request to the API from the application.
- What was learned
  - How to create the controller classes, and how to create more specific querys so the API.
  - How to use Retrofit2 to parse JSON objects from the API response.
- Have trouble with
  - Still having trouble with Azure key vaults. Security features may not be the best for now.

#### Next Week Goals
- Create the Alpha build.
- Test API connection calls within the application. Also test web scrapper through API.


# Individual Reports

### Tyler Thompson
##### Previous Goals
- Research more on Entity Framework Core. This is how Azure does it model, view, and controller setup.
- Find ways to hide sensitive information in the API repository.
##### Key Points
- Deployed the API to work with the new controller classes.
- Tested the deployment of the website to ensure everything was correctly built.
- Helped debug calls to the API.
##### Next Week Goals
- Continue to work on Alpha build.
- Try and help debug any problems created from the API.
  
### Aaron Feinberg
#### Previous Goals
- Pass Data from in the backend (which was recieved by the api) to various components of our program 
- Help with creating the item and shopping list views. Users should be able to make search queries while the app will only suggest valid search items from the database
  
##### Key Points
- Learned how to parcelize and pass data between activities
- created diagrams to help us understand MVVM and the backend processing process
- Learned about kotlin's built int lazy loading which executes encapsulated code at run time only when needed 

What Im Stuck on
- Interfacing with the API (will discuss with Tyler and Joe)
- architecture choices (where should we make initial call to api, where should we store a list of items to be shared between activities)

##### Next Week Goals
- implement the shopping list (ranking) activity which will provide a general overview of the total price of a user's shopping cart as well as some store statistics
- integrate passing of intent (store name) to Syed's Google Maps activity
- finish the ApiService interface (add functions for getting all items, store names, and user data) 

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

