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
- Start to learn Jira to enhance scrum meetings.
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
- Began learning Jira for scrum workflow.
##### Next Week Goals
- Fully learn Jira.
- Try and lock in how the database will be used within the application. This will depend on if the information is retrieved when a user processes an order or if a script will run in the morning to update the database with generic items.
- Will work with Joe to fully flesh out what the application does with the web scrapper data.

### Joseph Porrino
#### Previous Goals
 
##### Key Points

##### Next Week Goals

### Aaron Feinberg
#### Previous Goals

##### Key Points

##### Next Week Goals


### Taazkir Nasir
##### Previous Goals

##### Key Points

##### Next Week Goals


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


