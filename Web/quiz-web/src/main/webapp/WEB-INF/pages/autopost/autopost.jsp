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
             
             	<div style="height:40px" class="mnControl">
             		<div style="float:left;margin-right:10px">
	               		<button title="Delete Task" style="float:right;margin-left:-15px" type="button" class="btn btn-danger"><span style="margin-top:-3px" class="fa fa-plus"></span>&nbsp;New</button>
	               	</div>
             		<div style="float:left;margin-right:10px">
	               		<input style="width:230px" id="txtAccMngSearch" placeholder="Search Content ..." type="text" class="form-control">
	               	</div>
                    
                      <div style="float:right">
                      	<div style="float:left">
	                      	<div style="float:left;margin-right:8px;margin-top:5px">Page</div>
		                   	<div style="float:left" class="dropdown">
							  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							    From
							    <span class="caret"></span>
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							  	<c:forEach begin="1" end="5" var="i">
							  		<li><a href="/p4r/accmanager.htm?usid=1&fr=${i}&vs=1">${i}</a></li>
							  	</c:forEach>
							    
							  </ul>
							</div>
                        </div>
                       </div>
             	</div>
             
                 <div class="row">
                     <div class="col-lg-14">
                         <div class="table-responsive">
                             <table class="table table-bordered table-hover table-striped">
                                 <thead>
                                     <tr>
                                         <th class="col-lg-3">Name</th>
                                         <th class="col-lg-5">Content</th>
                                         <th class="col-lg-2"></th>
                                         <th class="col-lg-3">Completed</th>
                                         <th class="col-lg-1"></th>
                                     </tr>
                                 </thead>
                                 <tbody>
                                 		<tr>
		                                     <td class="col-lg-3">Name</td>
	                                         <td class="col-lg-5">Content</td>
	                                         <td class="col-lg-2">3[S] 10[G] 5[M]</td>
	                                         <td class="col-lg-3">
	                                         	<a href="#">PaperCraft</a>, <a href="#">PTU Upload</a>
	                                         </td>
	                                         <td class="col-lg-1">
												<button title="Delete Task" type="button" class="btn btn-danger btn-xs"><span style="margin-top:-3px" class="fa fa-close"></span></button>
											</td>
	                                     </tr>
                                 </tbody>
                             </table>
                             
                         </div>
                         <!-- /.table-responsive -->
                         
                     </div>
                   
                     
                 </div>
                 <!-- /.row -->
             </div>
			 
			 
			 
			 
			 
			 
			 
			 
     	</div>
 	</div>
 </div>
 
 
 