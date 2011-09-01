package com.song7749.web.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * ���ڿ� �ڸ���
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
	 * �±� ����
	 * 
	 * @param str
	 *            �±׸� ������ ���ڿ�
	 * @return returnValue �±׸� ������ ���ڿ�
	 */
	public static String removeTagAll(String str) {
		String returnValue = "";
		Pattern p = Pattern.compile("\\<(\\/?)(\\w+)*([^<>]*)>");
		Matcher m = p.matcher(str);
		returnValue = m.replaceAll("");
		return returnValue;
	}

	/**
	 * allowTags ���� �� �±׸� ����
	 * 
	 * @param str
	 *            �±׸� ������ ���ڿ�
	 * @param allowTags
	 *            ���ſ��� ���ܵ� �±�
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
	 * �̹��� ������¡�� ���� �̹��� ��ũ ��ȯ �ϱ�. �̹��� �������� ó�� ��Ʈ�ѷ��� �� �� ������Ʈ���� �ۼ��� �ؾ���
	 * 
	 * @param contents
	 * @param processUrl
	 *            �̹��� ������� ���� ó�� URL
	 * @param width
	 *            �������� �̹��� ������
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
			// FIXME replacement ����
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
			// �ǹ�����Ʈ �̹��� �������� ó��
			if (matcher.group(1).indexOf("silverlight") != -1) {
				replacement = "";
			}

			matcher.appendReplacement(sb, replacement);
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * �̹��� ������¡�� ���� �̹��� ��ũ ��ȯ �ϱ�. �̹��� �������� ó�� ��Ʈ�ѷ��� �� �� ������Ʈ���� �ۼ��� �ؾ���
	 * 
	 * @param contents
	 * @param processUrl
	 *            �̹��� ������� ���� ó�� URL
	 * @param width
	 * @return
	 */
	public static String getImgMatchedReplacement(String contents,
			String processUrl, String width) {
		return getImgMatchedReplacement(contents, processUrl, width, "N");
	}

	/**
	 * �̹��� ������¡�� ���� �̹��� ��ũ ��ȯ �ϱ�. �̹��� �������� ó�� ��Ʈ�ѷ��� �� �� ������Ʈ���� �ۼ��� �ؾ���
	 * 
	 * @param contents
	 * @param processUrl
	 *            �̹��� ������� ���� ó�� URL
	 * @return
	 */
	public static String getImgMatchedReplacement(String contents,
			String processUrl) {
		return getImgMatchedReplacement(contents, processUrl, null);
	}

	/**
	 * URLEncode �ƴ��� üũ �ϴ� �޼���
	 * 
	 * @param content
	 *            üũ �ϰ��� �ϴ¹��ڿ�
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
