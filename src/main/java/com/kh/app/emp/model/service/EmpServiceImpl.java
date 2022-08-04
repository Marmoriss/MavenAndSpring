package com.kh.app.emp.model.service;

import static com.kh.app.common.SqlSessionUtils.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.emp.model.dao.EmpDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {

	private final EmpDao empDao;
	
	@Override
	public List<Map<String, Object>> selectEmpList() {
		try(SqlSession sqlSession = getSqlSession()){
			return empDao.selectEmpList(sqlSession);
		}
	}
}
