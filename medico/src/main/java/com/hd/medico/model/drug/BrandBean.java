package com.hd.medico.model.drug;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * This class used to store brand information.
 * @author Raj Hirani
 */
public class BrandBean implements Serializable {

	int brandId;
	String brandName;
	Date inputDate;
	int status;
	Date updateDate;
	List<DrugFormulationBean> drugFormulationList;
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public List<DrugFormulationBean> getDrugFormulationList() {
		return drugFormulationList;
	}
	public void setDrugFormulationList(List<DrugFormulationBean> drugFormulationList) {
		this.drugFormulationList = drugFormulationList;
	}

}
