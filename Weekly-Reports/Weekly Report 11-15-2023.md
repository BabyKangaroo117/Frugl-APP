# Date 11/15/2023
# Team Report

#### Previous Goals
- Create the Alpha build.
- Test API connection calls within the application. Also test web scrapper through API.
#### Key Points
- What was done
  - Lots of testing.
  - Inputing real world data.
  - Made the user manual.
  - Test the application on other environments.
- What worked
  - Taking data from the API.
- What was learned
  - How to bug test efficiently.
- Have trouble with
  - A nasty API bug that sometimes trys to insert more into the database then it should.

#### Next Week Goals
- The the beta release fully fleshed out and working.


# Individual Reports

### Tyler Thompson
##### Previous Goals
- Continue to work on Alpha build.
- Try and help debug any problems created from the API.
##### Key Points
- Continued to input real data into API.
- Fixed more bugs in API.
##### Next Week Goals
- Help ensure the beta build works with the API well.
- Continue testing everything.
  
### Aaron Feinberg
#### Previous Goals
- finish setting up the final rank activity
- perform a test call to the API and have it display information correctly within the activity
- link the api to all other acitivities as needed
- prepare for the alpha demonstration by testing the basic functionality of our app 
  
##### Key Points
- Successfully implemented the backend-to-api interface
- data is now "parcelized" between activities
- presented with my team for the alpha release

What Im Stuck on
- finding the best implementation for the final rank activity. Id like to be able to present the best option for users (which store to visit) as well as the price of their shopping cart for each store. 

##### Next Week Goals
- improve the rank activity for displaying the best store to visit
- write tests for the backend (might create util functions)
- try out some integration tests 

### Taazkir Nasir
##### Previous Goals
- Use the API to populate the search results with items from the database 
- Make sure the user's flow between activities is working according to design across the whole app

##### Key Points
- For the alpha, I kept the dummy data in since it was a proof of concept demonstration and the other activities do not have real data yet. 
- Added more dummy data for the search page to give a full demo
- Finalized the UI design. There are a few more activities to be added like Maps so it should be seamless to integrate them into the front end now
- Data persistence is still an issue and will be looking into that all of next week.
##### Next Week Goals
- Research the lifecycle of activities and integrate methods other then onCreate it in our project according to the use cases, possibly make a diagram to plan/show the lifecycles.

### Syed Ahmed
##### Previous Goals
- Modify and refactor existing code to allow for smoother integration with backend-api

##### Key Points
- My goal this week is to work with Tyler to integrate the backend api layer with the android app. In general, the separate parts of the application work as intended so we just need to combine them altogether

##### Next Week Goals
- Finalize aplha build

### Joseph Porrino
##### Previous goals
- Connect to the database and add data
- Add more unit tests
- Figure out issue with standardizing units
- Help with finishing up kotlin development
##### Keypoints
- Connected to database from python end but ran into issues with AreaItems table
- Made changes to controllers to allow for multiple key inputs due to composite keys
##### Next Week Goals
- Finish up web scraper
- Currently have to manually add data using a sql command because of bug with AreaItems table

