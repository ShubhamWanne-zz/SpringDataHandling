package com.psl.SpringDB.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class CircleDAOClassImp extends JdbcDaoSupport{
	
	public int getNumberOfCircle(){
		String sql = "select count(*) from circle";
		return getJdbcTemplate().queryForObject(sql, Integer.class);
	}
	
}




