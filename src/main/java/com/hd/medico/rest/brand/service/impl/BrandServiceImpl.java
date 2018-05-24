package com.hd.medico.rest.brand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.medico.core.exception.GenericException;
import com.hd.medico.model.drug.BrandBean;
import com.hd.medico.rest.brand.dao.BrandDao;
import com.hd.medico.rest.brand.service.BrandService;

/**
 * @author Raj Hirani
 *
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDao brandDao;
	
	/* (non-Javadoc)
	 * @see com.hd.medico.rest.brand.service.BrandService#getAllBrandByDrugName(java.lang.String)
	 */
	@Override
	public List<BrandBean> getAllBrandByDrugName(String drugName) throws GenericException {
		List<BrandBean> brandList = brandDao.getAllBrandByDrugName(drugName);
		return brandList;
	}

}
