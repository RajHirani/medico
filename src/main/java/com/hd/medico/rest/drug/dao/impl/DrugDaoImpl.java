package com.hd.medico.rest.drug.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hd.medico.core.db.BaseDao;
import com.hd.medico.core.exception.GenericException;
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
	public List<DrugBean> getAllDrugs() throws GenericException {
		
		String query = "SELECT i_drug_id as drugId, c_drug_name as drugName, t_input_date as inputDate, i_status as status FROM drug_list WHERE i_status > 0 ORDER BY c_drug_name";
		List<DrugBean> drugList = null;
		drugList = getSqlUtil().getQueryBeans(query, DrugBean.class);
		
		return drugList;
	}
}
