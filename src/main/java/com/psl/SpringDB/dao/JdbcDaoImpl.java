package com.psl.SpringDB.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.psl.SpringDB.Model.Circle;
import com.psl.SpringDB.Model.Triangle;

@Component
public class JdbcDaoImpl {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate nameParameterJdbcTemplate;
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired(required=true)
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.nameParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	public NamedParameterJdbcTemplate getNameParameterJdbcTemplate() {
		return nameParameterJdbcTemplate;
	}
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate nameParameterJdbcTemplate) {
		this.nameParameterJdbcTemplate = nameParameterJdbcTemplate;
	}

	private static final class CircleMapper implements RowMapper<Circle>{

		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}
		
	}

	
	public Circle getCircleWithJDBCTemplate(int circleID){
		String sql = "select * from circle where id = ? ";
		return jdbcTemplate.queryForObject(sql,new Object[]{circleID},new CircleMapper());
	}
	
	public List<Circle> getRecords(){
		String sql = "select * from circle";

		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public int getNumberOfCircle(){
		String sql = "select count(*) from circle";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	
	public boolean insertCircle(Circle c){
		String sql = "insert into circle(id,name) values("+c.getId()+",'"+c.getName()+"')";
		if(jdbcTemplate.update(sql)!=-1)
			return true;
		else 
			return false;
	}
	
	
	public void createTriangle(){
		String sql = "create table triangle(id integer, name varchar(10))";
		jdbcTemplate.execute(sql);
	}
	
	public void insertTriangle(Triangle t){
		String sql = "insert into triangle(id,name) values (:id,:name)";
		SqlParameterSource sqlParamterSource = new MapSqlParameterSource()
													.addValue("id", t.getId())
													.addValue("name", t.getName());
		nameParameterJdbcTemplate.update(sql, sqlParamterSource);
	}
	
}
