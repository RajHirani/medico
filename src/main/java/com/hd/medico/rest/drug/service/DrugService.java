package com.hd.medico.rest.drug.service;

import java.util.List;

import com.hd.medico.core.exception.GenericException;
import com.hd.medico.model.drug.DrugBean;

/**
 * @author Raj Hirani
 */
public interface DrugService {

	/**
	 * @return
	 */
	public List<DrugBean> getAllDrugDetails() throws GenericException;
}
