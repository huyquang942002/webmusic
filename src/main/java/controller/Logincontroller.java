/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {

    private UserDao dao;

    @Override
    public void init() throws ServletException {
	super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
	dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try {
	    HttpSession session = request.getSession();
	    String user_session = (String) session.getAttribute("user_session");
	    if (user_session != null) {
		request.getSession(false).invalidate();
	    }
	    String email = request.getParameter("email");
	    String pass = request.getParameter("password");
	    if (dao.validate(email, pass)) {
		Account tmp = dao.getItem(email);
		session.setAttribute("user_session", tmp);
		
		if (tmp.getAdmin() == 0) {
		    response.sendRedirect(request.getContextPath() + "/admin");
		} else {
		    response.sendRedirect(request.getContextPath() + "/home");
		}

	    } else {
		request.setAttribute("notify", false);
		request.getRequestDispatcher("view/loginfail.jsp").forward(request, response);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    request.setAttribute("notify", false);
	    request.getRequestDispatcher("view/loginfail.jsp").forward(request, response);
	}
    }

}
