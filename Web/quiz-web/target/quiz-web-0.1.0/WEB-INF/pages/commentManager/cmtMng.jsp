<!DOCTYPE html>

<%@ page language="java" isELIgnored="false"
     contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<link rel="stylesheet" href="<c:url value="/static/css/me/store.css" />" />

<div style="margin-top:80px"></div>

<div class="row">
     <div>
         <div class="panel">
         
             <div class="panel-body">
             
             	<table class="cmt">
             		<tr>
             			<td>Comment name</td>
             			<td>
							<div style="float:left" class="dropdown">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							    Le Minh Man Talent
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							  	<c:forEach begin="1" end="5" var="i">
							  		<li><a href="/p4r/accmanager.htm?usid=1&fr=${i}&vs=1">${i}11111</a></li>
							  	</c:forEach>
							  </ul>
							</div>
							<button style="margin-left:3px" type="button" class="btn btn-danger"><span style="margin-top:-3px" class="fa fa-plus"></span>&nbsp;Add</button>
						</td>
             		</tr>
             		<tr>
             			<td style="height:20px"></td>
             		</tr>
             		<tr>
             			<td>Name</td>
             			<td>
             				<input type="text" class="form-control" aria-label="Text input with multiple buttons">
             			</td>
             		</tr>
             		<tr>
             			<td>Value</td>
             			<td>
             				<textarea class="form-control" rows="3" placeholder="Textarea" style="margin-top: 0px; margin-bottom: 0px; height: 80px;width:600px"></textarea>
             			</td>
             		</tr>
             		<tr>
             			<td>Anti for Pages/Groups</td>
             			<td>
             				<input type="text" class="form-control" aria-label="Text input with multiple buttons">
             			</td>
             		</tr>
             		<tr>
             			<td></td>
             			<td>
             				<br/>
             				<button style="float:right" type="button" class="btn btn-danger"><span style="margin-top:-3px" class="fa fa-check"></span>&nbsp;Save</button>
             				<button style="float:right;margin-right:5px" type="button" class="btn btn-danger" ><span style="margin-top:-3px" class="fa fa-close"></span>&nbsp;Delete</button>
             			</td>
             		</tr>
             	
             	</table>
             
             </div>
			 
			 
			 
			 
			 
			 
			 
			 
     	</div>
 	</div>
 </div>
 
 
 