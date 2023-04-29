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

@WebServlet("/edit")
public class editServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id1=Integer.parseInt(req.getParameter("id"));
		String name1=req.getParameter("nm");
		int age1=Integer.parseInt(req.getParameter("age"));
		long phone1=Long.parseLong(req.getParameter("ph"));
		String password1=req.getParameter("ps");
		
		Userdao dao=new Userdao();
		User user=new User();
		
		user.setId(id1);
		user.setAge(age1);
		user.setName(name1);
		user.setPassword(password1);
		user.setPhone(phone1);
		
		user=dao.updateUser(user);
		PrintWriter writer=resp.getWriter();
		writer.write("<html><body><h1>details are updated ID:"+user.getId()+"</h1></body></html>");
		
	}

}
