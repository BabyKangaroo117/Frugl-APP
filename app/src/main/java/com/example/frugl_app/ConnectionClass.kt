package com.example.frugl_app

import android.os.StrictMode
import android.util.Log
import java.lang.Error
import java.sql.Connection
import java.lang.Exception
import java.sql.DriverManager
import java.sql.SQLException

/*
Connection class used to connect to database.
Information will be updated as database is implemented.
 */
class ConnectionClass {
    private val ip = "" // Database ip address.
    private val db = "" // Database name.
    private val userName = "" // User name for database login.
    private val password = "" // Password for database login.

    fun dbConn(): Connection? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        var connString : String? = null
        try {
            Class.forName("net.sourceforge.jtds.jtds.Driver")
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$userName;password=$password;"
            conn = DriverManager.getConnection(connString)
        }
        catch (ex1 : SQLException) {
            ex1.message?.let { Log.e("Error : ", it) }
        }
        catch (ex2 : ClassNotFoundException) {
            ex2.message?.let { Log.e("Error : ", it) }
        }
        catch (ex3 : Exception) {
            ex3.message?.let { Log.e("Error : ", it) }
        }

        return conn
    }
}