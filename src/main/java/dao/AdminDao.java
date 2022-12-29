/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import context.Dbcontext;
import model.Music;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
	private AdminDao dao;

    public void add(Music music) throws Exception {
    	

	Connection myConn = null;
	PreparedStatement myStmt = null;

	try {
	    // get db connection
	    myConn = Dbcontext.getConnection();

	    // create sql for insert
	    String sql = "insert into music "
		    + "(name,path,image, singer)"
		    + "values (?, ?, ?, ?)";

	    myStmt = myConn.prepareStatement(sql);

	    // set the param values for the student
	    myStmt.setString(1, music.getName());
	    myStmt.setString(2, music.getPath());
	    myStmt.setString(3, music.getImage());
	    myStmt.setString(4, music.getSinger());
	    // execute sql insert
	    myStmt.execute();
	} finally {
	    // clean up JDBC objects
	    close(myConn, myStmt, null);
	}
    }

    public void update(Music music) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;

	try {
	    // get db connection
	    myConn = Dbcontext.getConnection();

	    // create SQL update statement
	    String sql = "update music "
		    + "set name=?, path=?,image=?,singer=?"
		    + "where id=?";

	    // prepare statement
	    myStmt = myConn.prepareStatement(sql);

	    // set params
	    myStmt.setString(1, music.getName());
	    myStmt.setString(2, music.getPath());
	    myStmt.setString(3, music.getImage());
	    myStmt.setString(4, music.getSinger());
	    myStmt.setInt(5, music.getId());

	    // execute SQL statement
	    myStmt.execute();
	} finally {
	    // clean up JDBC objects
	    close(myConn, myStmt, null);
	}
    }

    public void delete(String musicId) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;

	try {
	    //convert student id to int
	    int mId = Integer.parseInt(musicId);

	    //get connection to database
	    myConn = Dbcontext.getConnection();

	    // create SQL delete statement
	    String sql = "delete from music where id = ?";

	    // prepare statement
	    myStmt = myConn.prepareStatement(sql);

	    // set params
	    myStmt.setInt(1, mId);

	    // execute SQL statement
	    myStmt.execute();

	} finally {
	    close(myConn, myStmt, null);
	}

    }
    
    

    public List<Music> findAll() throws Exception {

	List<Music> list = new ArrayList<>();

	Connection myConn = null;
	Statement myStmt = null;
	ResultSet myRs = null;

	try {
	    // get a connection
	    myConn = Dbcontext.getConnection();

	    // create sql statement
	    String sql = "select * from music";

	    myStmt = myConn.createStatement();

	    // execute query
	    myRs = myStmt.executeQuery(sql);

	    // process result set
	    while (myRs.next()) {

		// retrieve data from result set row
		int id = myRs.getInt("id");
		String name = myRs.getString("name");
		String path = myRs.getString("path");
		String image = myRs.getString("image");
		String singer = myRs.getString("singer");

		Music m = new Music(id, name, path, image, singer);
		list.add(m);
	    }

	    return list;
	} finally {
	    // close JDBC objects
	    close(myConn, myStmt, myRs);
	}
    }
    
    
    public List<Music> findAllByID(String search) throws Exception {

    	List<Music> list = new ArrayList<>();

    	Connection myConn = null;
    	Statement myStmt = null;
    	ResultSet myRs = null;

    	try {
    	    // get a connection
    	    myConn = Dbcontext.getConnection();

    	    // create sql statement
    	    String sql = "select * from music where id = ?";

    	    myStmt = myConn.createStatement();
    	    // execute query
    	    myRs = myStmt.executeQuery(sql);

    	    // process result set
    	    while (myRs.next()) {

    		// retrieve data from result set row
    		int id = myRs.getInt("id");
    		String name = myRs.getString("name");
    		String path = myRs.getString("path");
    		String image = myRs.getString("image");
    		String singer = myRs.getString("singer");

    		Music m = new Music(id, name, path, image, singer);
    		list.add(m);
    	    }

    	    return list;
    	} finally {
    	    // close JDBC objects
    	    close(myConn, myStmt, myRs);
    	}
        }
    
    
    public List<Music> searchByname(String search) throws SQLException  {

    	List<Music> list = new ArrayList<>();
    	
    	String sql = "select * from music where name like ?";

    	Connection myConn = null;
    	PreparedStatement myStmt = null;
    	ResultSet myRs = null;

    	try {
    	    // get a connection
    	    myConn = Dbcontext.getConnection();
    	    // create sql statement
    	    myStmt = myConn.prepareStatement(sql);
    	    
    	    myStmt.setString(1,"%"+search+"%");

    	    // execute query
    	    myRs = myStmt.executeQuery();

    	    // process result set
    	    while (myRs.next()) {

    		// retrieve data from result set row
    		int id = myRs.getInt("id");
    		String name = myRs.getString("name");
    		String path = myRs.getString("path");
    		String image = myRs.getString("image");
    		String singer = myRs.getString("singer");

    		Music m = new Music(id, name, path, image, singer);
    		list.add(m);
    	    }

    	    return list;
    	} finally {
    	    // close JDBC objects
    	    close(myConn, myStmt, myRs);
    	}
        }
    
    
    

    public Music getItem(String id) throws Exception {

	Music music = null;

	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;

	int musicId;


	try {
	    // convert student id to int
	    musicId = Integer.parseInt(id);

	    // get connection to database
	    myConn = Dbcontext.getConnection();

	    // create sql to get selected student
	    String sql = "select * from music where id=?";

	    // create prepared statement
	    myStmt = myConn.prepareStatement(sql);

	    // set params
	    myStmt.setInt(1, musicId);

	    // execute statement
	    myRs = myStmt.executeQuery();

	    // retrieve data from result set row
	    if (myRs.next()) {
		String name = myRs.getString("name");
		String image = myRs.getString("image");
		String path = myRs.getString("path");
		String singer = myRs.getString("singer");

		// use the studentId during construction
		music = new Music(musicId, name, path, image, singer);
	    } else {
	    }

	    return music;
	} finally {
	    // clean up JDBC objects
	    close(myConn, myStmt, myRs);
	}
    }
    

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

	try {
	    if (myRs != null) {
		myRs.close();
	    }

	    if (myStmt != null) {
		myStmt.close();
	    }

	    if (myConn != null) {
		myConn.close();   // doesn't really close it ... just puts back in connection pool
	    }
	} catch (Exception exc) {
	    exc.printStackTrace();
	}
    }
}
