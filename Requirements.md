![image1](https://github.com/BabyKangaroo117/Frugl-APP/assets/13011373/b5efcc9f-946b-44ee-88cb-0036170282ff)

<img src="Frugl_Logo.png" width=200 height=200/>

# Team Info & Policies

### Team Members & Roles
- #### Tyler Thompson<br>
   __Role__: Provide functionality between application and database. Document project properly and reasearch useful techniques to speed up application. Backend engineer coupled with a data analysis in this case.

- #### Joseph Porrino<br>
   __Role__: Full stack engineer. Provide functionality between application and API’s. Design and create a UI to display grocery store items.
  
### Repository
- [Link to repository](https://github.com/BabyKangaroo117/Frugl-APP)

### Communication Channels

#### Frequent Scrum Meetings
This will be held through Microsoft Teams, and will provide a strong and consistent workflow.

# Product Discription

Frugl is a price comparison app that compares prices of grocery store items to find the cheapest price. Companies that have made their data public through API’s will be used in the comparison. A user can initiate a search for an item such as chicken breast. The app will then return locations to get chicken breast with prices in ascending order. The user can then save selected items in a shopping cart. The user can create an account and save up to 5 recent orders. 

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



# Nonfunctional Requirements

### Upgrading to Premium Account
- Scalibility factor in that a user can pay for premium access and gain an increased amount of uses per day.
- Connect a transaction service to the application to allow for payment processing.
- Would only be implemented in the future when application is fully fleshed out and working.

### Securing user Data
- User data will be encrypted and stored in a database
  
# External Requirements

### Running the application
If permitted the application will be launched through the Andriod app store. Will also be able to run through the Android simulator for Android developers. This is incase the application does not make it on the app store. All launch parameters will be included to be able to excute the application.

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

### Major Road Blocks

#### API Problems

Depending on the APIs used within this application, they may provide major challenges when it comes to making calls between them all. They may all provide different results and the important data will need to be extracted effectively and efficiently. Each of these APIs need to provide extensive amount of information about the products.

