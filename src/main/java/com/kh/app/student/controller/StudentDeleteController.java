package com.kh.app.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.kh.app.common.AbstractController;
import com.kh.app.student.model.service.StudentService;

public class StudentDeleteController extends AbstractController {
	
	private StudentService studentService;
	static final Logger log = Logger.getLogger(StudentUpdateController.class);
	
	public StudentDeleteController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. 사용자 입력값
		int no = Integer.parseInt(request.getParameter("no"));
		log.debug(no);
		
		// 2. 업무 로직
		int result = studentService.deleteStudent(no);
		
		// 3. Json으로 응답
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "학생 정보를 성공적으로 삭제했습니다.");
		new Gson().toJson(map, response.getWriter());
		
		return null;
	}
}
