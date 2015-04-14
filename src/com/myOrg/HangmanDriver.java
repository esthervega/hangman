package com.myOrg;
import java.io.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;


public class HangmanDriver extends HttpServlet{

	private String message;
	private Hangman hm;

	  public void init() throws ServletException
	  {
	      // Do required initialization
		  hm = new Hangman();
	  }
	  
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response)
	  throws ServletException, IOException
	  {
		  
		  // Set response content type
		  response.setContentType("text/html");
		  if(request.getParameter("action").equals("search"))
		  message = hm.newTry(request.getParameter("ch").charAt(0));
		  if(request.getParameter("action").equals("newGame")){
			  hm = new Hangman();
			  message=hm.createGameData();
		  }
		  
		  // Actual logic goes here.
		  PrintWriter out = response.getWriter();
		  out.println(message);
	  }
	  
	  public void destroy(){
		  
	  }
	  public void doPost(HttpServletRequest request,
			  HttpServletResponse response)
	  throws ServletException, IOException
	  {
		  doGet(request, response);
	  }
	}
