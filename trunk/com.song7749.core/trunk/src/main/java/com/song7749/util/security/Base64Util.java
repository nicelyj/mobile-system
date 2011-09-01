package com.song7749.util.security;

import sun.misc.*;
import java.io.*;

/**
 * <pre>
 * Class Name : Base64Util.java
 * Description : Base64 ���� ��ƿ
* 
*  Modification Information
*  Modify Date 	Modifier		Comment
* -----------------------------------------------
*  2011. 9. 1.	song7749		�ű� ����
* 
* </pre>
* 
* @author song7749
* @since 2011. 9. 1.
*/
public class Base64Util {

    public Base64Util() {}

    /**
     * Base64Encoding�� �����Ѵ�. binany in ascii out
     *
     * @param encodeBytes encoding�� byte array
     * @return encoding �� String
     */
    public static String encode(byte[] encodeBytes) {
        
        BASE64Encoder base64Encoder = new BASE64Encoder();
        ByteArrayInputStream bin = new ByteArrayInputStream(encodeBytes);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buf = null;

        try{
            base64Encoder.encodeBuffer(bin, bout);
        } catch(Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        buf = bout.toByteArray();
        return new String(buf).trim();
    }

    /**
     * Base64Decoding �����Ѵ�. binany out ascii in
     *
     * @param strDecode decoding�� String
     * @return decoding �� byte array
     */
    public static byte[] decode(String strDecode) {
        
        BASE64Decoder base64Decoder = new BASE64Decoder();
        ByteArrayInputStream bin = new ByteArrayInputStream(strDecode.getBytes());
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        byte[] buf = null;

        try { 
            base64Decoder.decodeBuffer(bin, bout);
        } catch(Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }

        buf = bout.toByteArray();

        return buf;

    }
}