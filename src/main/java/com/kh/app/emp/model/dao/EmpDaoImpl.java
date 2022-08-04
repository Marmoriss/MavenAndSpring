package com.kh.app.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDaoImpl implements EmpDao {

	@Override
	public List<Map<String, Object>> selectEmpList(SqlSession sqlSession) {
		return sqlSession.selectList("emp.selectEmpList");
	}

	
}
