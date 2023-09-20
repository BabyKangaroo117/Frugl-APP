# Setting up the Microsoft SQL Database

### Install necessarry requirements

- [Microsoft SQL Server download (Developer Version)](https://www.microsoft.com/en-us/sql-server/sql-server-downloads)
- [SQL Server Management Studio](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16)

### Setup SQL Server

- Refer to [SQL Server setup](https://learn.microsoft.com/en-us/sql/sql-server/install/what-s-new-in-sql-server-installation?view=sql-server-ver16)
- Setup basic installation of SQL Server <img src="DatabaseSetup1.jpg" width=1500 height=500/>
- Proceed with basic setep and modify any needed parameters.
- After SQL server is setup, start SQL Server Management Studio. Refer to [SQL Server Management Setup](https://learn.microsoft.com/en-us/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver16)
- Connect to the server that has been setup.
  
### How Database Will Work with Frugl
- User information will be sent to database (Examples include username and password).
- User data will be queried from the database (Example includes recent orders).
