package dao;

import context.Dbcontext;
import model.Account;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    static final String LOGIN = "SELECT * FROM account " + "WHERE email = ? AND password = ?";
    static final String INSERT = "INSERT INTO account(name,password,email,admin) VALUES(?,?,?,?)";
    static final String CHECKDUPEMAIL = "SELECT name,email,password FROM account WHERE email=?";
    static final String GET_USER = "SELECT * FROM account";
    static final String LOAD_USER = "SELECT * FROM account where email = ?";
    static final String UPDATE_USER = "UPDATE account SET first_name=?, last_name=?,username=?,password=?, email=?,phonenumber=? WHERE id=?";

    public boolean validate(String email, String pass) {
	boolean success = false;
	try {
	    Connection cnt = Dbcontext.getConnection();
	    PreparedStatement psmt = cnt.prepareStatement(LOGIN);
	    psmt.setString(1, email);
	    psmt.setString(2, pass);
	    System.out.println(psmt);
	    ResultSet rs = psmt.executeQuery();
	    if (rs.next()) {
		success = true;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return success;
    }

    public Account validate1(String email, String pass) throws Exception {
	Account resultUser = null;
	Connection cnt = Dbcontext.getConnection();
	PreparedStatement psmt = cnt.prepareStatement(LOGIN);
	psmt.setString(1, email);
	psmt.setString(2, pass);
	ResultSet rs = psmt.executeQuery();
	if (rs.next()) {
	    resultUser = new Account();
	    resultUser.setId(rs.getInt("id"));
	    resultUser.setName(rs.getString("name"));
	    resultUser.setPassWord(rs.getString("password"));
	    resultUser.setEmail(rs.getString("email"));
	    resultUser.setAdmin(rs.getInt("admin"));
	}
	return resultUser;
    }

    public boolean add(Account account) throws SQLException {
	boolean success = false;
	Connection cnt = null;
	PreparedStatement psmt = null;
	try {
	    cnt = Dbcontext.getConnection();
	    if (cnt != null) {
		psmt = cnt.prepareStatement(INSERT);
		psmt.setString(1, account.getName());
		psmt.setString(2, account.getPassWord());
		psmt.setString(3, account.getEmail());
		psmt.setInt(4, 1);
		success = psmt.executeUpdate() > 0;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (psmt != null) {
		psmt.close();
	    }
	    if (cnt != null) {
		cnt.close();
	    }
	}
	return success;
    }

    // true if email existed?
    public boolean checkDupEmail(String email) throws SQLException {
	boolean check = false;
	Connection cn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	try {
	    cn = Dbcontext.getConnection();
	    if (cn != null) {
		pst = cn.prepareStatement(CHECKDUPEMAIL);
		pst.setString(1, email);
		rs = pst.executeQuery();
		if (rs.next()) {
		    check = true;
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (pst != null) {
		pst.close();
	    }
	    if (cn != null) {
		cn.close();
	    }
	    if (rs != null) {
		rs.close();
	    }
	}
	return check;
    }

    // Hien thi danh sach account
    public List<Account> findAll() throws SQLException {
	List<Account> user = new ArrayList<>();
	Connection cn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	try {
	    cn = Dbcontext.getConnection();
	    if (cn != null) {
		pst = cn.prepareStatement(GET_USER);
		rs = pst.executeQuery();
		while (rs.next()) {
		    int id = rs.getInt("id");
		    String name = rs.getString("name");
		    String password = rs.getString("password");
		    String email = rs.getString("email");

		    user.add(new Account(id, name, password, email));
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    if (rs != null) {
		rs.close();
	    }
	    if (pst != null) {
		pst.close();
	    }
	    if (cn != null) {
		cn.close();
	    }
	}
	return user;
    }

    public Account getItem(String theStudentId) throws Exception {

	Account user = null;
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;

	try {
	    // get connection to database
	    myConn = Dbcontext.getConnection();

	    // create sql to get selected student
	    String sql = LOAD_USER;

	    // create prepared statement
	    myStmt = myConn.prepareStatement(sql);

	    // set params
	    myStmt.setString(1, theStudentId);

	    // execute statement
	    myRs = myStmt.executeQuery();

	    // retrieve data from result set row
	    if (myRs.next()) {
		String name = myRs.getString("name");
		String passWord = myRs.getString("password");
		String email = myRs.getString("email");
		int role = myRs.getInt("admin");
		// use the studentId during construction
		user = new Account(name, passWord, email, role);
	    } else {
	    }

	    return user;
	} finally {
	    if (myRs != null) {
		myRs.close();
	    }
	    if (myStmt != null) {
		myStmt.close();
	    }
	    if (myConn != null) {
		myConn.close();
	    }
	}
    }

    public void update(Account user) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;

	try {
	    // get db connection
	    myConn = Dbcontext.getConnection();

	    // create SQL update statement
	    String sql = UPDATE_USER;

	    // prepare statement
	    myStmt = myConn.prepareStatement(sql);

	    // set params
	    myStmt.setString(1, user.getName());
	    myStmt.setString(2, user.getPassWord());
	    myStmt.setString(3, user.getEmail());
	    myStmt.setInt(4, user.getId());

	    // execute SQL statement
	    myStmt.execute();
	} finally {
	    close(myConn, myStmt, null);
	}
    }

    public void delete(String theStudentId) throws Exception {

	Connection myConn = null;
	PreparedStatement myStmt = null;

	try {
	    // convert student id to int
	    int id = Integer.parseInt(theStudentId);

	    // get connection to database
	    myConn = Dbcontext.getConnection();

	    // create SQL delete statement
	    String sql = "delete from account where id = ?";

	    // prepare statement
	    myStmt = myConn.prepareStatement(sql);

	    // set params
	    myStmt.setInt(1, id);

	    // execute SQL statement
	    myStmt.executeUpdate();

	} catch (Exception e) {

	} finally {
	    close(myConn, myStmt, null);
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
