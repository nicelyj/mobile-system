package com.song7749.base;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.util.Log4jConfigurer;

/**
 * SqlMapClientFactory�� ���������� ����ȯ�濡 ���� �������� ȣ��. SqlMapClientFactoryBean Ŭ������
 * ��ӹ޾� ���������� �����ϴ� �κп� �б� ����.
 * 
 * @author song7749
 * 
 */
public class SqlMapClientFactoryBeanDynamic extends SqlMapClientFactoryBean {
	private static boolean isPrinted = false;

	/**
	 * ȯ�濡 ���� �Ѱܹ��� �Ķ���� �� �ϳ��� �����Ͽ� �۵�. ȯ�汸���� ���� �ý��� ȯ�溯���� �����. ���߼���(�׽�Ʈ����)���� �ݵ��
	 * JAVA_SERVER_SORT=TEST �� �����Ǿ�� ��.
	 * 
	 * @param developer
	 *            ������ PC�� ����.
	 * @param testServer
	 *            ���߼���(�׽�Ʈ����)�� ����.
	 * @param realServer
	 *            ���� ���� ������ ����.
	 */
	public SqlMapClientFactoryBeanDynamic(String developer, String testServer,
			String realServer) {
		Log logger = LogFactory.getLog(Log4jConfigurer.class);
		if (System.getenv("DEV_ADOPTED_ENV") == null) {
			System.out
					.println("***********************************************");
			System.out
					.println("***********************************************");
			System.out
					.println("cannot determind server environment. check your system parameter - 'DEV_ADOPTED_ENV' ");
			System.out
					.println("***********************************************");
			System.out
					.println("***********************************************");
			System.exit(0);
		}

		Properties properties = new Properties();
		properties.setProperty("SetAutoCommitAllowed", "false");
		super.setTransactionConfigProperties(properties);

		String configFile = null;
		String message = "";
		if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPER_PC")) {
			configFile = developer;
			message = "developer PC    ";
		} else if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPING_SERVER")) {
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
