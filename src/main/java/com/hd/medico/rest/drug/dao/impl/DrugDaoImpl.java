package com.hd.medico.rest.drug.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hd.medico.core.db.BaseDao;
import com.hd.medico.model.drug.BrandBean;
import com.hd.medico.model.drug.DrugBean;
import com.hd.medico.rest.drug.dao.DrugDao;

/**
 * @author Raj Hirani
 */
@Repository("drugDao")
public class DrugDaoImpl extends BaseDao implements DrugDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.hd.medico.rest.drug.dao.DrugDao#getAllDrugs()
	 */
	@Override
	public List<DrugBean> getAllDrugs() {
		
		String query = "SELECT dl.i_drug_id as drugId ,dl.c_drug_name as drugName, bl.i_brand_id as brandId ,bl.brand_name, df.id_formulation_id as formulationId ,df.dosage as dosage, df.form as form, df.presentation as presentation, df.first_grossess as firstGrossess, df.second_grossess as secondGrossess, df.third_grossess as thirdGrossess, df.price as price FROM drug_formulation df, drug_list dl, brand_list bl WHERE dl.i_drug_id = df.drug_id AND bl.i_brand_id = df.brand_id AND df.i_status>0 ORDER BY dl.c_drug_name";
		List<DrugBean> drugList = null;
		List<Map<String, Object>> dataList = null;
		
		try {
			dataList = getSqlUtil().getQueryMaps(query);
			
			if(dataList != null && dataList.size()>0){
				for(Map<String, Object> map : dataList){
					String drugName = (String)map.get("drugName");
					if(drugName != null && !drugName.isEmpty()){
						
						DrugBean drugBean = new DrugBean();
						drugBean.setDrugId((int)map.get("drugName"));
						drugBean.setDrugName(drugName);
						
						if(drugList.contains(drugBean)){
							
						}else{
							drugList.add(drugBean);
						}
					}
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return drugList;
	}

	@Override
	public List<BrandBean> getBrandWithDrugId(int drugId) {
		
		List<BrandBean> brandList = null;
		
		
		
		return null;
	}
}
