package com.simplilearn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.EProduct;

@Repository
public class EProductDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<EProduct> getProducts() {
	
		return jdbcTemplate.query("select * from eproduct_21012023", new RowMapper<EProduct>() {

			@Override
			public EProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
				EProduct ep = new EProduct();
				ep.setId(rs.getInt(1));
				ep.setName(rs.getString(2));
				ep.setPrice(rs.getDouble(3));
				return ep;
			}
			
		} );
	}
}
