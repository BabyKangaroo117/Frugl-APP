# Date 10/11/2023
# Team Report

#### Previous Goals
- Provide everyone with a way to connect to database through application. This would be without the temporary login information. Must be secure.
- Decide on how information will be stored. This will determine how much this appliaction will depend on the database. If not information is stored within the application, then the database will only store user information and orders.
#### Key Points
- What was done
  - Talked about how data is stored. Decided to go on unit price of items to get the best overall deal.
  - Redefined the way the webscraper returns information.
  - Set up and redefined the GitHub projects to make it like scrum sprints.
  - Set up teams which are appointed to certain aspects of the application.
- What worked
  - Setting up github actions.
  - Adding JTBC driver.
- What was learned
  - How we want to store item prices which is by unit price. It makes it easier to compare the best deals for each store.
- Have trouble with
  - Connecting the database with JDBC Driver. Mostly problems with how the connection is established.
- Stuck on
  - Allowing access to the database through a pubilc network. Azure has a lot of security features.
#### Next Week Goals
- Keep trying to connect database and input sample data.

# Individual Reports

### Tyler Thompson
##### Previous Goals
- Fully learn how to make a scrum work flow in Github.
- Try and lock in how the database will be used within the application. This will depend on if the information is retrieved when a user processes an order or if a script will run in the morning to update the database with generic items.
- Will work with Joe to fully flesh out what the application does with the web scrapper data.
##### Key Points
- Refactored the JTDS driver and replaced it with JDBC driver. This is more updated to work with the Azure database. JDBC driver is the interface used to interact with the database.
- Created most of the tables for the database. Most of the way the information will be stored is now known.
- Set up a database team section in the GitHub projects section. Picked date estimates to try and have certain parts of the application completed by.
- Started to look into JDocs documentation pages that can be created.
##### Next Week Goals
- Fully learn JDoc documentation pages.
- Finish debugging the database connection with JTDS driver.
- Start adding test data to the database if everything goes smooth.

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

##### Key Points

##### Next Week Goals
