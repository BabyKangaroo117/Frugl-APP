# Date 10/25/2023
# Team Report

#### Previous Goals
- Ensure Connection to API is secure.
- Get the model and controller created in the API.
#### Key Points
- What was done
  - Created the model, view, and controller, folders in the API and populated them information from the database. Used a scaffold method to inport information from the database using an Azure library in the .Net
  Core.
  - Researched ways to use Azure Key Vaults to hide sensitive information.
  - created branch with standard program structure
  - created framework for communicating with the api 
- What worked
  - Creating the Azure Key Vaults.
  - Creating the model, view, and controller for the API.
  - Connecting the database to the API and having a connection to it.
- What was learned
  - How Azure handles private information that should not be pushed to repositories.
  - How a model, view, controller layout is handled.
  - function of viewmodels and their purpose
  - how the retrofit library interacts with the internet
- Have trouble with
  - Getting the Azure Key Vaults to be able to output the needed connection string.
- Stuck on
#### Next Week Goals
- Continue creating and improving the API functions, and try and input real data into the database.
- Finish Implementing Viewmodel interface for the API to the backend 
- Create activities for searching and creating lists of items
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
