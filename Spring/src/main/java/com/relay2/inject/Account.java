package com.relay2.inject;

import java.util.Date;

public class Account {

	
	private String type;
	
	private Date createTime;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Account [type=" + type + ", createTime=" + createTime + "]";
	}
	
	
}
