package com.hd.medico.rest.drug;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hd.medico.core.exception.GenericException;
import com.hd.medico.model.common.ApplicationConstant;
import com.hd.medico.model.common.ResultJson;
import com.hd.medico.model.drug.DrugBean;
import com.hd.medico.rest.drug.service.DrugService;

@RestController
@RequestMapping({"/drug"})
public class DrugResourceController {
	
	@Autowired
	DrugService drugService;
	
	/**
	 * @return
	 * @throws GenericException
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	ResultJson getAllDrug() throws GenericException{
		List<DrugBean> drugBeanList = drugService.getAllDrugDetails();
		if(drugBeanList!= null && drugBeanList.size()>0){
			return new ResultJson(ApplicationConstant.SUCCESS, drugBeanList , ApplicationConstant.SUCCESS_MSG);
		}else{
			return new ResultJson(ApplicationConstant.SUCCESS, "No Data Found" , ApplicationConstant.SUCCESS_MSG);
		}
	}
}
