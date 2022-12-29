package controller;

import dao.AdminDao;
import model.Music;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import javax.servlet.RequestDispatcher;

@WebServlet("/admin")
public class AdminController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private AdminDao dao;

    @Override
    public void init() throws ServletException {
	super.init(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
	dao = new AdminDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try {

	    String theCommand = request.getParameter("command");
	    if (theCommand == null) {
		theCommand = "LIST";
	    }
	    switch (theCommand) {
		case "LIST":
		    list(request, response);
		    break;
		case "ADD":
		    add(request, response);
		    break;
		case "LOAD":
		    load(request, response);
		    break;
		case "UPDATE":
		    update(request, response);
		    break;
		case "DELETE":
		    delete(request, response);
		    break;
		default:
		    list(request, response);
	    }

	} catch (Exception exc) {
	    throw new ServletException(exc);
	}
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	// read student id from form data
	String musicId = request.getParameter("musicID");

	//delete student from database
	dao.delete(musicId);

	//send them back to the "list students" page
	list(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	int id = Integer.parseInt(request.getParameter("musicId"));
	String name = request.getParameter("name");
	String path = request.getParameter("path");
	String image = request.getParameter("image");
	String singer = request.getParameter("singer");
	Music m = new Music(id, name, path, image, singer);

	dao.update(m);
	//send them back to the "list students" page
	list(request, response);
    }

    private void load(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	// read student id from form data
	String id = request.getParameter("musicID");

	Music m = dao.getItem(id);
	request.setAttribute("item", m);
	request.getRequestDispatcher("/view/edit-song.jsp").forward(request, response);

    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws Exception {
	//read student infor from data
	String name = request.getParameter("name");
	String path = request.getParameter("path");
	String image = request.getParameter("image");
	String singer = request.getParameter("singer");
	Music m = new Music(name, path, image, singer);
	System.out.println(m.toString());
	log(m.toString());
	dao.add(m);
	//create student object
//	Student theStudent = new Student(firstName, lastName, userName, passWord, email, phoneNumber);

	//add student to the database
//	studentDbUtil.addStudent(theStudent);
	//send back to the main page
	list(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {

	// get students from db util
	List<Music> list = dao.findAll();

	// add students to the request
	request.setAttribute("listMusic", list);

	// send to JSP page (view)
	RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin.jsp");
	dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
