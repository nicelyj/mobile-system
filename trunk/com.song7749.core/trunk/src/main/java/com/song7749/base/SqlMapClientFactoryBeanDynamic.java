package com.song7749.base;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.util.Log4jConfigurer;

public class SqlMapClientFactoryBeanDynamic extends SqlMapClientFactoryBean {
	private static boolean isPrinted = false;

	public SqlMapClientFactoryBeanDynamic(String developer, String testServer,
			String realServer) {
		Log logger = LogFactory.getLog(Log4jConfigurer.class);

		Properties properties = new Properties();
		properties.setProperty("SetAutoCommitAllowed", "false");
		super.setTransactionConfigProperties(properties);

		String configFile = null;
		String message = "";
		if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPER_PC")) {
			configFile = developer;
			message = "developer PC    ";
		} else if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPING_SERVER")
				|| System.getenv("DEV_ADOPTED_ENV") == null) {
			configFile = testServer;
			message = "test server     ";
		} else if (System.getenv("DEV_ADOPTED_ENV").equals("OPERATING_SERVER")) {
			configFile = realServer;
			message = "operating server";
		}

		if (this.isPrinted == false) {
			logger.info("***********************************************");
			logger.info("*                                             *");
			logger.info("*  DB connection info set to " + message + " *");
			logger.info("*                                             *");
			logger.info("***********************************************");
			this.isPrinted = true;
		}

		Resource rs = new ClassPathResource(configFile);
		super.setConfigLocation(rs);
	}
}
