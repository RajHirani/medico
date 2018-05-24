package com.hd.medico.rest.brand.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.hd.medico.core.db.BaseDao;
import com.hd.medico.core.exception.GenericException;
import com.hd.medico.model.drug.BrandBean;
import com.hd.medico.model.drug.DrugFormulationBean;
import com.hd.medico.rest.brand.dao.BrandDao;

/**
 * @author Raj Hirani
 */
@Repository("brandDao")
public class BrandDaoImpl extends BaseDao implements BrandDao{

	/* (non-Javadoc)
	 * @see com.hd.medico.rest.brand.dao.BrandDao#getAllBrandByDrugName(java.lang.String)
	 */
	@Override
	public List<BrandBean> getAllBrandByDrugName(String drugName) throws GenericException {
		
		String query = "SELECT bl.i_brand_id as brandId, bl.brand_name as brandName,df.id_formulation_id as formulationId, df.drug_id as drugId, df.brand_id as brandId, df.dosage as dosage, df.form as form, df.presentation as presentation, df.first_grossess as firstGrossess, df.second_grossess as secondGrossess, df.third_grossess as thirdGrossess, df.price as price FROM brand_list bl LEFT JOIN drug_formulation df ON bl.i_brand_id = df.brand_id WHERE df.drug_id = (SELECT i_drug_id FROM drug_list dl WHERE dl.c_drug_name = ?) AND bl.i_status>0 ORDER BY bl.brand_name";
		Object[]  parmas = {
			drugName	
		};
		Map<String, BrandBean> brandMap = new HashMap<>();
		List<Map<String, Object>> dataList =  getSqlUtil().getQueryMaps(query, parmas);	
		
		for(Map<String, Object> data : dataList){
			String brandName = (String)data.get("brandName");
			DrugFormulationBean drugFormulationBean = getDrugFormulationFromMap(data);

			if(brandMap.containsKey(brandName)){
				brandMap.get(brandName).getDrugFormulationList().add(drugFormulationBean);
			}else{
				BrandBean brandBean = new BrandBean();
				
				brandBean.setBrandId(getIntValueFromMap(data, "brandId"));
				brandBean.setBrandName(getStringValueFromMap(data, "brandName"));
				brandBean.setStatus(1);
				
				List<DrugFormulationBean> drugFormulationList =  new ArrayList<DrugFormulationBean>();
				drugFormulationList.add(drugFormulationBean);
				
				brandBean.setDrugFormulationList(drugFormulationList);
				
				brandMap.put(brandName, brandBean);
			}
		}
		List<BrandBean> brandList = brandMap.values().stream()
				.collect(Collectors.toList());
		return brandList;
	}
	
	
	/**
	 * @param dataMap
	 * @return
	 */
	private DrugFormulationBean getDrugFormulationFromMap(Map<String, Object> dataMap){
		DrugFormulationBean drugFormulationBean = null;
		if(dataMap!= null && dataMap.size() > 0){
			drugFormulationBean = new DrugFormulationBean();
			drugFormulationBean.setFormulationId(getIntValueFromMap(dataMap, "formulationId"));
			drugFormulationBean.setDrugId(getIntValueFromMap(dataMap,"drugId"));
			drugFormulationBean.setBrandId(getIntValueFromMap(dataMap,"brandId"));
			drugFormulationBean.setDosage(getStringValueFromMap(dataMap, "dosage"));
			drugFormulationBean.setForm(getStringValueFromMap(dataMap, "form"));
			drugFormulationBean.setPresentation(getStringValueFromMap(dataMap, "presentation"));
			drugFormulationBean.setFirstGrossess(getStringValueFromMap(dataMap, "firstGrossess"));
			drugFormulationBean.setSecondGrossess(getStringValueFromMap(dataMap, "secondGrossess"));
			drugFormulationBean.setThirdGrossess(getStringValueFromMap(dataMap, "thirdGrossess"));
			drugFormulationBean.setPrice(getDoubleValueFromMap(dataMap, "price"));
		}
		
		return drugFormulationBean;
	}
	
	
	private String getStringValueFromMap(Map<String, Object> dataMap, String key){
		if(dataMap.get(key) != null){
			return (String)dataMap.get(key);
		}
		return null;
	}
	
	private int getIntValueFromMap(Map<String, Object> dataMap, String key){
		if(dataMap.get(key) != null){
			return (int)dataMap.get(key);
		}
		return 0;
	}
	
	private double getDoubleValueFromMap(Map<String, Object> dataMap, String key){
		if(dataMap.get(key) != null){
			return (double)dataMap.get(key);
		}
		return 0;
	}

}
