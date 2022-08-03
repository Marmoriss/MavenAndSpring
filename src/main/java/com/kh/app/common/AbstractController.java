package com.kh.app.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.common.exception.MethodNotAllowedException;

/**
 * 전략 클래스
 *
 *
 */
public abstract class AbstractController {

	public String doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		throw new MethodNotAllowedException("GET");
	}
	
	public String doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		throw new MethodNotAllowedException("POST");
	}
}
