package com.test.token.system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.token.system.model.CounterTokenListDto;
import com.test.token.system.util.TokenSystemUtil;

public class CounterQueue extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In CounterQueue");
		
		try {
			TokenSystemUtil systemUtil=new TokenSystemUtil();
			
			List<CounterTokenListDto>  tokenListDtos=systemUtil.getCounterQueue();
			
			
			req.setAttribute("list", tokenListDtos);
			
			req.getRequestDispatcher("displayQueue.jsp").forward(req, resp);
			
		} catch (Exception e) {
			System.out.println("Exception in service of CounterQueue:  "+e);
		}
	}
}


