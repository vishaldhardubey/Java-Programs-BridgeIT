package com.studentapp;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
      
      
public class SendMailServlet extends HttpServlet{
	final String admin = "vishalcapgemini1807@gmail.com";
	final String passwordAdmin = "vish@1993";
	/*static int OTP=0;*/
    public void doGet(HttpServletRequest request,HttpServletResponse response)  
        throws ServletException, IOException {  
    	System.out.println("********************* Inside sendmailservice");
		
    	String email = request.getParameter("email");
		
		Mailer.send(email, admin, passwordAdmin);
		System.out.println("Redirecting to ResetPasswordServlet......................");
		response.sendRedirect("PasswordServlet");
    }  
 
    /*public static void getOTP(int otp) {
    	OTP=otp;
    }*/
}
