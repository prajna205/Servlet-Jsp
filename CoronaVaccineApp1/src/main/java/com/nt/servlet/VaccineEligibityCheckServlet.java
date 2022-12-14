package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VaccineEligibityCheckServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get the print writer
		PrintWriter pW =res.getWriter();
		//set the content type
		res.setContentType("text/html");
		//read form data(req parameter values)
		String name= req.getParameter("pname");
		String addrs= req.getParameter("paddr");
		int age= Integer.parseInt(req.getParameter("page"));
		
		//business logic(request processing logic)
		if(age<18)
			pW.println("<h1 style='color:red;text-align:center'>Hello "+ name+", U are not eligible for vaccination</h1>");
		else
			pW.println("<h1 style='color:green;text-align:center'>Hello "+ name+", U are eligible for vaccination</h1>");
		
		//add hyperlink to navigate to home page 
		pW.println("<a href = 'welcome'><img src='images/home.jpg'><br>Back to Home</a>");
		//close print writer
		pW.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw = res.getWriter();
		//set the content type
		res.setContentType("text/html");
		//create date object
		LocalDateTime d= LocalDateTime.now();
		//get the current hour
		int hour = d.getHour();
		//business logic
		if(hour<12)
			pw.println("<h1 style='color:red;text-align:center'>Good Morning</h1>");
		else if(hour>12 && hour<16)
			pw.println("<h1 style='color:green;text-align:center'>Good afternoon</h1>");
		else if(hour>16 && hour<20)
			pw.println("<h1 style='color:blue;text-align:center'>Good evening</h1>");
		else
			pw.println("<h1 style='color:purple;text-align:center'>Good Night</h1>");
		//back to home page
		pw.println("<a href='welcome'>Back to Home</a>");
	}}
