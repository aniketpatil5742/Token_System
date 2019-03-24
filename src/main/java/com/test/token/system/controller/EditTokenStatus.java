package com.test.token.system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.token.system.model.CounterQueueDto;
import com.test.token.system.util.DatabaseConnector;
import com.test.token.system.util.TokenSystemUtil;

public class EditTokenStatus extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			String sql="update token_counters set status='PR' where id="+req.getParameter("id");
			DatabaseConnector.execUpdateQuery(sql);
			
			TokenSystemUtil systemUtil=new TokenSystemUtil();


			List<CounterQueueDto> queueDtos=systemUtil.getTokenListByCounter(req.getParameter("counterName"));

			req.setAttribute("list", queueDtos);
			req.setAttribute("counterName", req.getParameter("counterName"));

			req.getRequestDispatcher("CounterDisplay.jsp").include(req, resp);

			
			
			
		} catch (Exception e) {
			
		}
	}

}
