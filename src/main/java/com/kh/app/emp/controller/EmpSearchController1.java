package com.kh.app.emp.controller;

import java.io.IOException;
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
public class EmpSearchController1 extends AbstractController {

	private final EmpService empService;
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 직원 목록 조회
		List<Map<String, Object>> list = empService.selectEmpList();
		log.debug(list);
		
		// jsp에 전달
		request.setAttribute("list", list);
		
		return "emp/search1";
	}
}
