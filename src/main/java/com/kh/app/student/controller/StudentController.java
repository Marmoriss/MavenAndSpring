package com.kh.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.kh.app.common.AbstractController;
import com.kh.app.student.model.dto.Student;
import com.kh.app.student.model.service.StudentService;

public class StudentController extends AbstractController {

	private StudentService studentService;
	static final Logger log = Logger.getLogger(StudentController.class);
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 사용자 입력값
		int no = Integer.parseInt(request.getParameter("no"));
		log.debug(no);
		
		// 2. 업무 로직 - 한 명 조회
		Student student = studentService.selectOneStudent(no);
		log.debug(student);
		
		// 3. Json으로 응답
		response.setContentType("application/json; charset=utf-8");
		new Gson().toJson(student, response.getWriter());
		
		// 비동기이기때문에 전달할 데이터가 없어서 null로 넘김
		return null;
	}
}
