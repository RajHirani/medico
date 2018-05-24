package com.hd.medico.rest.drug.dao;

import java.util.List;

import com.hd.medico.core.exception.GenericException;
import com.hd.medico.model.drug.DrugBean;

/**
 * @author Raj Hirani
 */
public interface DrugDao {
	
	/**
	 * @return
	 */
	public List<DrugBean> getAllDrugs()throws GenericException;

}
