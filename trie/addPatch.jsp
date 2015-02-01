<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.infy.util.IPatchConstants"%>
<%@ taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patch</title>
<link href="css/master.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="js/ext/yui/yui2/build/assets/skins/sam/calendar.css">
<script src="js/ext/yui/yui2/build/yahoo-dom-event/yahoo-dom-event.js"></script>
<script src="js/ext/yui/yui2/build/calendar/calendar-min.js"></script>
<script type="text/javascript" src="js/AutoComplete.js"></script>
<script type="text/javascript" src="js/FillPatch.js"></script>
</head>

<body onload="javascript:init();window.history.forward(1);"
	class="yui-skin-sam" onclick="monitorSearchDivState();">

	<div id="main-nav-menu" align="center">
		<img class="imags" alt="Patch Tracker" src="images/patchImg.JPG"
			align="middle" style="margin-left:170px;"/>

		<div align="right"
			style="float: right; padding-right: 15px; padding-top: 10px;">
			<font style="font-size: 10; color: black;"><b> User :: <%=session.getAttribute("userName")%></b>
			</font>&nbsp;&nbsp; <a href="login.jsp" id="alink" style="color: #400000;"
				onmouseover="document.getElementById('alink').style.backgroundColor = '#FFFFCC'"
				onmouseout="document.getElementById('alink').style.backgroundColor = '#FFFFFF'">Sign
				out</a>
		</div>
	</div>

	<div align="center"
		style="padding-top: 10px; vertical-align: middle; margin-left: 0px;">
		<font size="3" style="color: #400000;"><b>Add file to Patch
				Tracker</b></font>
	</div>

	<hr noshade="noshade" color="gray">

	<form action="addPatch.do" method="post" class="form1"
		onkeypress="return captureReturn(event);">
		
		<html:hidden property="fileNameUniqueness" name="addPatchForm" styleId="fileNameUniquenessHidden"/>
		
		<input type="hidden" name="searchInput" id="searchInput" value="" />
		<center>
			<font size="2">**<b> Please Enter Patch Details</b></font>
		</center>
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
		<table align="center" border="0" cellpadding="2" cellspacing="2">
			
			<tr>
				<td id="td1">Code Base<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2"><html:select name="addPatchForm"
						property="codeBase">
						<option value="Select">Select</option>
						<logic:present name="addPatchForm" property="codeBaseList">
							<logic:notEmpty name="addPatchForm" property="codeBaseList">
								<html:optionsCollection name="addPatchForm"
									property="codeBaseList" label="label" value="value" />
							</logic:notEmpty>
						</logic:present>

					</html:select> <br> <html:errors property="codeBase" /></td>
			</tr>
			<tr>
				<td id="td1">Defect Number:</td>
				<td id="td2"><html:text name="addPatchForm"
						property="defectNumber" size="1"></html:text> <br>
						<html:errors property="defectNumber"/>
				</td>
			</tr>

			<tr>
				<td id="td1">Block Point<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2"><html:select name="addPatchForm"
						property="blockPoint">
						<option value="Select">Select</option>
						<logic:present name="addPatchForm" property="blockPointList">
							<logic:notEmpty name="addPatchForm" property="blockPointList">
								<html:optionsCollection name="addPatchForm"
									property="blockPointList" label="label" value="value" />
							</logic:notEmpty>
						</logic:present>
					</html:select> <br> <html:errors property="blockPoint" /></td>
			</tr>

			<tr>

				<td id="td1">File Name<font color="red"><sup>*</sup></font>:
				</td>

				<td id="td2"> <input type="text" name="searchString"
					id="searchBox" size="400px;" style="width: 400px"
					onkeyup="return showResult(this.value,event);" autocomplete="off"><br>

					<div id="livesearch"
						style="width: 400px; word-wrap: break-word; display: block; position: absolute"></div>

					<br> <html:errors property="searchString" /></td>

			</tr>


			<tr>
				<td id="td1">File Name Uniqueness<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2">
			
		 		<input type="text" 
						id="fileUniqueness" value=""  size="1" disabled="disabled"/> 
					 <br> <html:errors property="fileNameUniqueness"/>
				</td>
			</tr>

			<tr>
				<td id="td1">Changed Description<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2"><html:text name="addPatchForm"
						property="changedDescription" size="400px;" style="width: 400px"></html:text> <br> <html:errors
						property="changedDescription" /></td>
			</tr>

			<tr>
				<td id="td1">VSS Version<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2"><html:text name="addPatchForm"
						property="vssVersion" size="2"></html:text> <br> <html:errors
						property="vssVersion" /></td>
			</tr>

		
			<tr>
				<td id="td1">New File<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2"><html:select name="addPatchForm"
						property="newFile">
						<option value="Select">Select</option>
						<logic:present name="addPatchForm" property="newFileList">
							<logic:notEmpty name="addPatchForm" property="newFileList">
								<html:optionsCollection name="addPatchForm"
									property="newFileList" label="label" value="value" />
							</logic:notEmpty>
						</logic:present>
					</html:select> <br> <html:errors property="newFile" /></td>
			</tr>
			
			<tr>
				<td id="td1">Critical Defect<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2">
				<html:select name="addPatchForm"
						property="criticalDefect">
						<option value="Select">Select</option>
						<option value="Yes">Yes</option>
						<option value="No">No</option>
				</html:select> <br> <html:errors property="newFile" /></td>
			</tr>



			<tr>
				<td id="td1">Impact Flows<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2"><html:select name="addPatchForm"
						property="impactFlows">
						<option value="Select">Select</option>
						<logic:present name="addPatchForm" property="impactFlowsList">
							<logic:notEmpty name="addPatchForm" property="impactFlowsList">
								<html:optionsCollection name="addPatchForm"
									property="impactFlowsList" label="label" value="value" />
							</logic:notEmpty>
						</logic:present>
					</html:select> <br> <html:errors property="impactFlows" /></td>
			</tr>

			<tr>
				<td id="td1">Delivery Date<font color="red"><sup>*</sup></font>:
				</td>
				<td id="td2"><input type="text" name="deliveryDate"
					title="Select Date" size="10" id="deliveryDate" readonly="readonly"/> <img BORDER="0"
					src="images/cal.gif" title="Calendar" align="middle"
					onclick="showCalendar('deliveryDate');"> <br> <html:errors
						property="deliveryDate" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<div id="calendarContainer" style="display: none;"></div>
				</td>
			</tr>

		</table>
		<br>
		<center>
			<input type="hidden" name="method" value="addPatch"> <input
				class="MediumButton" type="submit" value="Add" >
			<input class="MediumButton" type="reset" value="Reset">
		</center>
	</form>
	<div id="footer" style="margin-top: 90px;position: relative;">
		<h4 align="left" style="vertical-align: middle; padding-left: 10px;">
			<font color="white">Copyright © 2013 Infosys Limited</font>
		</h4>
	</div>
</body>
</html>