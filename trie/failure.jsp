<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.infy.util.IPatchConstants"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
       <link href="css/master.css" type="text/css" rel="stylesheet">
    </head>
    <body onload="window.history.forward(1);">
    <div id="main-nav-menu" align="center"><img class="imags" alt="Patch Tracker" src="images/patchImg.JPG" align="middle" style="width: 250px;" />
</div>


<div align="center" style="padding-top: 10px; vertical-align: middle; background-color: window;">

<font size="4" style="color: #400000;vertical-align: super;"><b><u>ERROR PAGE</u></b></font>

<!-- 
<div align="right" style="float: left;margin-left: 40px;padding-top:7px;">
<a href="login.jsp" style="text-shadow: aqua;" onclick="reLogin()"><font size="3" ><b><u>Home</u></b></font>
</a></div>
 -->

<hr>
</div>
        <div  style="display: table; padding-top: 50px;margin-left: 40px;" align="left">
            <font color="red" size="5" style="vertical-align: super;"><u>Error on Page</u></font>
            <img alt="Error" src="images/error.jpg">
          <!-- <p style="background-color: #F0F0F0;width: 200px;color: black;padding-top: 2px;padding-left: 5px;" ><font size="3">Something went Wrong!!!! -->
          <br>
          Exception Occured !!!
          <br>
          <logic:present name="addPatchForm" property="message">
			<logic:notEqual name="message" value="null">
				<center>
					<font color="Green" size="2"> <b> <bean:write
								name="addPatchForm" property="message" />
					</b>
					</font>
				</center>
			</logic:notEqual>
		</logic:present>
		<br>
          Please check and try again. Click <font color="Blue">
          &nbsp;&nbsp;<a href="login.jsp" style="text-shadow: aqua;" onclick="reLogin()"><font size="3" ><b><u>Home</u></b></font></a>&nbsp;&nbsp;
          </font> to go to main Page. 
          <br><br><br><br><br><br>
          <font size="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          - Patch Tracker<sup>®</sup></font>
           </font></p>
        </div>
        <div id="footer" style="margin-top: 241px;">
		<h4 align="left" style="vertical-align:middle; padding-left: 10px;">Copyright © 2013 Infosys Limited </h4>
		</div>
		
		<script type="text/javascript">
		 function reLogin(){
			
			 if(session!=null){
			  session.invalidate();
			 }
			 session = request.getSession(true);
		  }
		</script>
    </body>
</html>
