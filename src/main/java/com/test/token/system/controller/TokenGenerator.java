package com.test.token.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.token.system.util.TokenSystemUtil;

public class TokenGenerator extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside TokenGenerator Servlet1: "+req.getParameter("accNum"));
		TokenSystemUtil systemUtil=new TokenSystemUtil();
		String token=null;
		String counterNum=null;
		String customerType=null;
		
		if(systemUtil.isPrivilegedCustomer(req.getParameter("accNum"))) {
			customerType=TokenSystemUtil.PREVILEGE_CUSTOMER;
			
			token=systemUtil.generateToken(customerType);			
			counterNum=systemUtil.getAvailableCounter(customerType);
			
			systemUtil.insertTokenDetails(token,counterNum,customerType);
			
			
		}else {
			customerType=TokenSystemUtil.CUSTOMER;
			token=systemUtil.generateToken(customerType);
			counterNum=systemUtil.getAvailableCounter(customerType);
			
			systemUtil.insertTokenDetails(token,counterNum,customerType);
			
		}
		
		
		req.setAttribute("token", token);
		req.setAttribute("customerType", customerType);
		req.setAttribute("counterNum", counterNum);
		req.getRequestDispatcher("viewTokens.jsp").forward(req, resp);
	
	}

}
