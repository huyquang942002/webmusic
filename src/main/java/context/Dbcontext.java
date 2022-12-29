/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbcontext {

    static final String URL_DB = "jdbc:mysql://localhost:3306/webmusic";
    static final String USER = "root";
    static final String PASS = "";

    public static Connection getConnection() {
	Connection cnt = null;
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    cnt = DriverManager.getConnection(URL_DB, USER, PASS);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return cnt;
    }
}
