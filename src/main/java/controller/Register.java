/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDao;
import model.Account;
import model.Music;
import model.UserError;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    private UserDao dao;

    @Override
    public void init() throws ServletException {
	super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
	dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try ( PrintWriter out = response.getWriter()) {

	    String url = "view/register.jsp";
	    UserDao dao = new UserDao();
	    UserError userError = new UserError();

	    try {

		String name = request.getParameter("name");
		String passWord = request.getParameter("pass");
		String email = request.getParameter("email");

		Account account = new Account(name, passWord, email);

		boolean checkVal = true;

		if (dao.checkDupEmail(email)) {
		    userError.setEmail("This email has been registered!");
		    url = "view/register.jsp";
		    checkVal = false;
		}

		if (checkVal) {
		    if (dao.add(account)) {
			url = "view/login.jsp";
			userError.setEmail("Register Success!");
		    }
		} else {
		    request.setAttribute("USER_ERROR", userError);
		    request.setAttribute("USER_SUCCESS", userError);
		}

	    } catch (Exception e) {
		log("Error at Create controller" + e.toString());
		if (e.toString().contains("message")) {
		    userError.setError("Can not register, please try again later!");
		}
	    } finally {
		request.getRequestDispatcher(url).forward(request, response);
	    }
	}
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
	request.getRequestDispatcher("view/login.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//read student infor from data
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
	int role = 1;
	Account m = new Account(name, pass, email, role);
	System.out.println("account");
	System.out.println(m.toString());
	System.out.println("account");
	log(m.toString());
	dao.add(m);
	login(request, response);
    }

}
