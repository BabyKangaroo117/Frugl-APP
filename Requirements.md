# Team Info & Policies

# Product Discription

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
- User is not authenticated
- User has no internet connection

# Nonfunctional Requirements

# External Requirements

# Team Process Description
