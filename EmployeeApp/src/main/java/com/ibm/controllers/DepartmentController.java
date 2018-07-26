package com.ibm.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.dao.DepartmentDAO;
import com.ibm.model.Department;
import java.util.ArrayList;
/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/departments")
public class DepartmentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //get location id from form
		String param=request.getParameter("loc");
		int id=Integer.parseInt(param);
		
		//get list of department by using DAO
		DepartmentDAO dao=new DepartmentDAO();
		ArrayList<Department> depts=dao.getDeptbyLoc(id);
		//add attributes as a request
		request.setAttribute("departments", depts);
		
		RequestDispatcher disp=request.getRequestDispatcher("departmentlist.jsp");
     disp.forward(request, response);
	}

}
