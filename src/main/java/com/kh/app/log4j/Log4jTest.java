package com.kh.app.log4j;

import org.apache.log4j.Logger;

public class Log4jTest {
	
	static final Logger log = Logger.getLogger(Log4jTest.class);

	public static void main(String[] args) {
		log.fatal("FATAL!");	// 아주 심각한 에러
		log.error("ERROR!");	// 처리 도중 오류(예외) 발생
		log.warn("WARN!");		// 헌재 프로그램 시작에는 문제되지 않지만, 향후 시스템의 잠재적 오류가 될 수 있는 경우
		log.info("INFO!");		// 프로그램 실행 주으이 상태 변경 등의 메세지
		log.debug("DEBUG!");	// 개발 도중 필요한 메세지
		log.trace("TRACE!");	// 흐름의 시작과 끝을 정의하는 용도
	}

}
