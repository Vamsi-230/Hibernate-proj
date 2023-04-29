package user.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.webapp.dao.Userdao;
import user.webapp.dto.User;

@WebServlet("/reg")
public class registerServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String name=req.getParameter("nm");
		int age=Integer.parseInt(req.getParameter("age"));
		long phone=Long.parseLong(req.getParameter("ph"));
		String password=req.getParameter("ps");
		
		
		Userdao dao=new Userdao();
		User u=new User();
		u.setName(name);
		u.setAge(age);
		u.setPhone(phone);
		u.setPassword(password);
		

		u=dao.saveUser(u);
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body><h1>You are registered with ID:"+u.getId()+"</h1></body></html>");
	}
}
