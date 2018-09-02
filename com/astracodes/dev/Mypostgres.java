/* this program tests JDBC to Postgres */
package com.astracodes.dev;
import java.sql.*;

public class Mypostgres {
  static public void main(String args[]){
     //declare a variable of type Connection
     Connection connection = null;

     System.out.println("this program is a test for using JDBC to a Postgres database");

    // load the postgres jdbc driver
    try {
      Class.forName("org.postgresql.Driver").newInstance();
    }
    catch (Exception e) {
      e.printStackTrace();
      return;
    }

    // create a connection object
    try {
      connection = DriverManager.getConnection("jdbc:postgresql:postgres","root","newyork1");
      System.out.println("connection successful");
    }
    catch(SQLException e) {
       e.printStackTrace();
    }

   // create a statement object
   try {
     Statement statement = connection.createStatement();
     ResultSet resultset = statement.executeQuery("select * from pg_roles");
   
     while(resultset.next())
     {
        System.out.print("column 1 returned ");
        System.out.println(resultset.getString(1));

     }
     resultset.close();
     statement.close();
   }
   catch(SQLException e) {
     e.printStackTrace();
   }


  }
}
