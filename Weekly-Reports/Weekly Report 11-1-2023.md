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
- What worked
  - Setting up the building and testing process for the API.
- What was learned
  - How a secrets work in the .yml file. This can used to verify the person that started the build process. This can do useful things like automatically create comments in the GitHub. The comment can contain a coverage report on the tests.
- Have trouble with
  - Azure key vaults, started looking for other solutions.
- Stuck on
  - Understanding the setup for the controller classes and how to create them from the models.
#### Next Week Goals
- Work with everyone to try and get Data from the API into the database.

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
- Have a grasp of REST Api calls
- understand how Syed ViewModel, View, and Data classes are implemented so i can supply them with data
- understand how to interact with tylers API 

##### Key Points
- learned the structure of the android mvvm workflow
- created framework for our data layer (link between backend and the UI) 

What Im Stuck on
- best way to implement the code (breaking down into classes, data classes, etc.)

##### Next Week Goals
- Pass Data from in the backend (which was recieved by the api) to various components of our program 
- Help with creating the item and shopping list views. Users should be able to make search queries while the app will only suggest valid search items from the database 

### Taazkir Nasir
##### Previous Goals
- Extend the search activity to dynamically update suggestions with user input
- Refactor existing code to follow the software architecture 
- Learn how to handle incoming data from the database  

##### Key Points
- The SearchItem activity is implemented along with the layout to display each individual item.
- The recycler view element was complex to work with and needs to be understood more.
- In the initial implementation of the search activity, the recycler view would populate with all items. However, this design choice would not be feasible with a live DB because the app would have to make 70 API calls just to load the search page.
- The latest implementation only displays the items that are being searched, and the recycler view reverts to the initial state when the search bar is empty 
- The item layout needs to be rethought since it displays the price now.
- Getting the price would not be possible during the fuzzy search since the call to the API would not be made till after the item is clicked
- So a View Item activity needs to be made to display the prices, item description, store logo, and image(possibly) 
- The current layout to display items can be used in the View Item activity
##### Next Week Goals
- Design and implement View Item activity
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
- Work with Tyler on getting the database connected
- Start unittesting code

##### Keypoints
- Refactored webscraper code to make more readable and use less lines of code
- Set up pytest and started unit testing
- Got access to database.

##### Next Week Goals
- Finish unit testing
- Work on database functions
- Connect python code to database
