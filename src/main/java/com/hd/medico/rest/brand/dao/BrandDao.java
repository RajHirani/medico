package com.hd.medico.rest.brand.dao;

import java.util.List;

import com.hd.medico.core.exception.GenericException;
import com.hd.medico.model.drug.BrandBean;

/**
 * @author Raj Hirani
 */
public interface BrandDao {

	/**
	 * @param drugName
	 * @return
	 * @throws GenericException
	 */
	List<BrandBean> getAllBrandByDrugName(String drugName) throws GenericException;
}
