package com.infy.action;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.LabelValueBean;

import com.infy.TO.AddPatchTO;
import com.infy.exceptions.AddPatchException;
import com.infy.forms.AddPatchForm;
import com.infy.manager.ServiceManager;
import com.infy.util.IPatchConstants;
/**
 * 
 * @author anoop_jadon
 *
 */
public class AddPatchAction extends DispatchAction{

	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	public ActionForward loadPage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		try
		{
			String dispatch = request.getParameter("method");
			ServiceManager serviceManager = new ServiceManager();
			AddPatchForm addPatchForm = (AddPatchForm)form;
			//HttpSession session = request.getSession();
			DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();

			if(dispatch.equalsIgnoreCase(IPatchConstants.DISPATCH)){

				List<LabelValueBean> codeBaseList;
				List<LabelValueBean> blockPointList;
				List<LabelValueBean> impactFlowsList;
				
				List<LabelValueBean> isTestedByTestTeamList = new ArrayList<LabelValueBean>();
				List<LabelValueBean> criticalDefectList =  new ArrayList<LabelValueBean>();
				List<LabelValueBean> newFileList =  new ArrayList<LabelValueBean>();
				List<LabelValueBean> patchTakenList =  new ArrayList<LabelValueBean>();
				//List<LabelValueBean> fileNameUniquenessList =  new ArrayList<LabelValueBean>();

				codeBaseList = serviceManager.fetchCodeBaseList(IPatchConstants.CODE_BASE);
				blockPointList = serviceManager.fetchCodeBaseList(IPatchConstants.BLOCK_POINT);
				impactFlowsList = serviceManager.fetchCodeBaseList(IPatchConstants.IMPACT_FLOWS);
				//String checkedInby = (String)request.getSession().getAttribute("userName");
				
				LabelValueBean labelValueBeanY = new LabelValueBean();
				labelValueBeanY.setLabel("Yes");
				labelValueBeanY.setValue("Yes");
				
				isTestedByTestTeamList.add(labelValueBeanY);
				criticalDefectList.add(labelValueBeanY);
				newFileList.add(labelValueBeanY);
				//fileNameUniquenessList.add(labelValueBeanY);
				
				LabelValueBean labelValueBeanN = new LabelValueBean();
				labelValueBeanN.setLabel("No");
				labelValueBeanN.setValue("No");
				
				isTestedByTestTeamList.add(labelValueBeanN);
				criticalDefectList.add(labelValueBeanN);
				newFileList.add(labelValueBeanN);
				//fileNameUniquenessList.add(labelValueBeanN);
				patchTakenList.add(labelValueBeanN);
				patchTakenList.add(labelValueBeanY);
				
				addPatchForm.setIsTestedByTestTeamList(isTestedByTestTeamList);
				addPatchForm.setCriticalDefectList(criticalDefectList);
				addPatchForm.setNewFileList(newFileList);
				addPatchForm.setPatchDate(dateformat.format(date));
				//addPatchForm.setFileNameUniquenessList(fileNameUniquenessList);
				addPatchForm.setPatchTakenList(patchTakenList);
				addPatchForm.setCheckedInBy(System.getenv("USERNAME"));
				addPatchForm.setCodeBaseList(codeBaseList);
				addPatchForm.setBlockPointList(blockPointList);
				addPatchForm.setImpactFlowsList(impactFlowsList);
				addPatchForm.setPatchDate(dateformat.format(date).toString());
				addPatchForm.setDeliveryDate(dateformat.format(date).toString());
			}
			//addPatchForm.reset(mapping, request);
			return mapping.getInputForward();
		}
		catch (AddPatchException e) {
			e.printStackTrace();
			return mapping.findForward("failure");
		}
		catch (Exception e) {

			return mapping.findForward("failure");
		}
	}

	public ActionForward addPatch(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		AddPatchForm addPatchForm = null;
		try
		{
			
			boolean isPersistSuccess = false;
			ServiceManager serviceManager = new ServiceManager();
			addPatchForm = (AddPatchForm)form;
			AddPatchTO addPatchTO = new AddPatchTO();
			
			DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(addPatchForm.getDeliveryDate());
			String checkedInBy = (String)request.getSession().getAttribute("userName");
			String fullPath = addPatchForm.getSearchString();
			String fileName = fullPath.substring((fullPath.lastIndexOf(File.separator)+1));
			String filePath = fullPath.substring(0,fullPath.lastIndexOf(File.separator));;
			
			addPatchTO.setPatchDate(addPatchForm.getPatchDate());
			addPatchTO.setCodeBase(addPatchForm.getCodeBase());
			if(null == addPatchForm.getDefectNumber() || addPatchForm.getDefectNumber().trim().equalsIgnoreCase(""))
			{
				addPatchTO.setDefectNumber(0);
			}
			else
			{
				addPatchTO.setDefectNumber(Integer.parseInt(addPatchForm.getDefectNumber()));
			}
			addPatchTO.setBlockPoint(addPatchForm.getBlockPoint());
			addPatchTO.setFileName(fileName);
			addPatchTO.setFilePath(filePath);
			addPatchTO.setFileNameUniqueness(addPatchForm.getFileNameUniqueness());
			addPatchTO.setPatchTaken("N");
			addPatchTO.setChangedDescription(addPatchForm.getChangedDescription());
			addPatchTO.setVssVersion(Integer.parseInt(addPatchForm.getVssVersion()));
			//addPatchTO.setCheckedInBy(System.getenv("USERNAME"))
			addPatchTO.setCheckedInBy(checkedInBy);
			addPatchTO.setNewFile(addPatchForm.getNewFile());
			addPatchTO.setCriticalDefect(addPatchForm.getCriticalDefect());
			addPatchTO.setImpactFlows(addPatchForm.getImpactFlows());
			addPatchTO.setIsTestedByTestTeam(addPatchForm.getIsTestedByTestTeam());
			addPatchTO.setDeliveryDate(dateformat.format(date));
			
			isPersistSuccess = serviceManager.persistPatchDetails(addPatchTO);
			if(isPersistSuccess){

				
				addPatchForm.reset(mapping, request);
				addPatchForm.setMessage("New Patch is Added Successfully !!!!");
				//return mapping.getInputForward();
				//response.sendRedirect(null);
				return mapping.findForward("success");
			}
			else{
				addPatchForm.setMessage("Add Patch operation failed !!!!");
				return mapping.findForward(FAILURE);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			addPatchForm.setMessage(e.getStackTrace().toString());
			return mapping.findForward("exception");
		}

	}

}
