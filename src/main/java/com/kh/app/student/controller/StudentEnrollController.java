package com.kh.app.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.kh.app.common.AbstractController;
import com.kh.app.student.model.dto.Student;
import com.kh.app.student.model.service.StudentService;

public class StudentEnrollController extends AbstractController {
	
	private StudentService studentService;
	static final Logger log = Logger.getLogger(StudentEnrollController.class); 
	
	public StudentEnrollController(StudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public String doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "student/studentEnroll";
	}
	
	@Override
	public String doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 사용자 입력값 처리
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		Student student = new Student();
		student.setName(name);
		student.setTel(tel);
		
		log.debug("student = " + student);
		
		// 2. 업무 로직 - student db 등록
		int result = studentService.insertStudent(student);
		
		// 3. 사용자 피드백처리
		request.getSession().setAttribute("msg", "학생을 성공적으로 등록했습니다.");
		
		
		return "redirect:/student/studentEnroll.do";
	}
}
