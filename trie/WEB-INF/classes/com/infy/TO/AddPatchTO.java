package com.infy.TO;

public class AddPatchTO {
	private int serialNumber;
	private String patchDate;
	private String codeBase;
	private int defectNumber;
	private String blockPoint;
	private String fileName;
	private String filePath;
	private String fileNameUniqueness;
	private String patchTaken;
	private String changedDescription;
	private int vssVersion;
	private String checkedInBy;
	private String newFile;
	private String criticalDefect;
	private String impactFlows;
	private String isTestedByTestTeam;
	private String deliveryDate;
	
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public String getCheckedInBy() {
		return checkedInBy;
	}
	public void setCheckedInBy(String checkedInBy) {
		this.checkedInBy = checkedInBy;
	}
	
	public int getDefectNumber() {
		return defectNumber;
	}
	public void setDefectNumber(int defectNumber) {
		this.defectNumber = defectNumber;
	}
	public int getVssVersion() {
		return vssVersion;
	}
	public void setVssVersion(int vssVersion) {
		this.vssVersion = vssVersion;
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
}
