package com.sample.myproject;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;



@SuppressWarnings("serial")
public class CRUDOpeartionsServlet extends HttpServlet {

	
public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	 
	 String username = req.getParameter("username");
	 String email = req.getParameter("email");
	 PersistenceManager pm = PMF.get().getPersistenceManager();
	 
	 try {
		 Query q = pm.newQuery(UserPojo.class);
		 q.setFilter("email =='" + email + "'");
		 List<UserPojo> result = (List<UserPojo>) q.execute();
		 
//		 Queue queue = QueueFactory.getDefaultQueue();
//		 queue.add(TaskOptions.Builder.withUrl("/Sendmail")); 
		 
		 if (!(result.isEmpty())) {
				UserPojo user = pm.getObjectById(UserPojo.class, result.get(0).getKey());
				 user.setUsername(username);
				 user.setEmail(email);
				pm.makePersistent(user);
			} else {
				
				UserPojo user = new UserPojo();
				user.setUsername(username);
				 user.setEmail(email);
				pm.makePersistent(user);
			}		
//	System.out.println(result.toString());		
	 }
	 
	 
	 catch (Exception e) {
			
			System.out.println(e);
	 }
	 finally {
	 	pm.close();
	 }
	 System.out.println("The queue is running");
	 res.setContentType("text/plain");
	 res.getWriter().println("Hello, world");
}


}

