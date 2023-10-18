# Application Structure
<img src="https://img.shields.io/badge/Still_In Progress-Can_Change-orange" /></a>

### Suggestions can be put into issues section.
<img src="Application_Frugl_Structure.jpg" width=1000 height=500/>

# Database Tables

### User Table
- Primary Key - UserID
- Username
- Password

### Orders
- Primary Key - OrderID
- UserID
- Date
- Items

### Items
- Primary Key - ItemID
- ItemName

### Stores
- Primary Key - StoreName, StorePostalCode
- StoreAddress

### AreaItems
- Primary Key - StorePostalCode, ItemID
- StoreName
- ItemPrice
