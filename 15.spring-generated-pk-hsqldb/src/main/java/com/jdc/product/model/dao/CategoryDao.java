package com.jdc.product.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.jdc.product.model.dto.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	private SimpleJdbcInsert insertCategory;
	
	@Value("${dao.category.update}")
	private String update;
	
	@Value("${dao.category.findById}")
	private String findById;
	
	@Value("${dao.category.findByNameLike}")
	private String findByNameLike;
	
	@Value("${dao.category.findCountByNameLike}")
	private String findCountByNameLike;
	
	@Value("${dao.category.delete}")
	private String delete;
	
	private BeanPropertyRowMapper<Category> rowMapper;
	
	public CategoryDao() {
		rowMapper = new BeanPropertyRowMapper<>(Category.class);
	}
	
	public int create(Category c) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", 	c.getName());
		
		return insertCategory.executeAndReturnKey(params).intValue();
	}

	public int update(Category category) {
		return insertCategory.getJdbcTemplate().update(update, category.getName(), category.getId());
	}

	public Category findById(int id) {
		return insertCategory.getJdbcTemplate().queryForObject(findById, rowMapper, id);
	}

	public List<Category> findByNameLike(String name) {
		return insertCategory.getJdbcTemplate().query(findByNameLike, rowMapper, name.toLowerCase().concat("%"));
	}

	public int findCountByNameLike(String name) {	
		return insertCategory.getJdbcTemplate().queryForObject(findCountByNameLike, Integer.class, name.toLowerCase().concat("%"));
	}

	public int delete(int id) {
		return insertCategory.getJdbcTemplate().update(delete, id);
	}

}

/*
 	@Autowired
	private JdbcOperations jdbc;
	
	@Value("${dml.category.insert}")
	private String insertSql; 
 
 
 public int create(Category c) {
		
		PreparedStatementCreatorFactory factory = new PreparedStatementCreatorFactory(insertSql, Types.VARCHAR);
		factory.setReturnGeneratedKeys(true);
		PreparedStatementCreator creator = factory.newPreparedStatementCreator(List.of(c.getName()));
		
		var keyHolder = new GeneratedKeyHolder();
		
		jdbc.update(creator, keyHolder);
		
		return keyHolder.getKey().intValue();
		
		PreparedStatementCallback<Integer> callback = stmt -> {
			stmt.executeUpdate();
			var rs = stmt.getGeneratedKeys();
			
			while (rs.next()) {
				return rs.getInt(1);
			}
			
			return 0;
		};
		
		return jdbc.execute(creator, callback);
	
	}
 */
