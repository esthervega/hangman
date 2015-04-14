package com.myOrg;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HangmanDriver extends HttpServlet{

    private static final long serialVersionUID = 8471610408114978546L;

    private String message;
	private Hangman hm;

	  public void init() throws ServletException
	  {
	      // Do required initialization
		  hm = new Hangman();
	  }

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response) throws ServletException,
	                                                         IOException {
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
	                     HttpServletResponse response) throws ServletException,
	                                                          IOException {
		  doGet(request, response);
	  }
	}
