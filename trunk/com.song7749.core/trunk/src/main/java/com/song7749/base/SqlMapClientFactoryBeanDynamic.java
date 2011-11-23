package com.song7749.base;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.util.Log4jConfigurer;

/**
 * <pre>
 * Class Name : SqlMapClientFactoryBeanDynamic.java
 * Description : 
 * 
 *  Modification Information
 *  Modify Date 			Modifier			Comment
 * -----------------------------------------------
 *  2011. 11. 23.		song7749		    신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 11. 23.
 */
public class SqlMapClientFactoryBeanDynamic extends SqlMapClientFactoryBean {
	private static boolean isPrinted = false;

	/**
	 * 환경에 따라 넘겨받은 파라메터 중 하나를 선택하여 작동. 환경구분을 위해 시스템 환경변수를 사용함. 개발서버(테스트서버)에는 반드시
	 * JAVA_SERVER_SORT=TEST 가 설정되어야 함.
	 * 
	 * @param developer
	 *            개발자 PC의 설정.
	 * @param testServer
	 *            개발서버(테스트서버)의 설정.
	 * @param realServer
	 *            실제 서비스 서버의 설정.
	 */
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
