package com.song7749.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <pre>
 * Class Name : StringUtil.java
 * Description : 스트링 관련 유틸리티
 * 
 *  Modification Information
 *  Modify Date		Modifier		Comment
 * ---------------------------------------------------
 *  2011. 11. 23.	song7749		신규 생성
 * 
 * </pre>
 * 
 * @author song7749
 * @since 2011. 11. 23.
 */

public class StringUtil {
	/**
	 * 문자열 자르기
	 * 
	 * @param str
	 * @param strSize
	 * @param endPix
	 * @return returnString
	 */
	public static String cutString(String str, Integer strSize, String endPix) {
		String returnString = "";
		if (str.length() > strSize) {
			returnString = str.substring(0, strSize) + endPix;
		} else {
			returnString = str;
		}
		return returnString;
	}

	/**
	 * 태그 제거
	 * 
	 * @param str
	 *            태그를 포함한 문자열
	 * @return returnValue 태그를 제거한 문자열
	 */
	public static String removeTagAll(String str) {
		String returnValue = "";
		Pattern p = Pattern.compile("\\<(\\/?)(\\w+)*([^<>]*)>");
		Matcher m = p.matcher(str);
		returnValue = m.replaceAll("");
		return returnValue;
	}

	/**
	 * allowTags 제외 후 태그만 제거
	 * 
	 * @param str
	 *            태그를 포함한 문자열
	 * @param allowTags
	 *            제거에서 제외될 태그
	 * @return
	 */
	public static String stripTags(String str, String allowTags) {
		String returnValue = "";
		String tags = allowTags.replace(",", "|");
		Pattern p = Pattern
				.compile("<(\\/?)(?!\\/|(?i)" + tags + ")([^<>]*)?>");
		Matcher m = p.matcher(str);
		returnValue = m.replaceAll("");
		return returnValue;
	}

	/**
	 * 이미지 리사이징을 위한 이미지 링크 변환 하기. 이미지 리사이즈 처리 컨트롤러를 각 웹 프로젝트에서 작성을 해야함
	 * 
	 * @param contents
	 * @param processUrl
	 *            이미지 리사이즈를 위한 처리 URL
	 * @param width
	 *            리사이즈 이미지 사이즈
	 * @param largeImageMake
	 *            (N:false, Y:true)
	 * @return
	 */
	public static String getImgMatchedReplacement(String contents,
			String processUrl, String width, String largeImageMake) {
		StringBuffer sb = new StringBuffer();
		String replacement = "";
		if (contents == null) {
			return "";
		}
		Pattern pattern = Pattern
				.compile("(?i)<img[^<>]*src=[\"']?([^>\"']+)[\"']?[^<>]*>");
		java.util.regex.Matcher matcher = pattern.matcher(contents);
		while (matcher.find()) {
			// FIXME replacement 수정
			if (width != null) {
				replacement = "<p align=\"center\"><table width=\"100%\"><tr><td align=\"center\"><table><tr><td><div class=\"nsthum\"><img src=\""
						+ processUrl
						+ "?src="
						+ matcher.group(1)
						+ "&width="
						+ width
						+ "&largeImageMake="
						+ largeImageMake
						+ "\" border=\"0\" name=\"descImage[]\" class=\""
						+ matcher.group(1)
						+ "\"/><span class=\"zoom\" id=\"zoom[]\" name=\"zoom[]\"></span></div></td></tr></table></td></tr></table></p>";
			} else {
				replacement = "<p align=\"center\"><table width=\"100%\"><tr><td align=\"center\"><table><tr><td><div class=\"nsthum\"><img src=\""
						+ processUrl
						+ "?src="
						+ matcher.group(1)
						+ "&largeImageMake="
						+ largeImageMake
						+ "\" border=\"0\" name=\"descImage[]\" class=\""
						+ matcher.group(1)
						+ "\"/><span class=\"zoom\" id=\"zoom[]\" name=\"zoom[]\"></span></div></td></tr></table></td></tr></table></p>";
			}
			// 실버라이트 이미지 공백으로 처리
			if (matcher.group(1).indexOf("silverlight") != -1) {
				replacement = "";
			}

			matcher.appendReplacement(sb, replacement);
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 이미지 리사이징을 위한 이미지 링크 변환 하기. 이미지 리사이즈 처리 컨트롤러를 각 웹 프로젝트에서 작성을 해야함
	 * 
	 * @param contents
	 * @param processUrl
	 *            이미지 리사이즈를 위한 처리 URL
	 * @param width
	 * @return
	 */
	public static String getImgMatchedReplacement(String contents,
			String processUrl, String width) {
		return getImgMatchedReplacement(contents, processUrl, width, "N");
	}

	/**
	 * 이미지 리사이징을 위한 이미지 링크 변환 하기. 이미지 리사이즈 처리 컨트롤러를 각 웹 프로젝트에서 작성을 해야함
	 * 
	 * @param contents
	 * @param processUrl
	 *            이미지 리사이즈를 위한 처리 URL
	 * @return
	 */
	public static String getImgMatchedReplacement(String contents,
			String processUrl) {
		return getImgMatchedReplacement(contents, processUrl, null);
	}

	/**
	 * URLEncode 됐는지 체크 하는 메서드
	 * 
	 * @param content
	 *            체크 하고자 하는문자열
	 * @return
	 */
	public static boolean isUrlEncoded(String content) {
		return content.matches(".*%[a-fA-F0-9][a-fA-F0-9].*");
	}

	/**
	 * URLEncode
	 * 
	 * @param content
	 * @param contentType
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String UrlEncode(String content, String contentType)
			throws UnsupportedEncodingException {
		return URLEncoder.encode(content, contentType).replace("+", "%20")
				.replace("*", "%2A").replace("%7E", "~");
	}
}
