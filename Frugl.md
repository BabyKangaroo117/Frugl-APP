![image1](https://github.com/BabyKangaroo117/Frugl-APP/assets/13011373/b5efcc9f-946b-44ee-88cb-0036170282ff)

<img src="Frugl_Logo.png" width=200 height=200/>

Taazkir Nasir, Joesph Porrino, Aaron Feinberg, Syed Ahmed, Tyler Thompson 
**Professor Nate Wagenhoffer **

# What is Frugl? 

Frugl is a price comparison app that compares prices of grocery store items and restaurants to find the cheapest price. Companies that have made their data public through API’s will be used in the comparison. The first feature of the app is the grocery store comparison. A user can initiate a search for an item such as chicken breast. The app will then return locations to get chicken breast with prices in ascending order. The user can then save selected items in a shopping cart. The second feature is to compare restaurant prices. A user can initiate a search for an item such as baked ziti. The app will then return a list of restaurants that serve baked ziti with the prices in ascending order. If the restaurant allows for delivery, then the user can make the delivery through the app. 

# Objective (Vision and Competitive Analysis) 

After doing analysis on similar apps to Frugl, we found that there is not an app that does exactly what ours will do. What sets our app apart is that it will compare grocery store items, whether they are on sale or not. The other price comparison apps only compare items that are on sale. We also combine the grocery store service with a restaurant service, which is unique to our project. A user should be able to make a search for a general item (such as paper towels) and find the nearest product matching that description. He or she is not locked into the search results of a particular company or vendor. 

# Technical Approach 

The system architecture for this project includes a phone application that connects to a database to retrieve user information. From the information that was retrieved, the application will be able to sign the user in and remember a varying number of previous orders from the user. From this the user will then send requests to certain APIs that will retrieve the necessary information for the order and process it or tell the user where to go.

The technologies used within this application will allow the programmers to get a solid understanding of how it will function in a real world scenario. This application will be developed through Android Studio using Kotlin. Since Android Studio will be used, the front end portion of the application will be developed using XML. The repository will be GitHub. The database needed for this project will be Firebase which has wonderful integration with Android Studio. A package that can track the user’s location will also be needed for the application to function. Finally, various APIs will be called from other companies, which will allow the calculation of the food totals to be processed. Security for this application will be emphasized. In addition to that, proper documentation and logging will also be heavily encouraged to try and simulate a real world programming environment. 
# Key Development Tools  

- IDE – Android Studio  
- Front End – XML 
- Back End – Kotlin 
- Database – Firebase 
- SVC – GitHub  
# Challenge to Overcome 

One of the main challenges for us to overcome is being able to find enough companies that offer APIs for us to be able to compare prices. We want to be able to provide an accurate result for the cheapest grocery store item in a user's location. The technical aspect of calling all the API’s and sorting through the data is also going to be a challenge because each API is going to have a different means of collecting the data. In addition, search a user makes on our app will require querying a particular multiple times, we will have to consider an approach that offloads some of the burden on our vendors’ APIs.
