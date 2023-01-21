<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="value" required="true" type="java.time.LocalDateTime"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- To format date time in access-info.tag -->
<spring:eval expression="T(java.time.format.DateTimeFormatter).ofPattern('yyyy-MM-dd HH:mm:ss').format(value)"></spring:eval>
