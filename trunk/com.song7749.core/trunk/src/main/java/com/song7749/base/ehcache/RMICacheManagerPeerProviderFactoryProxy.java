package com.song7749.base.ehcache;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.StringTokenizer;

import net.sf.ehcache.distribution.CacheManagerPeerProvider;
import net.sf.ehcache.distribution.RMICacheManagerPeerProviderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Log4jConfigurer;

/**
 * ehcache의 분산캐시 설정에서 local address를 제거. 서버벌로 각각 ehcache.xml 설정파일을 참조하기 어렵기 때문에
 * 사용함.
 * 
 * @author throat
 * 
 */
public class RMICacheManagerPeerProviderFactoryProxy extends
		RMICacheManagerPeerProviderFactory {
	private static final Log logger = LogFactory.getLog(Log4jConfigurer.class);

	@Override
	protected CacheManagerPeerProvider createManuallyConfiguredCachePeerProvider(
			Properties arg0) {

		logger.info("[ehcache distribution setting]");

		if (System.getenv("DEV_ADOPTED_ENV") == null) {
			System.out
					.println("***********************************************");
			System.out
					.println("***********************************************");
			System.out
					.println("cannot determind server environment. check your system parameter - DEV_ADOPTED_ENV ");
			System.out
					.println("***********************************************");
			System.out
					.println("***********************************************");
			System.exit(0);
		}

		String rmiUrlsTemp = "";
		String message = "";

		if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPER_PC")) {
			rmiUrlsTemp = arg0.getProperty("rmiUrls-DEVELOPER_PC");
			message = "developer PC    ";
		} else if (System.getenv("DEV_ADOPTED_ENV").equals("DEVELOPING_SERVER")) {
			rmiUrlsTemp = arg0.getProperty("rmiUrls-DEVELOPING_SERVER");
			message = "test server     ";
		} else if (System.getenv("DEV_ADOPTED_ENV").equals("OPERATING_SERVER")) {
			rmiUrlsTemp = arg0.getProperty("rmiUrls-OPERATING_SERVER");
			message = "operating server";
		}

		logger.info("***********************************************");
		logger.info("*                                             *");
		logger.info("*EHCACHE-distribution env set to " + message + "*");
		logger.info("*                                             *");
		logger.info("***********************************************");

		StringTokenizer temp = new StringTokenizer(rmiUrlsTemp, "|");
		String rmiUrls = "";

		while (temp.hasMoreElements()) {
			String[] splits = (temp.nextToken().trim()).split("/");
			String[] addressTemp = splits[2].split(":");

			String localAddress = null;
			try {
				localAddress = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}

			if (localAddress.equals(addressTemp[0]) == false) {
				rmiUrls += "//" + addressTemp[0] + ":" + addressTemp[1] + "/"
						+ splits[3] + "|";
			} else {
				logger.info(addressTemp[0] + " is local address. skip.");
			}

		}

		arg0.put("rmiUrls", rmiUrls);
		return super.createManuallyConfiguredCachePeerProvider(arg0);
	}
}
