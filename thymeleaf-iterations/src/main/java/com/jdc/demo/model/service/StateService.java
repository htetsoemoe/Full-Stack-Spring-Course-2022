package com.jdc.demo.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.demo.model.entity.State;
import com.jdc.demo.model.repo.StateRepo;

import jakarta.transaction.Transactional;

@Service
public class StateService {
	
	@Autowired
	private StateRepo repo;
	
	public List<State> findAll() {
		return repo.findAll();
	}
	
	public long getAllCount() {
		return repo.count();
	}
	
	@Transactional
	public void upload(MultipartFile file) {
		try(var br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			
			String line = null;
			
			while (null != (line = br.readLine())) {
				var state = new State(line);
				repo.save(state);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
