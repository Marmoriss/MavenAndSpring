<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis실습</title>
<style>
div#emp-container{text-align:center;}
table.tbl-emp{
	margin:0 auto;
	border:1px solid; 
	border-collapse:collapse;
}
table.tbl-emp th, table.tbl-emp td{
	border:1px solid;
	padding:5px;
}
div#search-container{
	padding:15px 0;
}
table#tbl-search { margin:0 auto; }
table#tbl-search th,table#tbl-search td {padding:5px 15px; font-weight: normal; }
table#tbl-search td {text-align:left;}

</style>
</head>
<body>
<%
String[] jobCodes = request.getParameterValues("jobCode");
List<String> jobList = jobCodes != null ? Arrays.asList(jobCodes) : null;
pageContext.setAttribute("jobList", jobList);

String[] deptCodes = request.getParameterValues("deptCode");
List<String> deptList = deptCodes != null ? Arrays.asList(deptCodes) : null;
pageContext.setAttribute("deptList", deptList);
%>
<div id="emp-container">
	<h2>사원정보 </h2>
    <div id="search-container">
        <form name="empSearchFrm">
            <table id="tbl-search">
                <tr>
                	<th>직급</th>
                	<td>
                	<c:forEach items="${jobCodeList}" var="job" varStatus="vs">
                	   <input type="checkbox" name="jobCode" id="jobCode${vs.count}" value="${job.jobCode}" 
                	       ${jobList.contains(job.jobCode) ? 'checked' : ''}/>
                	   <label for="jobCode${vs.count}">${job.jobName}</label>
                	   <c:if test="${vs.count % 3 eq 0}"><br /></c:if>
                	</c:forEach>
                	</td>
                </tr>
                <tr>
                	<th>부서</th>
                	<td>
                	   <c:forEach items="${deptCodeList}" var="dept" varStatus="vs">
	                	   <input type="checkbox" name="deptCode" id="deptCode${vs.count}" value="${dept.deptCode}"
	                	      ${deptList.contains(dept.deptCode) ? 'checked' : ''}/>
	                	   <label for="deptCode${vs.count}">${dept.deptTitle}</label>
	                	   <c:if test="${vs.count % 3 eq 0}"><br /></c:if>
                	   </c:forEach>
                	   <input type="checkbox" name="deptCode" id="deptCode${vs.count}" value="D0"
                              ${deptList.contains('D0') ? 'checked' : ''}/>
                           <label for="deptCode0">부서 미지정</label>
                	</td>
                </tr>
            	<tr>
            		<th colspan="2">
		            	<input type="submit" value="검색" />
		            	<input type="button" onclick="location.href='${pageContext.request.contextPath}/emp/search3.do';" value="초기화" />
            		</th>
            	</tr>
            </table>
        </form>
    </div>
	    
	<table class="tbl-emp">
		<tr>
			<th></th><!-- 1부터 넘버링 처리 -->
			<th>사번</th>
			<th>사원명</th>
			<th>주민번호</th><!--뒷6자리는 ******처리-->
			<th>성별</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서</th>
			<th>직급</th>
			<th>급여레벨</th>
			<th>급여</th><!--원화기호, 세자리마다 콤마표시-->
			<th>보너스율</th><!--percent로 표시-->
			<th>매니져 사번</th>
			<th>입사일</th><!--날짜형식 yyyy/MM/dd-->
			<th>퇴사여부</th>
		</tr>
		<!-- 조회된 데이터가 있는 경우와 없는 경우를 분기처리 하세요 -->
		<c:if test="${not empty list}">
		  <c:forEach items="${list}" var="emp" varStatus="vs">
		      <tr>
		      	<td>${vs.count}</td>
		      	<td>${emp.empId}</td>
		      	<td>${emp.empName}</td>
		      	<td>${fn:substring(emp.empNo,0,8)}******</td>
		      	<td>${emp.gender}</td>
		      	<td>${emp.email}</td>
		      	<td>${emp.phone}</td>
		      	<td>${emp.deptTitle}</td>
		      	<td>${emp.jobName}</td>
		      	<td>${emp.salLevel}</td>
		      	<td>
		      	   <fmt:formatNumber value="${emp.salary}" type="currency" />
		      	</td>
		      	<td>
		      	   <fmt:formatNumber value="${emp.bonus}" type="percent" />
		      	</td>
		      	<td>${emp.managerId}</td>
		      	<td>
		      	   <fmt:formatDate value="${emp.hireDate}" pattern="yyyy/MM/dd"/>   
		      	</td>
		      	<td>${emp.quitYn}</td>
		      </tr>
		  </c:forEach>
		</c:if>
		<c:if test="${empty list}">
            <tr>
            	<td colspan="15">조회된 사원이 없습니다.</td>
            </tr>
		</c:if>
	</table>
</div>

</body>
</html>
