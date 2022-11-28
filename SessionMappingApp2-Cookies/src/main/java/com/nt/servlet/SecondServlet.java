package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {       

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form1 data from cookies of request2
		Cookie cookies[] = req.getCookies();
		String name=null,fname=null,ms=null,addrs=null;
		if(cookies !=null) {
			name =cookies[0].getValue();
			fname =cookies[1].getValue();
			addrs =cookies[2].getValue();
			ms =cookies[3].getValue();
		}
		//read form2/req2 data
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");
		//display form1/req1 data
		pw.println("<br><b>Person Details:::"+ name+ "..."+ fname+ "..."+ addrs+ "..."+ 
					ms+ "..."+ f2val1+ "..."+ f2val2+"</b>");
	
		//add home hypelink
		pw.println("<br><br><a href='person_details.html'>Home</a>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
