package com.kh.app.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.AbstractController;
import com.kh.app.emp.model.service.EmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequiredArgsConstructor
@Log4j
public class EmpSearchController2 extends AbstractController {

	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력값 처리
		String searchType = request.getParameter("searchType"); 		// "emp_id" "" null
		String searchKeyword = request.getParameter("searchKeyword");	// "abc" "" null
		String gender = request.getParameter("gender");					// "남" null
		
		int salary = 0;
		try {
			salary = Integer.parseInt(request.getParameter("salary"));	// "30000" "" null
		} catch(NumberFormatException e) {}
		
		String salaryCompare = request.getParameter("salaryCompare");	// "ge" "le" null
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		param.put("gender", gender);
		param.put("salary", salary);
		param.put("salaryCompare", salaryCompare);
		
		log.debug(param);
		
		// 2. 검색
		List<Map<String, Object>> list = empService.search2(param);
		log.debug(list);
		request.setAttribute("list", list);
		
		
		return "emp/search2";
	}
}
