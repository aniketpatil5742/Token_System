package com.test.token.system.model;

import java.util.List;

public class CounterTokenListDto {
	
	private String counterName;
	private List<String> tokenList;
	public String getCounterName() {
		return counterName;
	}
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}
	public List<String> getTokenList() {
		return tokenList;
	}
	public void setTokenList(List<String> tokenList) {
		this.tokenList = tokenList;
	}
	@Override
	public String toString() {
		return "CounterTokenListDto [counterName=" + counterName + ", tokenList=" + tokenList + "]";
	}
	
	
	
}
