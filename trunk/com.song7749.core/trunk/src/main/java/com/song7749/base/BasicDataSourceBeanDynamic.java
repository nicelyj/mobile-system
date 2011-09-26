package com.song7749.base;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.dbcp.BasicDataSource;

public class BasicDataSourceBeanDynamic extends BasicDataSource {

	public BasicDataSourceBeanDynamic(String developer, String testServer,
			String realServer) {

		String configFile = null;
		if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPER_PC")) {
			configFile = developer;
		} else if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPING_SERVER")) {
			configFile = testServer;
		} else if (System.getenv("DEV_ADOPTED_ENV").equals("OPERATING_SERVER")) {
			configFile = realServer;
		}

		PropertiesConfiguration config = null;
		try {
			config = new PropertiesConfiguration(configFile);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}

		super.setDriverClassName(config.getString("driverClassName"));
		super.setUrl(config.getString("url"));
		super.setUsername(config.getString("username"));
		super.setPassword(config.getString("password"));

		super.setMaxActive(30);
		super.setInitialSize(2);
		super.setMaxIdle(30);
		super.setMaxWait(60000);
		super.setValidationQuery("select 1");
		super.setTestWhileIdle(true);
		super.setMinEvictableIdleTimeMillis(20000);
		super.setTimeBetweenEvictionRunsMillis(20000);
		super.setRemoveAbandoned(true);
		super.setRemoveAbandonedTimeout(60);
		super.setLogAbandoned(true);
		super.setTestWhileIdle(true);

		// super.setMaxActive(Integer.parseInt(properties.getProperty("maxActive")));

	}
}
