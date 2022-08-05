package com.kh.app.emp.controller;

import java.io.IOException;
import java.util.Arrays;
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
public class EmpSearchController3 extends AbstractController {

	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 입력값 처리
		String[] jobCodes = request.getParameterValues("jobCode");
		String[] deptCodes = request.getParameterValues("deptCode");
		List<String> deptList = deptCodes != null ? Arrays.asList(deptCodes) : null;
		
		Map<String, Object> param = new HashMap<>();
		param.put("jobCodes", jobCodes);
		param.put("deptList", deptList);
		log.debug(param);
		
		// 2. 업무로직
		List<Map<String, Object>> list = empService.search3(param);
		log.debug("list = " + list);
		
		// 폼에 나열할 직급 목록 조회
		List<Map<String, Object>> jobCodeList = empService.selectJobList();
		log.debug("jobList = " + jobCodeList);
		
		// 폼에 나열할 부서 목록 조회
		List<Map<String, Object>> deptCodeList = empService.selectDeptList();
		log.debug(deptCodeList);
		
		request.setAttribute("jobCodeList", jobCodeList);
		request.setAttribute("deptCodeList", deptCodeList);
		request.setAttribute("list", list);
		
		return "emp/search3";
	}
}
