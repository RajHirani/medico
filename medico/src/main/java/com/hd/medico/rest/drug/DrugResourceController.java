package com.hd.medico.rest.drug;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.medico.model.common.ApplicationConstant;
import com.hd.medico.model.common.ResultJson;
import com.hd.medico.model.drug.DrugBean;
import com.hd.medico.rest.drug.service.DrugService;

@RestController
@RequestMapping({"/drug"})
public class DrugResourceController {
	
	@Autowired
	DrugService drugService;
	
	@GetMapping({"/getAll"})
	ResultJson getAllDrug(){
		List<DrugBean> drugBeanList = drugService.getAllDrugDetails();
		if(drugBeanList!= null && drugBeanList.size()>0){
			return new ResultJson(ApplicationConstant.SUCCESS, drugBeanList , ApplicationConstant.SUCCESS_MSG);
		}else{
			return new ResultJson(ApplicationConstant.SUCCESS, "No Data Found" , ApplicationConstant.SUCCESS_MSG);
		}
	}
}
