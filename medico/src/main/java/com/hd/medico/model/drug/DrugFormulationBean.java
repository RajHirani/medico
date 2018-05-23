package com.hd.medico.model.drug;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is used to store drug formulation by Company
 * @author Raj Hirani
 */
public class DrugFormulationBean implements Serializable {

	int formulationId;
	int drugId;
	int brandId;
	String dosage;
	String form;
	String presentation;
	String firstGrossess;
	String secondGrossess;
	String thirdGrossess;
	double price;
	int status;
	Date inputDate;
	Date updateDate;
	String inputUser;
	public int getFormulationId() {
		return formulationId;
	}
	public void setFormulationId(int formulationId) {
		this.formulationId = formulationId;
	}
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getFirstGrossess() {
		return firstGrossess;
	}
	public void setFirstGrossess(String firstGrossess) {
		this.firstGrossess = firstGrossess;
	}
	public String getSecondGrossess() {
		return secondGrossess;
	}
	public void setSecondGrossess(String secondGrossess) {
		this.secondGrossess = secondGrossess;
	}
	public String getThirdGrossess() {
		return thirdGrossess;
	}
	public void setThirdGrossess(String thirdGrossess) {
		this.thirdGrossess = thirdGrossess;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getInputDate() {
		return inputDate;
	}
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getInputUser() {
		return inputUser;
	}
	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}
}
