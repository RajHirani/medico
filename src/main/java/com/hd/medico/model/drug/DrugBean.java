package com.hd.medico.model.drug;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * This Bean used to store drugs related information.
 * @author Raj Hirani
 */
public class DrugBean implements Serializable {

	int drugId;
	String drugName;
	Date inputDate;
	int status;
	List<BrandBean> brandList;
	
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<BrandBean> getBrandList() {
		return brandList;
	}
	public void setBrandList(List<BrandBean> brandList) {
		this.brandList = brandList;
	}
}