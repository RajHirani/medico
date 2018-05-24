package com.hd.medico.rest.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hd.medico.core.exception.GenericException;
import com.hd.medico.model.common.ApplicationConstant;
import com.hd.medico.model.common.ResultJson;
import com.hd.medico.model.drug.BrandBean;
import com.hd.medico.model.drug.DrugBean;
import com.hd.medico.rest.brand.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandResourceController {
	
	@Autowired
	BrandService brandService;
	
	
	/**
	 * @param drugBean
	 * @return
	 * @throws GenericException
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	ResultJson getAllBrandByDrugName(@RequestBody DrugBean drugBean) throws GenericException{
		
		List<BrandBean> brandBeanList = brandService.getAllBrandByDrugName(drugBean.getDrugName());
		if(brandBeanList!= null && brandBeanList.size()>0){
			return new ResultJson(ApplicationConstant.SUCCESS, brandBeanList , ApplicationConstant.SUCCESS_MSG);
		}else{
			return new ResultJson(ApplicationConstant.SUCCESS, "No Data Found" , ApplicationConstant.SUCCESS_MSG);
		}
	}
	

}
