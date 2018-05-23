package com.hd.medico.rest.drug.dao;

import java.util.List;

import com.hd.medico.model.drug.BrandBean;
import com.hd.medico.model.drug.DrugBean;

/**
 * @author Raj Hirani
 */
public interface DrugDao {
	
	/**
	 * @return
	 */
	public List<DrugBean> getAllDrugs();
	
	/**
	 * @return
	 */
	public List<BrandBean> getBrandWithDrugId(int drugId);

}
