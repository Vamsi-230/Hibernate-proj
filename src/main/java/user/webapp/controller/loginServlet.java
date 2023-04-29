package user.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.webapp.dao.Userdao;
import user.webapp.dto.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet
{
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		long phone=Long.parseLong(req.getParameter("ph"));
		String password=req.getParameter("ps");
		Userdao dao=new Userdao();
		User user=dao.verifyUser(phone, password);
		RequestDispatcher dispatche=null;
		PrintWriter writer=resp.getWriter();
		
		if(user !=null)
		{
			dispatche=req.getRequestDispatcher("home.jsp");
			HttpSession session=req.getSession();
			session.setAttribute("u", user);
			dispatche.forward(req, resp);
		}
		else
		{
			writer.write("<html><body><h1>Invalid phone number or password</h1></body></html>");
			dispatche=req.getRequestDispatcher("login.jsp");
			dispatche.include(req, resp);
		}
		
	}
	
}
