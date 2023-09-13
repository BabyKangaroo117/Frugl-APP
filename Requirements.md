![image1](https://github.com/BabyKangaroo117/Frugl-APP/assets/13011373/b5efcc9f-946b-44ee-88cb-0036170282ff)

<img src="Frugl_Logo.png" width=200 height=200/>

# Team Info & Policies

### Team Members & Roles
- #### Tyler Thompson<br>
   __Role__: Provide functionality between application and database. Document project properly and reasearch useful techniques to speed up application. Backend engineer coupled with a data analysis in this case.

- #### Joseph Porrino<br>
   __Role__: Full stack engineer. Provide functionality between application and API’s. Design and create a UI to display grocery store items.

  #### Mansib Syed Ahmed<br>
  __Role__: Backend engineer. Provide functionality and integration between application, API, and database. Writing, debugging and testing code to implement the application's underlying logic and algorithms.

- #### Aaron Feinberg  

	__Role__:  Full stack engineer. Will focus on frontend and MVC development in the android ecosystem. 

- #### Taazkir Nasir<br>
  __Role__: Product design and security implementation. Frontend engineer focused on enhancing user experience and error handling.
### Repository
- [Link to repository](https://github.com/BabyKangaroo117/Frugl-APP)

### Communication Channels

#### Frequent Scrum Meetings
This will be held through Microsoft Teams, and will provide a strong and consistent workflow.

# Product Discription

Frugl is a price comparison app that compares prices of grocery store items to find the cheapest price. Companies that have made their data public through API’s will be used in the comparison. A user can initiate a search for an item such as chicken breast. The app will then return locations to get chicken breast with prices in ascending order. The user can then save selected items in a shopping cart. The user can create an account and save up to 5 recent orders. 

# TODO: FIX FEATURES
__Major Features__:
- A way to retrieve previous orders from the database.
- Selecting fastest route to each store based on order.
- Making Requests to store API's for item prices
  
__Minor Features__:
- A premium version of the user account. This will be free unless major progress is made on transactions at the end of the project.
# Use Cases (Functional Requirements)
### Tyler Thompson
### Use Case Previous Orders

__Name__: Previous Orders

__Actors__: Application user and Database

__Flow of events__:
1. Application user is signed in (Pre Condition)
2. Application user selects recent orders (Trigger)
3. Query sent to database
4. Database checks recent orders
5. Database returns 5 most recent orders
6. Orders displayed on application (Success scenario)
7. Application user selects order or proceeds back to main page (Exit)

__Entry__:
- Authentication
- Internet Connection
- User selects previous orders

__Exit__:
- Order is selected or user returns to main page

__Extensions__:
- User has no previous orders (Success scenario)
- User has fewer then 5 previous orders (Success scenario)
  
__Exceptions__:
- User is not authenticated and selects previous orders 
- User has no internet connection and selects previous orders

### Joseph Porrino
### Use Case API Handler

__Name__: API Handler

__Actors__: User and grocery list

__Flow of events__:
1.	User click’s button to send items in grocery list to API handler (Trigger)
2.	API handler makes requests to each API.
3.	API handler receives data from API’s (Postcondition)
4.	Data can now be used for analysis.

__Entry__:
- API authentication
- Request to REST API

__Exit__:
- Recieve data from API's
- Request denied
- Item does not exist. No data

__Extensions__:
- None

__Exceptions__:
- Item doesn't exist at any store
- Item spelled wrong

### Mansib Syed Ahmed
### Use Case: Creating a Shopping List

__Actors__: App User

__Triggers__: User clicks on "shopping lists" feature

__Precondition__: User installs the app and signs into their account

__Flow of events__:
1. User opens the app and navigates to "shopping lists" feature
2. User selects the option to create a new shopping list
3. User searches for their desired items by typing their names into the search bar and adds each of them to their list
4. User finishes adding items to their list and clicks on "find cheapest option" feature

__Postconditions__: The app suggests the best store to buy the grocery items

__Extensions/Variations__: The user can also create their shopping list by selecting their previous orders

__Exceptions__:
1. User enters invalid input
2. App is unable to retrieve the best suggestions

### Aaron Feinberg
#### User Log-In
__Actor__: User

**Trigger**: User launches a new instance of the application 

__Flow of events:__
1. If User Is auth(), do not auth() and send to home page
2. Present User with an auth page (username/phone number and password). user may log in or change password 
3. User selects log in 
4. credentials are sent to the user database for auth()
5. if auth() send user to home page
6. if not auth() request that user try again 

__Extensions__
- a. The user does not have an account, they will be presented with the option to create an account 
- b. The User forgot their password, the user will be prompted to follow the standard email verification process to reset the password 

__Exceptions__
- a.  the user has entered the incorrect credentials, in this case the user will be notified of this and the "forgot username/password" functions will be presented clearly to the user
- b. the app has trouble communicating with our database due to low/no internet on the users device...notify them of this 
- c. the app has trouble communicating with our internal database due to a server/app issue... notify the user that we are experiencing difficulties

### Taazkir Nasir
### Use Case searching for individual products

__Name__: Search for an item

__Actors__: Authorized User

__Triggers__: User clicks the “Search Item” button

__Preconditions__: Logged in as authorized user and distance radius is set

__Flow of events__:
1.	User clicks the search icon.
2.	System presents the search bar.
3.	User focuses the search bar.
4.	System brings up keyboard to screen.
5.	System dynamically updates suggestions as user completes input.
6.	User unfocused search bar
7.	System disappears keyboard from screen.
8.	User selects item from list of suggestions.
9.	Systems processes API calls to retrieve price information.

__Postconditions__: System presents the cheapest price for the correct product within the specified radius

__Extensions__:
- User can search for individual items from the grocery list
- User can search for individual items from the previously ordered list

__Exceptions__:
1.	User fails to click suggestions after input is complete.
2.	User input is invalid.
3.	Item cannot be found in specified radius.

# Nonfunctional Requirements

### Upgrading to Premium Account
- Scalability factor in that a user can pay for premium access and gain an increased amount of uses per day.
- Connect a transaction service to the application to allow for payment processing.
- Would only be implemented in the future when application is fully fleshed out and working.
### Securing user Data
- User data will be encrypted and stored in a database
# External Requirements

### Running the application
If permitted the application will be launched through the Android app store. Will also be able to run through the Android simulator for Android developers. This is incase the application does not make it on the app store. All launch parameters will be included to be able to execute the application.

### Extensive Testing
Application will be unit tested thoroughly to ensure all bugs are handled. It will also be important to test the stress on the database, with users simultaneously making requests for information.

### Validating spelling of items
When the user is searching for items, there will be a spell checker built in to the search bar to make sure that all items sent to the API are spelled correctly. If a mispelled item is sent to the API, there will be an error message that the item is spelled wrong or is not available at any of the serchable stores.

# Team Process Description

### Software Toolset

#### GitHub
The repository will be used host in Github. This will allow each of the project to get completely familar with the technology. Industry practices will be heavily focsued upon. This includes needing reviews in order to confirm a merge request to main and frequent code reviews.

#### Android Studio
The application will be developed in Andriod Studio, so each team member will be familar with the work flow within it. Android Studio is important for the mobile application development and provides flawless integration with Firebase, the database chosen for this appliation.

#### Jira
Jira will be used to keep track of tasks that developers are working on. There will be a todo, in progress and done section. This will help our team reach milestones and make sure that the product will be finished on time.

### Team Member Roles & Justification

#### Tyler Thompson
Develop a stable relationship between the database and application. Ensure the database is being used properly. Also research and develop any algorithms that will be needed for application. Ensure everything is properly documented. Has prior knowledge with databases and many algorithms used within within industry applications.

#### Joseph Porrino
The API interface is the core of our product becuase it is how we will recieve the prices to display to our users. The data from the API will go through data analysis so that the user can choose options such as cheapest price or shortest distance. Joseph has experience working with API's and processing the data recieved from them.

### Mansib Syed Ahmed
Has prior knowledge and experience of developing applications in Android Studio. Write the core logic of the application in Kotlin to process data and input from the frontend.

#### Aaron Feinberg 
My primary responsibility will be to help translate conceptual ideas into functional features within the app. A significant part of my role will involve displaying data to the UI (frontend), ensuring smooth data flow and integration using the Model-View-Controller (MVC) architecture. I have experience with the MVC structure of DJango and am working through an online android app development course.

#### Taazkir Nasir
Finding the cheapest price for any given product is the main idea of this project. It provides the baseline functionality of the app, so carrying out this use case successfully will establish our product’s viability. An intuitive product design will make the app easy to use for users with limited technical capabilities. Taazkir will draw from previous experience with UI design and error handling to provide a professional look to the app.
### Milestones

#### Tyler Thompson
Done by 9/25/23
- Goal 1 : Research and understand Firebase, so that it will have a seemless integration with the application.
  
Done by 10/10/23
- Goal 2: Fully test and document database interaction with key features of application. This will help load testing.
  
Done by 10/30/23
- Goal 3: Help develop algorithms needed for the main part of the application. This could include finding optimal path.
  
Done by end of project
- Goal 4: Ensure all the code is easily changable and provide extensive amount of documentation on it. This will be done throughout the project.

#### Joseph Porrino
Done by 9/17/23
- Goal 1: Reseach what companies have API's and how to interface with them

Done by 9/24/23
- Goal 1: Create an API handler class that is univeral for all of the API's.

Done by 10/1/23
- Goal 1: Test that each of the API's is recieving requests and that data is recieved

Done by 10/8/23
- Goal 1: Design for how the items will be displayed in the grocery list

#### Aaron Feinberg 
Done by 09/24/23:
-  Research and understand the development process for an android app. This will involve creating a few demonstration apps to use as examples and practice

Done by 10/15/23:
- learn to design a system architecture for our specific project. I would  like to be able to accurately describe the flow of data (via a diagram) between the various parts of our program (user, database, api, etc)

#### Mansib Syed Ahmed
Done by 9/22/23
- Goal 1: Research android development and kotlin programming

Done by 10/6/23
- Goal 2: Write code to implement the logic for login, creating, adding, editing, deleting items, suggesting the cheapest option etc

Done by 10/13/23
- Goal 3: Write unit tests for individual functions and test the interaction between different parts of the application

Done by 10/31/23
- Goal 4: Polish and tweak code as per additional requirements

#### Taazkir Nasir
Done by 9/17/23
- Research and design the outline for login, home, search, grocery list screens.

Done by 9/24/23
- Research and establish security needs.

Done by 10/15/23
- Produce final GUI and UI design.

Done by 10/30/23
- Implement security features.

Done by 11/15/23
- Test all possible user interaction with the system to identify potential sources of error.

### Major Road Blocks

#### API Problems

- Depending on the APIs used within this application, they may provide major challenges when it comes to making calls between them all. They may all provide different results and the important data will need to be extracted effectively and efficiently. Each of these APIs need to provide extensive amount of information about the products.


