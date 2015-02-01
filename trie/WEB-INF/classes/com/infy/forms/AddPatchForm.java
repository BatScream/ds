package com.infy.forms;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;
/**
 * 
 * @author anoop_jadon
 *
 */

public class AddPatchForm extends ActionForm
{
	private int serialNumber;
	private String patchDate;
	private String codeBase;
	private String defectNumber;
	private String blockPoint;
	private String searchString;
//	private String filePath;
	private String fileNameUniqueness;
	private String patchTaken;
	private String changedDescription;
	private String vssVersion;
	private String checkedInBy;
	private String newFile;
	private String criticalDefect;
	private String impactFlows;
	private String isTestedByTestTeam;
	private String deliveryDate;
	private String message;
	
	private List<LabelValueBean> codeBaseList;
	private List<LabelValueBean> blockPointList;
	private List<LabelValueBean> impactFlowsList;
	
	private List<LabelValueBean> isTestedByTestTeamList;
	private List<LabelValueBean> criticalDefectList;
	private List<LabelValueBean> newFileList;
	private List<LabelValueBean> patchTakenList;
	private List<LabelValueBean> fileNameUniquenessList;
	
	
	
	
	public List<LabelValueBean> getFileNameUniquenessList() {
		return fileNameUniquenessList;
	}

	public void setFileNameUniquenessList(
			List<LabelValueBean> fileNameUniquenessList) {
		this.fileNameUniquenessList = fileNameUniquenessList;
	}

	public List<LabelValueBean> getPatchTakenList() {
		return patchTakenList;
	}

	public void setPatchTakenList(List<LabelValueBean> patchTakenList) {
		this.patchTakenList = patchTakenList;
	}

	public List<LabelValueBean> getIsTestedByTestTeamList() {
		return isTestedByTestTeamList;
	}

	public void setIsTestedByTestTeamList(
			List<LabelValueBean> isTestedByTestTeamList) {
		this.isTestedByTestTeamList = isTestedByTestTeamList;
	}

	public List<LabelValueBean> getCriticalDefectList() {
		return criticalDefectList;
	}

	public void setCriticalDefectList(List<LabelValueBean> criticalDefectList) {
		this.criticalDefectList = criticalDefectList;
	}

	public List<LabelValueBean> getNewFileList() {
		return newFileList;
	}
	
	public void setNewFileList(List<LabelValueBean> newFileList) {
		this.newFileList = newFileList;
	}


		
	/*public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}*/

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<LabelValueBean> getCodeBaseList() {
		return codeBaseList;
	}

	public void setCodeBaseList(List<LabelValueBean> codeBaseList) {
		this.codeBaseList = codeBaseList;
	}

	public List<LabelValueBean> getBlockPointList() {
		return blockPointList;
	}

	public void setBlockPointList(List<LabelValueBean> blockPointList) {
		this.blockPointList = blockPointList;
	}

	public List<LabelValueBean> getImpactFlowsList() {
		return impactFlowsList;
	}

	public void setImpactFlowsList(List<LabelValueBean> impactFlowsList) {
		this.impactFlowsList = impactFlowsList;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getPatchDate() {
		return patchDate;
	}

	public void setPatchDate(String patchDate) {
		this.patchDate = patchDate;
	}

	public String getCodeBase() {
		return codeBase;
	}

	public void setCodeBase(String codeBase) {
		this.codeBase = codeBase;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBlockPoint() {
		return blockPoint;
	}

	public void setBlockPoint(String blockPoint) {
		this.blockPoint = blockPoint;
	}


	public String getFileNameUniqueness() {
		return fileNameUniqueness;
	}

	public void setFileNameUniqueness(String fileNameUniqueness) {
		this.fileNameUniqueness = fileNameUniqueness;
	}

	public String getPatchTaken() {
		return patchTaken;
	}

	public void setPatchTaken(String patchTaken) {
		this.patchTaken = patchTaken;
	}

	public String getChangedDescription() {
		return changedDescription;
	}

	public void setChangedDescription(String changedDescription) {
		this.changedDescription = changedDescription;
	}



	public String getDefectNumber() {
		return defectNumber;
	}

	public void setDefectNumber(String defectNumber) {
		this.defectNumber = defectNumber;
	}

	public String getVssVersion() {
		return vssVersion;
	}

	public void setVssVersion(String vssVersion) {
		this.vssVersion = vssVersion;
	}

	public String getCheckedInBy() {
		return checkedInBy;
	}

	public void setCheckedInBy(String checkedInBy) {
		this.checkedInBy = checkedInBy;
	}

	public String getNewFile() {
		return newFile;
	}

	public void setNewFile(String newFile) {
		this.newFile = newFile;
	}

	public String getCriticalDefect() {
		return criticalDefect;
	}

	public void setCriticalDefect(String criticalDefect) {
		this.criticalDefect = criticalDefect;
	}

	public String getImpactFlows() {
		return impactFlows;
	}

	public void setImpactFlows(String impactFlows) {
		this.impactFlows = impactFlows;
	}

	public String getIsTestedByTestTeam() {
		return isTestedByTestTeam;
	}

	public void setIsTestedByTestTeam(String isTestedByTestTeam) {
		this.isTestedByTestTeam = isTestedByTestTeam;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		codeBase = null;
		blockPoint = null;
		defectNumber = null;
		fileNameUniqueness = null;
		patchTaken = null;
		changedDescription = null;
		vssVersion = null;
		newFile = null;
		criticalDefect = null;
		impactFlows = null;
		isTestedByTestTeam = null;
		message = null;
	}
	

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
			ActionErrors errors = new ActionErrors();

		if(codeBase!= null && codeBase.equalsIgnoreCase("Select")){
			errors.add("codeBase",
					new ActionMessage("error.codeBase"));
		}
		
		if(checkedInBy != null && (checkedInBy.trim().equalsIgnoreCase("")&& checkedInBy.length()<=0))
		{
			errors.add("checkedInBy",
					new ActionMessage("error.checkedInBy"));
		}
		
		if(patchDate != null && (patchDate.trim().equalsIgnoreCase("")&& patchDate.length()<=0))
		{
			errors.add("patchDate",
					new ActionMessage("error.patchDate"));
		}
		if(patchDate!=null && patchDate.matches("\\d{4}-\\d{2}-\\d{2}"))
		{
			errors.add("patchDate",
					new ActionMessage("error.date.format"));
		}
		
		if(deliveryDate != null && (deliveryDate.trim().equalsIgnoreCase("")&& deliveryDate.length()<=0))
		{
			errors.add("deliveryDate",
					new ActionMessage("error.date"));
		}
		if(deliveryDate!=null && deliveryDate.matches("\\d{4}-\\d{2}-\\d{2}"))
		{
			errors.add("deliveryDate",
					new ActionMessage("error.date.format"));
		}
		
		
		if(isTestedByTestTeam!=null && isTestedByTestTeam.equalsIgnoreCase("Select"))
		{
			errors.add("isTestedByTestTeam",
					new ActionMessage("error.isTestedByTestTeam"));
		}
		
		if(blockPoint!=null && blockPoint.equalsIgnoreCase("Select"))
		{
			errors.add("blockPoint",
					new ActionMessage("error.blockPoint"));
		}
		if(fileNameUniqueness != null && fileNameUniqueness.equalsIgnoreCase("Select"))
		{
			errors.add("fileNameUniqueness",
					new ActionMessage("error.fileNameUniqueness"));
		}

		if(patchTaken !=null && patchTaken.equalsIgnoreCase("Select"))
		{
			errors.add("patchTaken",
					new ActionMessage("error.patchTaken"));
		}
		
		if(searchString != null && searchString.trim().length()==0)
		{
			
			errors.add("searchString",
					new ActionMessage("error.autocomplete"));
			
		}
		
		if(changedDescription != null && changedDescription.trim().length()==0)
		{
			
			errors.add("changedDescription",
					new ActionMessage("error.changedDescription"));
			
		}
		
		if(vssVersion != null && (vssVersion.trim().equalsIgnoreCase("")&& vssVersion.length()<=0))
		{
			errors.add("vssVersion",
					new ActionMessage("error.vssVersion"));
			
		}
		
		else if(vssVersion != null && !(vssVersion.trim().equalsIgnoreCase("")&& vssVersion.length()<=0)){
			String regExp = "^(?=.*[1-9])([0-9]+)$";
			Pattern pattern = Pattern.compile(regExp);
		    Matcher matcher = pattern.matcher(vssVersion);
			if(!matcher.matches())
			{
				errors.add("vssVersion",
						new ActionMessage("error.invalid.vssVersion"));
				
			}
			}
				
		if(criticalDefect != null && criticalDefect.equalsIgnoreCase("Select"))
		{
			errors.add("criticalDefect",
					new ActionMessage("error.criticalDefect"));
			
		}

		if(impactFlows!=null && impactFlows.equalsIgnoreCase("Select"))
		{
			errors.add("impactFlows",
					new ActionMessage("error.impactFlows"));
		}
		
		if(newFile != null && newFile.equalsIgnoreCase("Select"))
		{
			errors.add("newFile",
					new ActionMessage("error.newFile"));
			
		}
		
		/*if(defectNumber != null && (defectNumber.trim().equalsIgnoreCase("")&& defectNumber.length()<=0)){
			errors.add("defectNumber",
					new ActionMessage("error.defectNumber"));
		}*/
		// validation for defect number a Integer or not.
		else if(defectNumber != null && !(defectNumber.trim().equalsIgnoreCase("")&& defectNumber.length()<=0)){
		String regExp = "^(?=.*[1-9])([0-9]+)$";
		Pattern pattern = Pattern.compile(regExp);
	    Matcher matcher = pattern.matcher(defectNumber);
		if(!matcher.matches())
		{
			errors.add("defectNumber",
					new ActionMessage("error.invalid.defectNumber"));
			
		}
		}
		
		return errors;
	}

/*public void setAttributes(HttpServletRequest request){
	List<LabelValueBean> defectStatusList;
	try{
	ServiceManager serviceManager = new ServiceManager();
	defectStatusList = serviceManager.fetchDefectStatus();
	request.setAttribute("defectStatusList", defectStatusList);
	}
	catch(AddDefectException ex){
		System.err.print("Exception: ");
	
		System.err.println(ex.getMessage());
	}
}*/

	/*
	 * 
	 */
	
	


	private static final long serialVersionUID = 1L;

}
