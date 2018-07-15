package spider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import databases.Test1;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class test {
	public static void main(String[] args) {
		// ReadP("http://168.io/wap/waphtml/index.html");
		// httpGet("http://168.io/wap/waphtml/more-list.html?n=announcement&c=92307dc5e8a64e4dab033828f2fbefe9");
		System.out.println(ReadFile("C:\\Users\\飞云川\\Desktop\\123.json"));
		Read();
	}

	static void Read() {

		try {

			JSONObject first = JSONObject.fromObject(ReadFile("C:\\Users\\飞云川\\Desktop\\123.json").toString().trim());

			System.out.println("============json解析第一层============");
			System.out.println("code:" + first.getString("code"));
			System.out.println("message:" + first.getString("message"));

			JSONObject result = JSONObject.fromObject(first.getString("result"));
			System.out.println("============json解析第二层============" + result.size());

			System.out.println("totalResult:" + result.getString("totalResult"));

			JSONArray future = JSONArray.fromObject(result.get("result"));
			for (int j = 0; j < future.size(); j++) {
				System.out.println("============json解析第三层===========");
				JSONObject thirdly = future.getJSONObject(j);
				String img_url = null;
				// System.out.println("img_url:" +
				// thirdly.getString("img_url"));
				// img_url = "http://file.168io.cn/" +
				// thirdly.getString("img_url");

				System.out.println("title:" + thirdly.getString("title"));
				String title = thirdly.getString("title");
				String name = thirdly.getString("name");
				// System.out.println("title_en:" +
				// thirdly.getString("title_en"));
				// String title_en = thirdly.getString("title_en");
				System.out.println("gw_url:" + thirdly.getString("advertising_picture_url"));
				String gw_url = thirdly.getString("advertising_picture_url");
				// System.out.println("content:" +
				// thirdly.getString("content"));
				// String content = thirdly.getString("content");
				Test1.addToNavigetion("14", img_url, title, null, gw_url, null, name);

				// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~备份~~~~~~~~~~~~~~~~~~~~~~~
				// System.out.println("============json解析第三层===========");
				// JSONObject thirdly = future.getJSONObject(j);
				// System.out.println("img_url:" +
				// thirdly.getString("img_url"));
				// String img_url = "http://file.168io.cn/" +
				// thirdly.getString("img_url");
				// System.out.println("title:" + thirdly.getString("title"));
				// String title = thirdly.getString("title");
				// System.out.println("title_en:" +
				// thirdly.getString("title_en"));
				// String title_en = thirdly.getString("title_en");
				// System.out.println("gw_url:" + thirdly.getString("gw_url"));
				// String gw_url = thirdly.getString("gw_url");
				// System.out.println("content:" +
				// thirdly.getString("content"));
				// String content = thirdly.getString("content");
				// Test1.addToNavigetion("1", img_url, title, title_en, gw_url,
				// content);

				// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~备份~~~~~~~~~~~~~~~~~~~~~~~
			}
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 通过本地文件访问json并读取
	 * 
	 * @param path：E:/svn/05.Hospital/templatedept_uuid.json
	 * @return：json文件的内容
	 */
	public static String ReadFile(String path) {
		String laststr = "";
		File file = new File(path);// 打开文件
		BufferedReader reader = null;
		try {
			FileInputStream in = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(in, "unicode"));// 读取文件
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr = laststr + tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException el) {
				}
			}
		}
		return laststr;
	}
}
