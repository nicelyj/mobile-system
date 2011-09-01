package com.song7749.util.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <pre>
 * Class Name : SecurityUtil.java
 * Description : MD5 암호화 유틸
* 
*  Modification Information
*  Modify Date 	Modifier		Comment
* -----------------------------------------------
*  2011. 9. 1.	song7749		신규 생성
* 
* </pre>
* 
* @author song7749
* @since 2011. 9. 1.
*/
public class  SecurityUtil {

    /**
     * byte[] ret = HashUtil.digest("MD5", "abcd".getBytes());
     *  처럼 호출
     */
    public static byte[] digest(String alg, byte[] input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(alg);
        return md.digest(input);
    }

    public static String getCryptoMD5String(String inputValue) throws Exception {
        if( inputValue == null ) throw new Exception("Can't conver to Message Digest 5 String value!!");
        byte[] ret = digest("MD5", inputValue.getBytes());
        String result = Base64Util.encode(ret);    
        return result;
    }
}
