package com.hd.medico.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hd.medico.core.db.SqlUtil;

/**
 * @author Raj Hirani
 *
 */
@Configuration
public class AppConfiguration {
	
	private static Map<String, String> configMap = new HashMap<String, String>();
	
	@Bean("sqlUtil")
	public SqlUtil getSqlUtil() {
		return new SqlUtil();
	}
	
	public static String getConfigValue(String key){
		return configMap.get(key);
	}
	
	public static void putConfigValue(String key, String value){
		configMap.put(key, value);
	}

}
