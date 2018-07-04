package com.capgemini;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
public class MySessionListener implements HttpSessionListener {
		static int currentUser=0,total=0;
		ServletContext ctx=null;
	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent eventCreated)  { 
    	System.out.println("Inside Listener");
    	currentUser++;
    	total++;
    	ctx=eventCreated.getSession().getServletContext();
    	ctx.setAttribute("totalusers", total);  
        ctx.setAttribute("currentusers", currentUser);
        System.out.println(total);
        System.out.println("Listener : "+currentUser);
    }
	
	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent eventDestroyed)  { 
    	System.out.println("Inside Destroyer");
    	currentUser--;
        ctx.setAttribute("currentusers", currentUser);
        System.out.println("destroy : "+currentUser);
    }
}
