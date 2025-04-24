package com.example.app.domain.Service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.Dao.MemoDaoImpl;
import com.example.app.domain.Dto.MemoDto;

@Service
public class MemoServiceImpl {
	
	
	@Autowired
	private MemoDaoImpl memoDaoImpl;
	
	public boolean registrationMemo(MemoDto memoDto) throws SQLException {
		int result = memoDaoImpl.insert(memoDto);
		
		return result>0;
	}
}
