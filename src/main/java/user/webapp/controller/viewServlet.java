package user.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.webapp.dto.User;

public class viewServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id1=Integer.parseInt(req.getParameter("id"));
		String name1=req.getParameter("nm");
		int age1=Integer.parseInt(req.getParameter("age"));
		long phone1=Long.parseLong(req.getParameter("ph"));
		String password1=req.getParameter("ps");
		
		User u=new User();
		u.getId();
		u.getName();
		u.getAge();
		u.getPassword();
		u.getPhone();
		
	}

}
