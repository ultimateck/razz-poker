package com.rivals.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rivals.common.UserSession;
import com.rivals.common.Utility;

/**
 * Servlet implementation class Game
 */
@WebServlet("/Game")
public class Game extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Game() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request,response);
	}
	
	private void doExecute(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(!session.isNew()){session.invalidate();}
		else{
			Utility.users +=1;
		    UserSession us = new UserSession(Utility.users + 1, 0, "Guest #" + (Utility.users + 1));
		    session.setAttribute("us", us);
		}
		
		response.setContentType("text/html");
		try {
			response.getWriter().print(((UserSession)session.getAttribute("us")).getUserName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
