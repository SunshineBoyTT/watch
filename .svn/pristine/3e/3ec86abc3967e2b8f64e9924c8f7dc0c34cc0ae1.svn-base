package com.spring.common.service.core;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NetTool {

	private static Charset charset = Charset.forName("UTF-8");
	private final static String driver = "com.mysql.jdbc.Driver";
	private static String databaseName = "mysql";
	private static String ip = "127.0.0.1";
	private static String name = "your name";
	private static String pwd = "your password";
	private final static int minConnectionPool = 100;
	private final static int maxConnectionPool = 1000;
	private final static int minThreadPool = 100;
	private final static int maxThreadPool = 1000;
	private final static int keepAliveTime = 60000;
	private final static String[] disk = { "E:\\", "D:\\", "C:\\" };
	private final static String directory = "Net";
	private static String configPath = null;
	private static String logPath = null;
	private static String listPath = null;
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 鑾峰彇鏈湴鏂囦欢浠ュ瓧鑺傛暟缁勫舰寮忚繑鍥�
	 * 
	 * @param value
	 *            銆�鏂囦欢鍚�
	 * @return銆�鏂囦欢鐨刡yte鏁扮粍
	 */
	public static byte[] getFileByte(String value) {
		// 鑾峰彇鏂囦欢鑺傝妭鏁扮粍
		byte[] data;
		File file = new File(value);
		long length = file.length();
		data = new byte[(int) length];
		try {
			BufferedInputStream bufferedinputstream = new BufferedInputStream(
					new FileInputStream(file));
			bufferedinputstream.read(data);
			bufferedinputstream.close();
			bufferedinputstream = null;
			file = null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 鑾峰彇缃戠粶鏂囦欢浠ュ瓧鑺傛暟缁勫舰寮忚繑鍥�
	 * 
	 * @param value
	 *            銆�缃戠粶URL鍦板潃
	 * @return銆�鏂囦欢鐨刡yte鏁扮粍
	 */
	public static byte[] getURLFileByte(String value) {
		byte[] data = null;
		try {
			URL url = new URL(value);
			InputStream is = url.openConnection().getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int ch;
			byte buffer[] = new byte[512];
			while ((ch = is.read(buffer)) != -1) {
				bos.write(buffer, 0, ch);
			}
			bos.flush();
			data = bos.toByteArray();
			bos.close();
			is.close();
			is = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * 鍔犺浇XML鏂囦欢
	 * 
	 * @param name
	 *            銆�鏂囦欢鍚�
	 * @param tag
	 *            銆� 鏍囩
	 */
	public static Element LoadXml(String name, String tag) {
		DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory
				.newInstance();
		try {
			DocumentBuilder documentbuilder = documentbuilderfactory
					.newDocumentBuilder();
			if (configPath == null)
				CreateNewConfigXML();// 鍒涘缓閰嶇疆鏂囦欢
			if (configPath != null) {
				// 鍙栨秷杈撳叆
				Document document = documentbuilder.parse(new File(configPath));
				document.normalize();
				Element element = document.getDocumentElement();
				NodeList nodelist = element.getElementsByTagName(tag);
				element = (Element) nodelist.item(0);
				documentbuilderfactory = null;
				documentbuilder = null;
				document = null;
				return element;
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 鑾峰彇閰嶇疆鍐呭
	 * 
	 * @param element
	 *            銆�element瀵硅薄
	 * @param tag
	 *            銆� 瀵瑰簲鐨勬爣绛�
	 */
	public static String getXmlProperty(Element element, String tag) {
		return element.getElementsByTagName(tag).item(0).getFirstChild()
				.getNodeValue();
	}

	public static String decode(ByteBuffer bytebuffer) {
		CharBuffer charbuffer = charset.decode(bytebuffer);
		return charbuffer.toString();
	}

	public static byte[] getBytes(char[] chars) {
		CharBuffer cb = CharBuffer.allocate(chars.length);
		cb.put(chars);
		cb.flip();
		ByteBuffer bb = charset.encode(cb);
		return bb.array();
	}

	public static char[] getChars(byte[] bytes) {
		ByteBuffer bb = ByteBuffer.allocate(bytes.length);
		bb.put(bytes);
		bb.flip();
		CharBuffer cb = charset.decode(bb);
		return cb.array();
	}

	private static boolean inputInfo() {
		ip = javax.swing.JOptionPane.showInputDialog(null, "璇疯緭鍏ユ暟鎹簱杩炴帴IP鍦板潃", "");
		if (ip == null) {
			javax.swing.JOptionPane.showMessageDialog(null, "鍙栨秷閫�鍑�");
			return false;
		}
		databaseName = javax.swing.JOptionPane.showInputDialog(null,
				"璇疯緭鍏ヨ繛鎺ョ殑鏁版嵁搴撳悕", "");
		if (databaseName == null) {
			javax.swing.JOptionPane.showMessageDialog(null, "鍙栨秷閫�鍑�");
			return false;
		}
		name = javax.swing.JOptionPane.showInputDialog(null, "璇疯緭鍏ユ暟鎹簱鐢ㄦ埛鍚�", "");
		if (name == null) {
			javax.swing.JOptionPane.showMessageDialog(null, "鍙栨秷閫�鍑�");
			return false;
		}
		pwd = javax.swing.JOptionPane.showInputDialog(null, "璇疯緭鍏ユ暟鎹簱鐢ㄦ埛瀵嗙爜", "");
		if (pwd == null) {
			javax.swing.JOptionPane.showMessageDialog(null, "鍙栨秷閫�鍑�");
			return false;
		}
		return true;
	}

	private static void CreateNewConfigXML() {
		Font font = new Font("瀹嬩紤", Font.PLAIN, 12);
		UIManager.put("Label.font", font);
		UIManager.put("Button.font", font);
		try {
			File file = new File(disk[0]);
			for (int i = 0; i < disk.length;) {
				if (!file.exists()) {
					// 濡傛灉涓嶅瓨鍦ㄨ椹卞姩鍣ㄥ氨璺冲埌涓嬩釜椹卞姩鍣�
					System.out.println("Disk   " + disk[i] + "  Not Exist");
					file = new File(disk[++i]);
				} else {
					// 濡傛灉瀛樺湪璇ラ┍鍔ㄥ櫒灏卞垱寤虹洰褰曚互鍙婃枃浠�
					file = new File(disk[i] + directory);
					if (!file.exists()) {
						if (!inputInfo())
							return;
						// 涓嶅瓨鍦ㄥ垱寤虹洰褰�
						file.mkdir();
						final String fileName = "config.xml";
						file = new File(disk[i] + directory + "\\" + fileName);
						System.out.println("file is creating...");
						FileOutputStream fos = new FileOutputStream(file);
						fos.write(getConfig().getBytes());
						fos.flush();
						fos.close();
						configPath = disk[i] + directory + "\\" + fileName;
						javax.swing.JOptionPane.showMessageDialog(null,
								"鎭枩鎮紝閰嶇疆鏂囦欢鎴愬姛鐢熸垚锛乗r\n璺緞锛�" + configPath);
						System.out.println("create success ...");
						System.out
								.println("config file position:" + configPath);
						break;
					} else {
						// 瀛樺湪璇ョ洰褰曟娴嬮厤缃枃浠舵槸鍚﹀瓨鍦�
						final String fileName = "config.xml";
						file = new File(disk[i] + directory + "\\" + fileName);
						if (!file.exists()) {
							if (!inputInfo())
								return;
							System.out.println("file is creating...");
							FileOutputStream fos = new FileOutputStream(file);
							fos.write(getConfig().getBytes());
							fos.flush();
							fos.close();
							configPath = disk[i] + directory + "\\" + fileName;
							javax.swing.JOptionPane.showMessageDialog(null,
									"鎭枩鎮紝閰嶇疆鏂囦欢鎴愬姛鐢熸垚锛乗r\n璺緞锛�" + configPath);
							System.out.println("file create success ...");
							System.out.println("config file position:"
									+ configPath);
							break;
						} else {
							// 瀛樺湪璇ユ枃浠惰繑鍥炶鏂囦欢璺緞
							configPath = disk[i] + directory + "\\" + fileName;
							break;
						}
					}
				}
			}
			StringBuffer buffer = new StringBuffer();
			buffer.append(configPath.substring(0, configPath.lastIndexOf("\\")));
			buffer.append("\\");
			buffer.append("run.log");
			logPath = buffer.toString();
			buffer = new StringBuffer();
			buffer.append(configPath.substring(0, configPath.lastIndexOf("\\")));
			buffer.append("\\");
			buffer.append("blacklist.txt");
			listPath = buffer.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("file create failed ...");
			e.printStackTrace();
		}
	}

	private static String getConfig() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("jdbc:mysql://");
		buffer.append(ip);
		buffer.append(":3306/");
		buffer.append(databaseName);
		String newUrl = buffer.toString();
		StringBuffer xmlBuffer = new StringBuffer();
		xmlBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
		xmlBuffer.append("<Server>\r\n");
		xmlBuffer.append("<MYSQL>\r\n");
		xmlBuffer.append("<driver>");
		xmlBuffer.append(driver);
		xmlBuffer.append("</driver>\r\n");
		xmlBuffer.append("<url>");
		xmlBuffer.append(newUrl);
		xmlBuffer.append("</url>\r\n");
		xmlBuffer.append("<name>");
		xmlBuffer.append(name);
		xmlBuffer.append("</name>\r\n");
		xmlBuffer.append("<pwd>");
		xmlBuffer.append(pwd);
		xmlBuffer.append("</pwd>\r\n");
		xmlBuffer.append("<minConnectionPool>");
		xmlBuffer.append(minConnectionPool);
		xmlBuffer.append("</minConnectionPool>\r\n");
		xmlBuffer.append("<maxConnectionPool>");
		xmlBuffer.append(maxConnectionPool);
		xmlBuffer.append("</maxConnectionPool>\r\n");
		xmlBuffer.append("<acquireIncrement>");
		xmlBuffer.append(1);
		xmlBuffer.append("</acquireIncrement>\r\n");
		xmlBuffer.append("<maxIdleTime>");
		xmlBuffer.append(600000);
		xmlBuffer.append("</maxIdleTime>\r\n");
		xmlBuffer.append("<maxStatementsAndPerConnection>");
		xmlBuffer.append(0);
		xmlBuffer.append("</maxStatementsAndPerConnection>\r\n");
		xmlBuffer.append("<helpThread>");
		xmlBuffer.append(500);
		xmlBuffer.append("</helpThread>\r\n");
		xmlBuffer.append("</MYSQL>\r\n");
		xmlBuffer.append("<ThreadPool>\r\n");
		xmlBuffer.append("<minThreadPool>");
		xmlBuffer.append(minThreadPool);
		xmlBuffer.append("</minThreadPool>\r\n");
		xmlBuffer.append("<maxThreadPool>");
		xmlBuffer.append(maxThreadPool);
		xmlBuffer.append("</maxThreadPool>\r\n");
		xmlBuffer.append("<keepAliveTime>");
		xmlBuffer.append(keepAliveTime);
		xmlBuffer.append("</keepAliveTime>\r\n");
		xmlBuffer.append("</ThreadPool>\r\n");
		xmlBuffer.append("</Server>");
		return xmlBuffer.toString();
	}

	public static void onlineLog(String text) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("鐢ㄦ埛:");
		buffer.append(text);
		buffer.append("涓婄嚎!\r\n");
		writeLog(buffer.toString(), logPath);
	}

	public static void offlineLog(String text) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("鐢ㄦ埛:");
		buffer.append(text);
		buffer.append("绂荤嚎!\r\n");
		writeLog(buffer.toString(), logPath);
	}

	public static void removeUserLog(String ip) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("鐢ㄦ埛:");
		buffer.append(ip);
		buffer.append("浠庢湇鍔″櫒涓Щ闄�!\r\n");
		writeLog(buffer.toString(), logPath);
	}

	public static void writeBlackList(String ip) {
		writeLog(ip, listPath);
	}

	public static List<String> readBlackList() throws IOException {
		File file = null;
		List<String> list = new ArrayList<String>();
		file = new File(listPath);
		if (!file.exists())
			file.createNewFile();
		FileReader in = new FileReader(file);
		BufferedReader reader = new BufferedReader(in);
		String line = reader.readLine();
		while (line != null) {
			list.add(line);
			line = reader.readLine();
		}
		return list;
	}

	public static void writeLog(String text, String path) {
		try {
			File file = null;
			file = new File(path);
			if (!file.exists())
				file.createNewFile();
			StringBuffer buffer = new StringBuffer();
			buffer.append("[");
			buffer.append(sdf.format(new Date()));
			buffer.append("]");
			buffer.append("\r\t");
			buffer.append(text);
			FileWriter out = new FileWriter(file, true);
			BufferedWriter writer = new BufferedWriter(out);
			writer.write(buffer.toString());
			writer.close();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(getConfig());
	}
}
