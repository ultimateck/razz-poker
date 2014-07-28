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
import com.rivals.pokerengine.Player;
import com.rivals.razzpoker.RazzTable;

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
		
		switch (request.getParameterMap().keySet().toArray()[0].toString()) {
		case "mode": doMode(request, response);
			break;
		case "bot": doBot(request, response);
			break;
		case "start": doStart(request, response);
			break;
		case "table": doJoin(request, response);
			break;


		default: print(response, "No Params");
			break;
		}
		
		
	}
	
	private void doMode(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		String out = null;
		if(session.isNew() || session.getAttribute("us") == null){
			Utility.users +=1;
		    UserSession us = new UserSession(Utility.users + 1, 0, "Guest #" + (Utility.users + 1));
		    session = request.getSession();
		    session.setAttribute("us", us);
		    out = ((UserSession)session.getAttribute("us")).getUserName();
		}
		else{
			UserSession us = (UserSession) session.getAttribute("us");
			out = us.getUserName() + "-You have already initiated";
		}
		
		if(request.getParameter("mode").equals("new")){
			UserSession us = (UserSession) session.getAttribute("us");
			if(us.table != null) {out += "<br>You have already joined Table#"+ Utility.razzTables.indexOf(us.table);}
			else if(Utility.razzTables.size() <= Utility.MAX_TABLES ){
				RazzTable rt = new RazzTable();
				Player p = new Player();
				int pid = rt.addPlayer(p);
				int tid = Utility.addTable(rt);
				
				us.isTableCreator = true;
				us.table = rt;
				us.setPlayerId(pid);
				us.setTableId(tid);
				session.setAttribute("us", us);
				session.setAttribute("showList", false);
			}
			else{
				out += "<br>Tables full Please join ongoing table";
			}
		}
		else if(request.getParameter("mode").equals("join")){
			session.setAttribute("showList", true);
		}
		
		print(response, out);
	}
	
	private void doJoin(HttpServletRequest request, HttpServletResponse response){
		int tid = Integer.parseInt(request.getParameter("table"));
		
	}
	
	private void doBot(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	private void doStart(HttpServletRequest request, HttpServletResponse response){
		
	}
	
	private void print(HttpServletResponse response, String out){
		response.setContentType("text/html");
		try {
			response.getWriter().print(out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
