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
             
             	<table class="profile">
             		<tr>
             			<td>Avatar</td>
             			<td>
							<img id="myprofile_avatar"/>
						</td>
             		</tr>
             		<tr>
             			<td style="height:20px"></td>
             		</tr>
             		<tr>
             			<td>Name</td>
             			<td>
             				<a target="_blank" style="font-weight:bold" id="myprofile_name"></a>
             			</td>
             		</tr>
             		<tr>
             			<td>Email</td>
             			<td>
             				<span  style="font-weight:bold" id="myprofile_email"></span>
             			</td>
             		</tr>
             		<tr>
             			<td style="height:10px"></td>
             		</tr>
             		<tr>
             			<td>Time to run Anti Spam</td>
             			<td>
             				<span  style="font-weight:bold">11:00</span>
             				<button title="Run Anti Spam Comment everyday with the time setup here" type="button" class="btn btn-danger btn-xs"><span style="margin-top:-3px" class="fa fa-edit"></span></button>
             			</td>
             		</tr>
             		<tr>
             			<td style="height:10px"></td>
             		</tr>
             		<tr>
             			<td>Current Account Type</td>
             			<td>
             				<span style="font-weight:bold" id="myprofile_currAccType">Free (Left 10 days)</span>
             				&nbsp;&nbsp;
             				<button type="button" class="btn btn-danger btn-xs"><span style="margin-top:-3px" class="fa fa-external-link-square"></span>&nbsp;&nbsp;Update To Pro?</button>
             			</td>
             		</tr>
             		
             	</table>
             
             </div>
			 
     	</div>
 	</div>
 </div>
 
 
 