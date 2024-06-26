# Date 11/1/2023
# Team Report

#### Previous Goals
- Continue creating and improving the API functions, and try and input real data into the database.
- Finish Implementing Viewmodel interface for the API to the backend 
- Create activities for searching and creating lists of items
#### Key Points
- What was done
  - Worked on controller classes for API. Still need to implement the rest of the classes or models in this case.
  - Continued research Azure key vaults.
  - Set up build and test processes for API.
  - Talked about solutions to problems that might not be solved in time.
- What worked
  - Setting up the building and testing process for the API.
- What was learned
  - How a secrets work in the .yml file. This can used to verify the person that started the build process. This can do useful things like automatically create comments in the GitHub. The comment can contain a coverage report on the tests.
- Have trouble with
  - Azure key vaults, started looking for other solutions.
  - Learning the Entity Framework Core architecture. There is a lot to it.
  - Ran into bot issues with the shoprite webscraper. May not be able to set specific zipcodes.
- Stuck on
  - Understanding the setup for the controller classes and how to create them from the models.
#### Next Week Goals
- Work with everyone to try and get Data from the API into the database.
- Create a plan for anything that might not be finished in time.

# Individual Reports

### Tyler Thompson
##### Previous Goals
- Still learn more in the terminal.
- Try and get the connection string to work in the Azure Key Vault.
- Test real data in the database which is input from the API. This will be a lot of testing to get this to work properly.
##### Key Points
- Helped Joe setup some controller classes in the Frugl API.
- Continued to research Azure key vaults, but did not have much success with it.
- Will need to still research more about Entity Framework Core to understand how to work the controller classes in the API.
##### Next Week Goals
- Research more on Entity Framework Core. This is how Azure does it model, view, and controller setup.
- Find ways to hide sensitive information in the API repository.
  
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
- Design and implement View Item activity
- Learn how to handle incoming data from the database 

##### Key Points
- The search page will remain as it is. Users will input search terms and suggestions will appear including price and details, as only one API call will be made at app launch.
- We'll use the same layout from the search page to show item details when clicked. I am also considering a dialog box to display contextual information instead of launching a new activity.
- The grid layout for the homepage nav bar is proving difficult. It requires downloading the layout as an additional feature in Android Studio but the dependency is not being pushed to GitHub 
- Still researching how to work with a live database.
##### Next Week Goals
- Implement the user account activity where the user's address and search radius will be inputted. 
- Get image buttons in a grid layout to work on the homepage, if not implement it using a linear layout 
- Learn how to handle incoming data from the database  

### Syed Ahmed
##### Previous Goals
- Figure out the workflow and design of the app, API, and database with other team members
- Set up google api

##### Key Points
- Most of the time this past week was spent on discussing the design and workflow for our app. As I was working on the app, I realized that considering the design of the database, it would not be possible to calculate the aggregate cheapest price and recommend the best store. We could let the user search up the cheapest price and best store for each individual item, however, we would not be able to implement our original use case which was to take into account all of the user's desired grocery items.
- We finally decided to modify the database to add additional columns to store prices from all stores, but even this proved to be a challenge. For example, if a store didn't carry an item, we'd have to store null thus give rise to scalability issues. Moreover, we ran into design challenges when considering how we would tackle different variations of the same type of item. For example, no fat milk vs 2% fat milk.

##### Next Week Goals
- Finalize the best approach for our app
- Write code for finding cheapest price feature

### Joseph Porrino
##### Previous goals
- Finish unit testing
- Work on database functions
- Connect python code to database

##### Keypoints
- Almost finished shoprite webscraper. Ran into issues with bots but was able to "hack" my way through.
- Started helping tyler with the database functions.
- Set up CI with the webscraper. Still need to test if selenium will work with github actions.

##### Next Week Goals
- Finish the webscrapers and collect sample data to store as a json.
- Help Tyler with the database functions
