
package com.sample.myproject;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class CreateServlet extends HttpServlet {
	

	
	 public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		 
		 String username = req.getParameter("username");
		 String email = req.getParameter("email");
		 PersistenceManager pm = PMF.get().getPersistenceManager();
		 try {
			 UserPojo user = new UserPojo();
			 user.setUsername(username);
			 user.setEmail(email);
			 
			 //taskqueue 
			 
			 
			

		 
			 pm.makePersistent(user);
		 	
		 	System.out.println(user);
		 } 
		 
		 catch (Exception e) {
				
				System.out.println(e);
		 }
		 finally {
		 	pm.close();
		 }
	 
	 

	 res.setContentType("text/plain");
		res.getWriter().println("Hello, world");
}
}