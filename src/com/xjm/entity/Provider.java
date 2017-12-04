package com.xjm.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Provider {
	private Integer id;
	@NotNull(message="供应商编码不能为空")
	@NotEmpty(message="供应商编码不能为空")
	private String proCode;
	@NotNull(message="供应商名称不能为空")
	@NotEmpty(message="供应商名称不能为空")
	private String proName;
	//描述
	private String proDesc;
	@NotNull(message="联系人不能为空")
	@NotEmpty(message="联系人不能为空")
	private String proContact;
	@NotNull(message="联系电话不能为空")
	@NotEmpty(message="联系电话不能为空")
	private String proPhone;
	@NotNull(message="地址不能为空")
	@NotEmpty(message="地址不能为空")
	private String proAddress;
	@NotNull(message="传真不能为空")
	@NotEmpty(message="传真不能为空")
	private String proFax;
	private Integer createdBy;
	private Date creationDate;
	private Date modifyDate;
	private Integer modifyBy;
	private List<Bill> billList;
	//企业营业执照
	private String photoPath;
	//组织机构代码证
	private String picturePath;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the proCode
	 */
	public String getProCode() {
		return proCode;
	}
	/**
	 * @param proCode the proCode to set
	 */
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	/**
	 * @return the proName
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName the proName to set
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return the proDesc
	 */
	public String getProDesc() {
		return proDesc;
	}
	/**
	 * @param proDesc the proDesc to set
	 */
	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}
	/**
	 * @return the proContact
	 */
	public String getProContact() {
		return proContact;
	}
	/**
	 * @param proContact the proContact to set
	 */
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	/**
	 * @return the proPhone
	 */
	public String getProPhone() {
		return proPhone;
	}
	/**
	 * @param proPhone the proPhone to set
	 */
	public void setProPhone(String proPhone) {
		this.proPhone = proPhone;
	}
	/**
	 * @return the proAddress
	 */
	public String getProAddress() {
		return proAddress;
	}
	/**
	 * @param proAddress the proAddress to set
	 */
	public void setProAddress(String proAddress) {
		this.proAddress = proAddress;
	}
	/**
	 * @return the proFax
	 */
	public String getProFax() {
		return proFax;
	}
	/**
	 * @param proFax the proFax to set
	 */
	public void setProFax(String proFax) {
		this.proFax = proFax;
	}
	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate() {
		return modifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * @return the modifyBy
	 */
	public Integer getModifyBy() {
		return modifyBy;
	}
	/**
	 * @param modifyBy the modifyBy to set
	 */
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	/**
	 * @return the billList
	 */
	public List<Bill> getBillList() {
		return billList;
	}
	/**
	 * @param billList the billList to set
	 */
	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}
	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}
	/**
	 * @return the picturePath
	 */
	public String getPicturePath() {
		return picturePath;
	}
	/**
	 * @param picturePath the picturePath to set
	 */
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public Provider(Integer id, String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, Integer createdBy, Date creationDate,
			Date modifyDate, Integer modifyBy, List<Bill> billList,
			String photoPath, String picturePath) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.billList = billList;
		this.photoPath = photoPath;
		this.picturePath = picturePath;
	}
	public Provider(String proCode, String proName, String proDesc,
			String proContact, String proPhone, String proAddress,
			String proFax, Integer createdBy, Date creationDate,
			Date modifyDate, Integer modifyBy, List<Bill> billList,
			String photoPath, String picturePath) {
		super();
		this.proCode = proCode;
		this.proName = proName;
		this.proDesc = proDesc;
		this.proContact = proContact;
		this.proPhone = proPhone;
		this.proAddress = proAddress;
		this.proFax = proFax;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyDate = modifyDate;
		this.modifyBy = modifyBy;
		this.billList = billList;
		this.photoPath = photoPath;
		this.picturePath = picturePath;
	}
	public Provider() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Provider [id=" + id + ", proCode=" + proCode + ", proName="
				+ proName + ", proDesc=" + proDesc + ", proContact="
				+ proContact + ", proPhone=" + proPhone + ", proAddress="
				+ proAddress + ", proFax=" + proFax + ", createdBy="
				+ createdBy + ", creationDate=" + creationDate
				+ ", modifyDate=" + modifyDate + ", modifyBy=" + modifyBy
				+ ", photoPath=" + photoPath + ", picturePath=" + picturePath
				+ "]";
	}
	
	
	

}
