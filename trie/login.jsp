<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>

<head>

<title>Login Page</title>

<link href="css/master.css" type="text/css" rel="stylesheet">

<script type="text/javascript">

function getUser() {
		 
		   var IE = /*@cc_on!@*/false;
		   
		   if (IE) {
			   	var wshell = new ActiveXObject("WScript.Shell");
				var uName =wshell.ExpandEnvironmentStrings("%USERNAME%");
		        document.getElementById("userName").value = uName;
		        document.getElementById("userName").style.backgroundColor = "#FFCCCC";
		    
		        
			}
		   else {
			    alert("Please Open the Application in Internet Explorer !!");
			  /* netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');
			  var uName = Components.classes["@mozilla.org/process/environment;1"].getService(Components.interfaces.nsIEnvironment).get('username');
			  document.getElementById("userName").value = uName;
			  alert(uName); */
			  			   
			}
		   
		   
		   

		  
		  
	/* var user = Components.classes["@mozilla.org/process/environment;1"].getService(Components.interfaces.nsIEnvironment).get('USERNAME');
	alert(User);
    		  document.getElementById("userName").value = user; 
    		  request.getSession().setAttribute("UserName", user); */
}


function fnSubmit()

{
/* 
   if(document.forms[0].userName.value=="" || document.forms[0].userName.value == null || document.forms[0].srcDir.value == "")

   {
      alert('Please enter the UserId/ Source Directory');

      return false;

   } */

  document.forms[0].submit();

}


function changeHashOnLoad() {
    window.location.href += "#";
    setTimeout("changeHashAgain()", "50");
}

function changeHashAgain() 
{          
    window.location.href += "1";
}

var storedHash = window.location.hash;
window.setInterval(function () {
    if (window.location.hash != storedHash) {
        window.location.hash = storedHash;
    }
}, 50);


</script>

</head>

<body bgcolor="#F8F8F8" onload="getUser();changeHashOnLoad();">

<html:errors/>



<div id="page-container">
		
		<div id="main-nav" align="center">
		<img class="imags" alt="Patch Tracker" src="images/patchImg.JPG" align="middle" />
		
		</div>
	
		<div id="header"></div>
	
		<div id="sidebar-a">
		
				<html:form action="login.do" method="post">

       			  		<h4  align="center" style="color:#888888; vertical-align:top;font-size:14"><b><u>Patch Tracker</u></b></h4>
       			  		<h3 align="left">Sign in </h3><br>
       			  		       
						<b>User Name</b><br><br>
						<input name="userName" type="text"  id="userName" maxlength="30" size="25" /><br><br>
						
						<b>Workspace Source File's Path</b><br><br>
						<input name="srcPath"  type="text"  id="srcPath"  size="30" value="E:\\Codebase\\LSIE" disabled="disabled"/><br>
       			  		<br>
       					<b>If you have created new file, please contact Administrator.</b>
       					<br>
       			 		<input type="hidden" name="method" value="login">
					
					<input class="MediumButton" type="submit" value="Sign in" onclick="fnSubmit()">
					<br>
					<logic:present name="LoginForm" property="loginMessage">
						<logic:notEqual name="loginMessage" value="null">
							<hr noshade="noshade" width="100%">
		
								<center>
									<font color="Red" size="1"> <b> <bean:write name="LoginForm" property="loginMessage"/> </b> </font>
								</center>
						</logic:notEqual>
					</logic:present>
					<hr width="100%" noshade="noshade">
					<html:errors header="login.header" footer="login.footer"/>
			</html:form>
		</div>
	
		<div id="content">
		<img class="imgContent" alt="Patch Tracker" src="images/patch2.jpg" align="left" />
		</div>
	
		<div id="footer">
		<h4 align="left" style="vertical-align:middle; padding-left: 10px;"> <font color="white">Copyright © 2013 Infosys Limited</font></h4>
		</div>

</div>

</body>

</html>