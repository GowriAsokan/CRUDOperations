package com.sample.myproject;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		 PersistenceManager pm = PMF.get().getPersistenceManager();
		// UserPojo user = new UserPojo();
		 
		 Query q = pm.newQuery(UserPojo.class);
      List<UserPojo> result = (List<UserPojo>) q.execute();
		 try {
			 UserPojo user = pm.getObjectById(UserPojo.class, result.get(0).getKey());
		 	pm.deletePersistent(user);
		 } finally {
		 	pm.close();
		 }
		
		 resp.getWriter().println("Hello, delete");
	}

}
