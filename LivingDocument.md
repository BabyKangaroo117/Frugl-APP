![image1](https://github.com/BabyKangaroo117/Frugl-APP/assets/13011373/b5efcc9f-946b-44ee-88cb-0036170282ff)

<img src="Frugl_Logo.png" width=200 height=200/>

# Team Info & Policies

### Team Members & Roles
- #### Tyler Thompson<br>
   __Role__: Provide functionality between application and database. Document project properly and reasearch useful techniques to speed up application. Backend engineer coupled with a data analysis in this case. Also create the web API that that each portion of the application will communicate with. Essential to making sure that the mobile data that is coming in is steady and can be read properly.
  

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

Frugl is a price comparison app that compares prices of grocery store items to find the cheapest price. A user can initiate a search for an item such as chicken breast. The app will then return locations to get chicken breast with prices in ascending order. The user can then save selected items in a shopping cart. The user can create an account and save up to 5 recent orders. 

__User Stories__:
- As a customer, I want to find the cheapest price for an item I am looking for, so that I can be frugal 
	- As a customer, I want to see a few options to buy the item from, so that I have the freedom to choose the option that is worth it for me
	- As a customer, I want to only see the options that are nearby, so that I am actually able to go to that store
	- As a customer, I want the items I looked for saved to my account, so that I don't have to look them up every time
	- As a customer, I want to be notified if a previously searched item has changed its price, so that I am aware of the pricing trends
	- As a customer, I want to be notified if a previously searched item can be found for even cheaper somewhere else, so that I can update where I do my shopping from


- As a customer, I want to be able to add my entire grocery list, so that I don't have to look up each item individually 
	- As a customer, I want to see the price for my entire grocery list, so that I can quickly determine where to do my weekly shopping from 
	- As a customer, I want the option to add to my grocery list when I view a product, so that I can seamlessly add to my list without changing screens

__Major Features__:
- A way to retrieve previous orders from the database.
- Selecting fastest route to each store based on order.
- Using webscrapers to collect grocery store data
- Creation of log in screen.
  
__Minor Features__:
- A premium version of the user account. This will be free unless major progress is made on transactions at the end of the project.
- Security enhancements with user information.
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
### Use Case Automated Webscraper

__Name__: Webscaper

__Actors__: Github Action

__Flow of events__:
1.	Github action triggers webscraper to collect data
2.	Webscraper organizes data into a json
3.	Request is made to database
4.	Data is inserted into tables in database

__Entry__:
- Github action
- Request to database API

__Exit__:
- Success in data sent to database
- Error scraping price data
- No connection to database

__Extensions__:
- None

__Exceptions__:
- Website changes layout breaking webscraper
- Database is not running

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

__Preconditions__: Logged in as an authorized user and the distance radius is set

__Flow of events__:
1.	User interacts with UI layer to start Search Item Activity 
2.	Data layer sends the user's search history to the UI layer
3.	User inputs search terms in the search bar. 
4.	Data layer listens for changes in the text input and dynamically updates the UI layer as the user completes input.
5.	User selects an item from the list of suggestions.
6.	Data layer sends user selection to the API layer to save the search term and request data.
7.	API layer requests database function for item store name, image, net/avg price, per unit price, weight
8.    Data layer receives data from the API layer.
9.    Data layer processes data and stores each variable as lists ie; list of images, list of per unit prices, etc 
10.  Data layer finds the lowest number from the price and unit price lists and uses those indices to make two lists
11. Data layer sends the lists to the UI layer
12. User can switch between per unit price or fixed price views in the UI layer
13. User selects an item to view
14. Data layers launch view item fragment 
15. User can click the add to grocery list button or exit the search item activity 

__Postconditions__: System presents the cheapest price for the correct product within the specified radius

__Extensions__:
- User can search for individual items from the grocery list
- User can search for individual items from the previously ordered list

__Exceptions__:
1.	User fails to click suggestions after input is complete.
2.	User input is invalid.
3.	Item cannot be found in a specified radius.

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

#### Data Acquistion

- Our data pipline is not very dynamic becuase we don't want to be bombarding websites with with webscrapes when ever a user searches an item. Instead we will be filling a database every few days with price data. Our database will start with only a pre selected set of items and then it will grow based on user searches. It will be difficult to automate this process because the selenium package for webscraping doesn't run well in cloud based systems.

# Software Architecture
### Major Software Components
- #### UI Layer:
  	- Components that make up the user interface of the application.
	- Consists of activites, fragments, views etc.
   	- Dictates the design, style, and layout of the app.
   	- Written in XML.
- #### Data Layer and Business Logic Layer:
	- Components that are used to implement the underlying logic and workflow of the application.
  	- Consists of functions, classes, and interfaces.
  	- Dictates functionality and processes data recieved from the databases.
  	- Written in Kotlin.
	- Components that deal with the data required for the application.
	- Consists of database communication and webscraper.
	- Stores and gets the data to send to web API.
	- Database written in SQL and webscraper in Python.
- #### API Layer
	- A web API that communicates from the data layer to the database.
 	- Needed in mobile applications to handle any possible network problems.
  	- Will run no .NET Core.
  	- Azure Web API
### Interfaces
- Action and event listeners act as interface between UI layer and logical layer. These are used to implement the functionalities of the UI components.
- Adapters allow for converting data in logical layer into views so that they can be added to the UI.
- Azure functions to help with error handling and connecting to API layer.
- Azure web API which uses a REST architecture.
- Github actions will interface with webscraper repo and run the script.
### Data
- Users will be stored within the database. Until the application is fully fleshed out, every user will be given a username and password without the need to go through a sign up process.
- A small range of the most popular items will be stored within the database, to let the script know what to scrape. The range of items will be around 70 to 100 and will feature the most popular grocery store items.
- Price information relative to the date will be stored within the database. The price to be more specific is dealing with the unit prices of each item.
- The stores information will be stored within the database.
- Orders will be stored within the database with the idea being, that a customer can go back to the five most recent orders.
### Reasoning
- Kotlin
  	- Popular and new industry standard for writing Android apps
  	- Easy to code and significantly less boilerplate compared to Java
  	- Runs on top of the Java Virtual Machine so has access to Java's plethora of libraries and frameworks
  	- Universally loved unlike Java
- .NET Core
	- Runs the web API using .NET Core
	- Deploys web app which is separate from the Frugl application.
- Microsoft Azure
	- Wanted to get a feel for a major companies software.
	- Has a free student subscription, which allows for $100 of free credit.
 	- Excellent security and load handling.
### Alternative Choices
- Java
  	- Pro: Already knew Java so wouldn't have to spend time learning a new programming language
  	- Cons: Frustrating to write code and universally hated unlike Kotlin
- NodeJS
	- Pro: Easy to set up.
 	- Con: Not up to speed with JavaScript.
 	- Coult have went with this instead of .NET Core.
- MySQL
	- A pro is that it is free.
 	- A con is that it would struggle if our application to run multiple scripts to scrape a numerous amount of stores at the same time. It would have a chance of crashing the database with so many inputs at the same time.
	- Could have used this for the database which is free. However, with the amount of web scrapping needing to be performed, Microsoft Azure felt like the right fit.

# Software Design
### Build Tools
- __Azure Deployment Center__
	- Create a .yml file that builds the API and deploys it whenever updates are made to the application.
 	- Allows for automation of workflow.
### Packages, Classes, and Abstraction
- [__Retrofit__](https://square.github.io/retrofit/)
- [JUnit](https://junit.org/)
- Selenium
### The Responsibilities of Each Package
- The Retrofit2 package allows Kotlin to easily make HTTP requests. This will be used with REST API structure.
- JUnit is a testing library that allows for the quick creation and execution of test functions. It executes Java and Kotlin Code.
- Selenium provides webscraping capabilites to collect data

### Utility Objects & Testing
- Sinlgeton utility objects will be used to ensure data being passed between layers is valid at a fundemental level 
- Will be developed using TDD (Test Driven Development) to maximize edge case catching 
- each utility file will pertain to a specific activity or group of activities  

# Coding Guidelines
### Plan to Include a User Guide
- The user guide will feature a description on how to use the app.
- Will provide users with a way to contact the developers.
- This guide will highlight the key features of the application that might be unknown to the user.
- Compnents will feature JDoc strings and comments
- New features will be implemented on separate branches and be pulled in 
### Kotlin
- Kotlin is the language of choice for this project. The Kotlin coding guideline will be followed in unison with KDoc help standardize the code throughout the project. Using KDocs allows a documentation page to be created.
- [__Kotlin Coding Guidelines__](https://kotlinlang.org/docs/coding-conventions.html)
- [__KDoc__](https://kotlinlang.org/docs/kotlin-doc.html)
### Python
-  PEP 8 guidline - https://peps.python.org/pep-0008/ 

# Risks
### Database API not Ensuring Connection is Stable
- The chance of this occuring is medium since we are using Azure REST API architecture. Functions are to be created to handle these types of scenarios. This will be done as an Azure function application. The process to make sure everything flows properly is rather complicated when viewing all this for the first time, so the programmers will try their best to make sure it is handled.
- The impact if this occurs is high since a unstable connection to the database could result in the entire database crashing and having incorrect values inserted. It is essential to make sure this works to the best of applications ability.
- Research had been done to take the easy approach and connect the database straight into the mobile application. While viewing countless other projects everyone concluded that doing that is a bad practice and should be avoided at all costs, unless you are only testing data with a constant connection.
- Plans for detecting this problem include having Azure functions to not allow the request through if it can not establish a complete connection.
- There is really no work around to this, if data is to be input in an incorrect fashion, the only hope would be that the connection is stable enough to not cause any problems.
- While creating the requirments document, none of this type of information was known yet as research was still being conducted. Now understanding the full architecture and design of a mobile application have brought this situation to light.
### Website Bot Protection
- During out analysis of which grocery stores to scrape data from, we found that many of them have strict bot rules. We found that wegmans and shoprite allow the use of bots, but this can change in the future.
- Webscraping has a high risk becuase if a website decides to add bot protection, then we will no longer be able to provide data to our users.
- There is no way to know if or when this could occur.
- We have no mitigation plan because there is no other source of grocery store data other than webscraping.
