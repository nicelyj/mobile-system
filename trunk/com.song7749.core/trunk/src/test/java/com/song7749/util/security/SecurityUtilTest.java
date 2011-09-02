package com.song7749.util.security;

import junit.framework.Assert;

import org.junit.Test;

public class SecurityUtilTest {
	public String testKey = "alsjdflasejghsdnbasdfasegsdrgsdrgsdrgsdr";
	public String resultKey = "464c583cd92a20d120dc81e3c1f32bd158935623c20900996ab031447eb960017f909a1865c385c437526fb1831c4f5b";

	@Test
	public void testEncrypt() {
		try {
			String result = SecurityUtil.encrypt(this.testKey);
			Assert.assertEquals(this.resultKey, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDecrypt() {

		try {
			String result = SecurityUtil.decrypt(this.resultKey);
			Assert.assertEquals(testKey, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
