package toolutf;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符编码工具类
 *
 * @author _minus
 * @create 2017-11-06 18:38
 */
public class CharsetUtils {
	private enum Charset {
		/** 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块 */
		US_ASCII("US-ASCII", "位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块 "), ISO_8859_1("ISO-8859-1", "ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1"), UTF_8("UTF-8", "8 位 UCS 转换格式"), UTF_16BE("UTF-16BE", "16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序"), UTF_16LE("UTF_16LE", "16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序"), UTF_16("UTF_16", "16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识"), GBK("GBK", "中文超大字符集");
		private String encode;
		private String desc;

		public String getEncode() {
			return encode;
		}

		public void setEncode(String encode) {
			this.encode = encode;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		private Charset(String encode, String desc) {
			this.encode = encode;
			this.desc = desc;

		}

		public static Charset forName(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		public char[] decode(ByteBuffer b) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	/**
	 * 获取传入字符串的编码格式
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncode(String str) throws UnsupportedEncodingException {
		if (!StringUtils.isEmpty(str)) {
			for (Charset charset : Charset.values()) {
				if (str.equals(new String(str.getBytes(charset.getEncode()), charset.getEncode()))) {
					return charset.getEncode();
				}
			}
		}
		throw new UnsupportedEncodingException("编码库中不存在");
	}

	/**
	 * 解码 Unicode1 \\uXXXX
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeUnicode1(String str) {
		Charset set = Charset.forName("UTF-16");
		Pattern p = Pattern.compile("\\\\u([0-9a-fA-F]{4})");
		Matcher m = p.matcher(str);
		int start = 0;
		int start2 = 0;
		StringBuffer sb = new StringBuffer();
		while (m.find(start)) {
			start2 = m.start();
			if (start2 > start) {
				String seg = str.substring(start, start2);
				sb.append(seg);
			}
			String code = m.group(1);
			int i = Integer.valueOf(code, 16);
			byte[] bb = new byte[4];
			bb[0] = (byte) ((i >> 8) & 0xFF);
			bb[1] = (byte) (i & 0xFF);
			ByteBuffer b = ByteBuffer.wrap(bb);
			sb.append(String.valueOf(set.decode(b)).trim());
			start = m.end();
		}
		start2 = str.length();
		if (start2 > start) {
			String seg = str.substring(start, start2);
			sb.append(seg);
		}
		return sb.toString();
	}

	/**
	 * 解码 Unicode2 \\uXXXX
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeUnicode2(String str) {
		String s2 = null;
		try {
			byte[] converttoBytes = str.getBytes("UTF-8");
			s2 = new String(converttoBytes, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s2;
	}

	public static String decodeUnicode3(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
						}

					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}

	/**
	 * 字符串编码转换的实现方法
	 * 
	 * @param str
	 *            待转换编码的字符串
	 * @param newCharset
	 *            目标编码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			// 获取到原字符编码
			String charsetName = getEncode(str);
			System.out.println("原字符编码为：" + charsetName);
			// 用默认字符编码解码字符串。
			byte[] bs = str.getBytes(charsetName);
			// 用新的字符编码生成字符串
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * 将字符编码转换成US-ASCII码
	 */
	public static String toASCII(String str) throws UnsupportedEncodingException {
		return changeCharset(str, Charset.US_ASCII.getEncode());
	}

	/**
	 * 将字符编码转换成ISO-8859-1码
	 */
	public static String toISO_8859_1(String str) throws UnsupportedEncodingException {
		return changeCharset(str, Charset.ISO_8859_1.getEncode());
	}

	/**
	 * 将字符编码转换成UTF-8码
	 */
	public static String toUTF_8(String str) throws UnsupportedEncodingException {
		return changeCharset(str, Charset.UTF_8.getEncode());
	}

	/**
	 * 将字符编码转换成UTF-16BE码
	 */
	public static String toUTF_16BE(String str) throws UnsupportedEncodingException {
		return changeCharset(str, Charset.UTF_16BE.getEncode());
	}

	/**
	 * 将字符编码转换成UTF-16LE码
	 */
	public static String toUTF_16LE(String str) throws UnsupportedEncodingException {
		return changeCharset(str, Charset.UTF_16LE.getEncode());
	}

	/**
	 * 将字符编码转换成UTF-16码
	 */
	public static String toUTF_16(String str) throws UnsupportedEncodingException {
		return changeCharset(str, Charset.UTF_16.getEncode());
	}

	/**
	 * 将字符编码转换成GBK码
	 */
	public static String toGBK(String str) throws UnsupportedEncodingException {
		return changeCharset(str, Charset.GBK.getEncode());
	}

}