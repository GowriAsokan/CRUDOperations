package com.sample.myproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.util.ajax.JSON;

import com.google.gson.Gson;

//import com.google.appengine.repackaged.com.google.gson.Gson;




public class RetrieveServlet extends HttpServlet{
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		 PersistenceManager pm = PMF.get().getPersistenceManager();
			PrintWriter out = resp.getWriter();
			String output= "";
			Query q = pm.newQuery(UserPojo.class);
			 		
			UserPojo user = new UserPojo();
			 List<UserPojo> result = (List<UserPojo>) q.execute();
			
			 
//			 user.getUsername();
//			 System.out.println( user.getUsername());
	 Gson gson = new Gson();
	 output = gson.toJson(result);
	 System.out.println("The retrieved data" + output);
	 
	 resp.getWriter().println("Hello, world1");
	 }

}
