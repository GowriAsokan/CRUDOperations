package com.sample.myproject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.ant.taskdefs.email.Mailer;  

	public class Sendmail extends HttpServlet {  
		
	public void doGet(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {  
	response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
      
    String to=request.getParameter("email1");  
    String subject=request.getParameter("subject");  
    String msg=request.getParameter("msg");  
          
    Mail.send(to, subject, msg);  
    out.print("message has been sent successfully");  
    RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
    rd.include(request, response);  
 
    out.close();  
    }  
  
}  