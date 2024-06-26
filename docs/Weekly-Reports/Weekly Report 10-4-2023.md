# Date 10/4/2023
# Team Report

#### Previous Goals
- Connect Database to the application.
- Keep improving on web scrapper.
- Flesh out front end portion.
#### Key Points
- What was done
	- Refactored ConnectionClass.kt to be a function.
	- Updated most documentation and started incorporating KDoc format.
	- Started work on MVP for front end.
		 - Added item search page.
		 - Added more features to front portion.
		 - Created database login information.
- Start to learn how to use projects in GitHub to enhance scrum meetings.
- What worked
	- Temporary database connection from application.
	- Created temporary list for searching items.
- What was learned
	- Started researching Python Anywhere to host webscrapper script.
	- Researching ways to run the database, to have it be resource efficent.
	- Researching backend techniques to allow application to flow smoothly.
	- Found a more efficient way search for items in the application using a recycler view.
- Have trouble with
	- Distributing database information saftly to the team.
	- Figuring out how to get accurate information on grocery store items accurately and fast.
- Stuck on
	- Major roadblock in the way data is to be retrieved. Debating on putting information into database or giving it dynamically to the user at the process of an order.
	- Retrieving items from websites.
#### Next Week Goals
- Provide everyone with a way to connect to database through application. This would be without the temporary login information. Must be secure.
- Decide on how information will be stored. This will determine how much this appliaction will depend on the database. If not information is stored within the application, then the database will only store user information and orders.

# Individual Reports

### Tyler Thompson
##### Previous Goals
- Begin connecting database to the application.
- Flesh out tables and ER diagram for the database.
##### Key Points
- Database how to be reconfigured and ER diagram was rethought to in case we decide on going with the new method of data retrieval.
- This put a stop on connecting database to application. Focused attention on views and how the database will interact with data.
- Began learning projects in GitHub for scrum work flow.
##### Next Week Goals
- Fully learn how to make a scrum work flow in Github.
- Try and lock in how the database will be used within the application. This will depend on if the information is retrieved when a user processes an order or if a script will run in the morning to update the database with generic items.
- Will work with Joe to fully flesh out what the application does with the web scrapper data.

### Joseph Porrino
#### Previous Goals
 Create a web scraper to gather Wegmans data using python
##### Key Points
Gathered the name, price, and image for food items on a webpage and saved the data as a dictionary.
Looked into services to host python script so that we can automate the webscraper to update our database. 
##### Next Week Goals
Automate the webscraper to search many items at once
Connect to the database
Host the python script on github and use a cron schedule to update the database

### Aaron Feinberg
#### Previous Goals
- Along with continuing to learn the android studio environment, I would like to start adding documentation to GitHub about the android studio development process. I will also include a small blurb about gradle as i just found out it is the tool which automatically gets dependencies one may need to run our program. I would also like to get through the next 2 sections of my Udemy course

##### Key Points
- Configured GitHub Projects Page for team based views with goals/milestones with Tyler 
- Created Documentation for Android Studio Views ViewGroups (will upload to teams)
- Learned That basically no service whatsoever allows you to get prices/data from an api...must use another form of data collection 

##### Next Week Goals
- write unit tests for UI Activities 
- collaborate with UI team to create a standardized layout for our app to be shared among activities 
- look into location data for our app (with Syed) 

### Taazkir Nasir
##### Previous Goals
- Complete the tutorial and update the existing UI
- Create and implement wireframe design for the main, login, signup, and search page
- Create Sequence Diagrams

##### Key Points
- We're working out the kinks of presenting the lowest-priced item to the user, and the logic behind calculating it. 
- Just sorting by lowest price often yields related, but undesired items. Due to variations in packaging size, sometimes the lowest-priced item is not the "best deal".  
- Should we present only the cheapest option? Maybe a list of the 5 cheapest? 
- Should they be categorized by store, price, or distance? 
- Due to the above issues, the sequence diagrams will be pushed back till a tentative solution is reached
- Implemented wireframe design for main, login, and signup
##### Next Week Goals
- Extend signup activity to get all pertinent user information 
- Create a few more mockups of the search page to visualize the final output
- Create user stories to flush out all possible functional requirements 

### Syed Ahmed
##### Previous Goals
- My goal last week was to create a new activity that implements creating shopping list feature. This feature allows the user to create their own shopping list by searching for their desired items, and then selecting and adding items from the suggestions in the drop down. Additionally, I have implemented the feature to add multiple quantities of an item and delete items as per the user's needs. I have accomplished this goal using two approaches. One with ListView class that's simpler to implement but less efficient, and the other with RecyclerView that's more smooth and efficient but more complex in terms of writing and debugging code. In the coming weeks, I will tweak my approach according to the needs and requirements for our app.

##### Key Points
- Added feature: create shopping list
- Implemented using both ListView and RecyclerView

##### Next Week Goals
- write unit tests for CreateList activity
- implement filters such as distance, bugdget, no of stores etc.
- look into Google Maps API integration


