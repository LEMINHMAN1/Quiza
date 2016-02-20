<!DOCTYPE html>

<%@ tag display-name="template" body-content="empty" pageEncoding="UTF-8" %>

<%@ attribute name="url" required="true" rtexprvalue="true" %>
<%@ attribute name="pageCode" required="true" rtexprvalue="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="<c:url value="/static/css/bt/bt.css" />" />
<link rel="stylesheet" href="<c:url value="/static/css/mt/mt.css" />" />
<link rel="stylesheet" href="<c:url value="/static/css/mor/mor.css" />" />
<link rel="stylesheet" href="<c:url value="/static/css/base/timeline.css" />" />
<link rel="stylesheet" href="<c:url value="/static/css/base/sb-admin-2.css" />" />
<link rel="stylesheet" href="<c:url value="/static/css/font/font-awesome.css" />" />

<link rel="stylesheet" href="<c:url value="/static/css/me/base.css" />" />

<script src="<c:url value="/static/script/jq/jq.js" />"></script>
<script src="<c:url value="/static/script/bt/bt.js" />"></script>
<script src="<c:url value="/static/script/mt/mt.js" />"></script>
<script src="<c:url value="/static/script/rap/rap.js" />"></script>

<script src="<c:url value="/static/script/base/sb-admin-2.js" />"></script>
<script src="<c:url value="/static/script/base/template.js" />"></script>

<%@ taglib prefix="quiz" tagdir="/WEB-INF/tags" %>

<div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a style="color:#DD6864;font-weight:bold;font-size:13" href="#">
                        Update To Pro ?
                    </a>
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <br/>
                        <li>
                            <a <c:if test="${pageCode==4}">class="active"</c:if> href="/myprofile.htm"><i class="fa fa-dashboard fa-fw"></i> Man Le's profile</a>
                        </li>
                        <li>
                            <a <c:if test="${pageCode==1}">class="active"</c:if> href="/mypage.htm"><i class="fa fa-newspaper-o fa-fw"></i> My Pages</a>
                        </li>
                        <li>
                            <a <c:if test="${pageCode==2}">class="active"</c:if> href="/cmtMng.htm"><i class="fa fa-comment-o"></i> Anti Comment</a>
                        </li>
                        <li>
                            <a href="index.html"><i class="fa fa-group"></i> Group Manager</a> <!-- Search all group and send request join, can search and save group public -->
                        </li>
                        <li>
                            <a <c:if test="${pageCode==3}">class="active"</c:if> href="/autopost.htm"><i class="fa fa-clock-o"></i> Auto Post</a> <!-- Search all group is PUBLIC, or group joined, and post on that, you can set schedule to post on Page at here-->
                        </li>
                        
                        <br/>
                        <li>
                            <a id="template_Logout" href="#"><i class="fa fa-sign-out"></i> Log out</a>
                        </li>
                        
                        <li class="line"></li>
                        <div style="text-align:center; margin-top:30px;margin-bottom:5px">
                        	ZSoft Copyright 2016
                        </div>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row"><div style="height:10px" class="col-lg-12"></div></div>
                <jsp:include page="${url}" />
        </div>

    </div>
    <!-- /#wrapper -->





















   