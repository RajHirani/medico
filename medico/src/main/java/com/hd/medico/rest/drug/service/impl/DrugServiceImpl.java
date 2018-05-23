package com.hd.medico.rest.drug.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hd.medico.model.drug.DrugBean;
import com.hd.medico.rest.drug.dao.DrugDao;
import com.hd.medico.rest.drug.service.DrugService;

/**
 * @author Raj Hirani
 */
@Service("drugService")
public class DrugServiceImpl implements DrugService{
	
	@Autowired
	DrugDao drugDao;

	@Override
	public List<DrugBean> getAllDrugDetails() {
		
		List<DrugBean> drugList =  drugDao.getAllDrugs();
		
		if(drugList!=null && drugList.size()>0){
			
		}
		
		
		return null;
	}

}
