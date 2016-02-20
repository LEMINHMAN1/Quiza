<!DOCTYPE html>

<%@ page language="java" isELIgnored="false"
     contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib prefix="quiz" tagdir="/WEB-INF/tags" %>

<quiz:template url="myprofile.jsp" pageCode="${pageCode}"/>
