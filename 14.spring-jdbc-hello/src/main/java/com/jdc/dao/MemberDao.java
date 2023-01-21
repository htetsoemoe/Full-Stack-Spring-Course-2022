package com.jdc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdc.dto.Member;

@Repository
public class MemberDao {
	
	@Autowired
	private JdbcTemplate template;

	public MemberDao(JdbcTemplate template) {
		super();
		this.template = template;
	}
	
	public void create(Member member) {
		template.update("insert into member values(?, ?, ?, ?, ?)", 
				member.getLoginId(),
				member.getPassword(),
				member.getName(),
				member.getPhone(),
				member.getEmail());
	}

}
