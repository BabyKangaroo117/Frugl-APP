package com.example.frugl_app

import android.os.StrictMode
import android.util.Log
import java.sql.Connection
import java.lang.Exception
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Connects to a database. Ensure all parameters are correctly entered.
 */
fun connectDB(ip: String, databaseName: String, userName: String, password: String): Connection? {
    val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
    StrictMode.setThreadPolicy(policy)
    var conn : Connection? = null
    try {
        Class.forName("net.sourceforge.jtds.jtds.Driver")
        var connString  : String? = "jdbc:jtds:sqlserver://$ip;databaseName=$databaseName;user=$userName;password=$password;"
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