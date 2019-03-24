package com.test.token.system.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.test.token.system.model.CounterQueueDto;
import com.test.token.system.model.CounterTokenListDto;

public class TokenSystemUtil {

	public static String YES="Y";
	public static String NO="N";
	public static String PREVILEGE_CUSTOMER="PC";
	public static String CUSTOMER="CU";
	public static String STATUS_NEW="NE";


	public boolean isPrivilegedCustomer(String accNum) {

		try {

			System.out.println(" Inside isPrivilegedCustomer for :  "+accNum);

			String sqlquery="Select isPrivilege from customer_details where accNum="+accNum;

			ResultSet rs=DatabaseConnector.execQuery(sqlquery);			

			String isPrev=null;
			while (rs.next()) {
				isPrev=rs.getString("isPrivilege");
			}

			if(YES.equals(isPrev)) {
				return true;
			}			

		} catch (Exception e) {
			System.out.println(" Exception in isPrivilegedCustomer:  "+e);
		}

		return false;
	}

	public String getAvailableCounter(String customerType) {

		try {

			String sql="select counter_details.counterName,count(token_counters.counter) count from counter_details left join token_counters " + 
					"on counter_details.counterName=token_counters.counter and token_counters.status='NE' and token_counters.customerType='"+customerType+"'  " + 
					" where counter_details.status='OP' group by counter_details.counterName";

			ResultSet rs=DatabaseConnector.execQuery(sql);
			Map<String, Integer> counterDetails=new HashMap<String,Integer>();

			while (rs.next()) {
				counterDetails.put(rs.getString("counterName"),Integer.parseInt(rs.getString("count")));
			}


			Entry<String, Integer> min = null;
			for (Entry<String, Integer> entry : counterDetails.entrySet()) {
				if (min == null || min.getValue() > entry.getValue()) {
					min = entry;
				}
			}

			System.out.println("Avalable counter with minimum tokens for customer type " +customerType+ " is  "+min.getKey());

			return min.getKey();

		} catch (Exception e) {
			System.out.println(" Exception in getAvailableCounter:  "+e);
		}

		return null;
	}

	public String generateToken(String customerType) {

		try {

			System.out.println("Inside generateToken: "+customerType);
			String query="select token from token_counters where customerType='"+customerType+"' order by id desc limit 1";
			ResultSet rs=DatabaseConnector.execQuery(query);	

			String token=null;
			while (rs.next()) {
				token=rs.getString("token");
			}

			token=token.substring(2, token.length());

			token=customerType+(Integer.parseInt(token)+1);

			System.out.println("token:  "+token);

			return token;


		} catch (Exception e) {
			System.out.println(" Exception in getAvailableCounter:  "+e);
		}

		return null;
	}

	public void insertTokenDetails(String token, String counterNum, String customerType) {


		try {

			System.out.println("Inside insertTokenDetails: "+customerType);

			String sql="insert into token_counters (token, counter, customerType, status) values "
					+ "('"+token+"', '"+counterNum+"', '"+customerType+"','"+STATUS_NEW+"' )";

			DatabaseConnector.execUpdateQuery(sql);

		} catch (Exception e) {
			System.out.println("Exception in insertTokenDetails: "+e);
		}

	}

	public List<CounterTokenListDto> getCounterQueue() {


		try {

			ResultSet sqlCounterRs=DatabaseConnector.execQuery("select counter from token_counters where status='NE' group by counter");

			List<CounterTokenListDto> tokenListDtos=new ArrayList<CounterTokenListDto>();


			while (sqlCounterRs.next()) {
				CounterTokenListDto counterToken=new CounterTokenListDto();
				List<String> tokenList=new ArrayList<String>();
				ResultSet resultSet=DatabaseConnector.execQuery(
						"select token from token_counters where status='NE'  and counter='"+sqlCounterRs.getString("counter")+"'"); 

				while (resultSet.next()) {
					tokenList.add(resultSet.getString("token"));

				}

				counterToken.setCounterName(sqlCounterRs.getString("counter"));
				counterToken.setTokenList(tokenList);

				tokenListDtos.add(counterToken);

			}

			System.out.println("tokenListDtos :" +tokenListDtos);

			return tokenListDtos;

		} catch (Exception e) {
			System.out.println("Exception in insertTokenDetails: "+e);
		}
		return null;
	}

	public List<CounterQueueDto> getTokenListByCounter(String counterName) {

		try {

			String  sql="select * from token_counters where status='"+STATUS_NEW+"'  and counter='"+counterName+"' ";

			ResultSet resultSet=DatabaseConnector.execQuery(sql);

			List<CounterQueueDto> list=new ArrayList<CounterQueueDto>();

			while (resultSet.next()) {
				CounterQueueDto dto=new CounterQueueDto();

				dto.setId(Integer.parseInt(resultSet.getString("id")));
				dto.setCounter(resultSet.getString("counter"));
				dto.setCustomerType(resultSet.getString("customerType"));
				dto.setStatus(resultSet.getString("status"));
				dto.setToken(resultSet.getString("token"));

				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Exception in getTokenListByCounter: "+e);
		}

		return null;
	}
}
