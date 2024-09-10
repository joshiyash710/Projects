package Hotel.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {
    Connection con;
    Statement statement;
    public connection(){
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS","root","yashsql710");
            statement=con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}