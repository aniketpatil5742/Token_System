package com.test.token.system.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.token.system.model.CounterQueueDto;
import com.test.token.system.util.TokenSystemUtil;

public class ViewCounterDetails extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			System.out.println("Inside ViewCounterDetails: "+req.getParameter("counterName"));
			TokenSystemUtil systemUtil=new TokenSystemUtil();


			List<CounterQueueDto> queueDtos=systemUtil.getTokenListByCounter(req.getParameter("counterName"));

			req.setAttribute("list", queueDtos);
			req.setAttribute("counterName", req.getParameter("counterName"));

			req.getRequestDispatcher("CounterDisplay.jsp").forward(req, resp);



		} catch (Exception e) {
			System.out.println("Exception in ViewCounterDetails:  "+e);
		}


	}

}
