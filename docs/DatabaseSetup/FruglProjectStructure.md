# Application Structure
<img src="https://img.shields.io/badge/Still_In Progress-Can_Change-orange" /></a>

### Suggestions can be put into issues section.
<img src="Application_Frugl_Structure.jpg" width=1000 height=500/>

# Database Tables

### User Table
- Primary Key - UserID
- Username
- Password
- Email

### Orders
- Primary Key - OrderID
- UserID
- Date
- Items

### Items
- Primary Key - ItemID
- ItemName

### AreaItems
- Primary Key - StorePostalCode, ItemID
- Giant_Unit_Price
- Shoprite_unit_Price
- Wegmans_Unit_Price

### OrdersItems
- Primary Key - OrderID, ItemID

### PostalCodes
- Primary Key - PostalCode
