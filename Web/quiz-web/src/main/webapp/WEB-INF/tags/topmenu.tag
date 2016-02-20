<!DOCTYPE html>

<%@ tag display-name="topmenu" body-content="empty" pageEncoding="UTF-8" %>
<%@ attribute name="code" required="true" rtexprvalue="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="<c:url value="/static/script/jq/jq.js" />"></script>
<script src="<c:url value="/static/script/bt/bt.js" />"></script>
<script src="<c:url value="/static/script/mt/mt.js" />"></script>
<script src="<c:url value="/static/script/rap/rap.js" />"></script>

<script src="<c:url value="/static/script/base/sb-admin-2.js" />"></script>

<link rel="stylesheet" href="<c:url value="/static/css/me/base.css" />" />

<nav style="font-weight:bold" class="navbar navbar-inverse navbar-fixed-top">
        <div class="col-lg-10">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div style="margin-left:10%;margin-top:7px" class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#page-top">Start Bootstrap</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul style="margin-top:-12px;font-size:14px" class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="page-scroll">
                        <a href="/home.htm" <c:if test="${pageCode==1}">class="menuActive"</c:if>  ><i style="font-size:25px" class="fa fa-home fa-fw"></i>&nbsp;Trang Chủ</a>
                    </li>
                    
                    <li class="dropdown">
	                    <a class="dropdown-toggle <c:if test="${pageCode==2 || pageCode==3 || pageCode==4}">menuActive</c:if> " data-toggle="dropdown" href="#" aria-expanded="false">
	                        <i style="font-size:25px" class="fa fa-envelope fa-fw"></i>&nbsp;Man Le&nbsp;<i class="fa fa-caret-down"></i>
	                    </a>
	                    <ul class="dropdown-menu dropdown-alerts">
	                        <li>
	                            <a href="#">
	                            	<div style="margin-top:-8px">
	                            	<i class="fa fa-tasks"></i>&nbsp;&nbsp;Hoạt động
	                            	</div>
	                            </a>
	                            
	                        </li>
	                        <li class="divider"></li>
	                        <li>
	                            <a href="#">
	                            	<div style="margin-top:-8px">
	                            		<i class="fa fa-table"></i>&nbsp;&nbsp;Quản Lý Đề Thi
	                            	</div>
	                            </a>
	                        </li>
	                        <li class="divider"></li>
	                        <li>
	                            <a href="#">
	                            	<div style="margin-top:-8px">
	                            		<i class="fa fa-group"></i>&nbsp;&nbsp;Quản Lý Nhóm
	                            	</div>
	                            </a>
	                        </li>
	                         <li class="divider"></li>
	                        <li>
	                            <a href="#">
	                            	<div style="margin-top:-8px">
	                            		<i class="fa fa-info-circle"></i>&nbsp;&nbsp;Thông Tin
	                            	</div>
	                            </a>
	                        </li>
	                         <li class="divider"></li>
	                        <li>
	                            <a href="#">
	                            	<div style="margin-top:-8px">
	                            		<i class="fa fa-sign-out"></i>&nbsp;&nbsp;Đăng xuất
	                            	</div>
	                            </a>
	                        </li>
	                    </ul>
                	</li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>