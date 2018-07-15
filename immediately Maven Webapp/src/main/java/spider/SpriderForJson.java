package spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import databases.Test1;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SpriderForJson {
	// 获取金色财经的消息
	public static void main(String[] args) {

		// allInOneForjinse(20);
		// allInOneForPolicy();
		// allInOneForBishijie();
		// System.out.println(timeStamp2Date("1530845745", null));
		// allInOneForjinse(20);

		allInOneForBishijie(20);
		allInOneForPolicy(100);
		allInOneForjinse(200);

	}

	// public void test1() {
	// allInOne("https://api.jinse.com/v4/live/list?limit=22&reading=false");
	// }
	// 7*24快讯json
	static int num1 = 0;
	static int num2 = 0;
	static int num3 = 0;

	public static void allInOneForjinse(int amount) {// 无需多言,解析转码入库一套秒 就是强
														// 输入需要的条数
		System.out.println("开始更新快讯");
		int quicki = 1;
		// "https://api.jinse.com/v4/live/list?limit=100&reading=false"
		try {
			URL url = new URL("https://api.jinse.com/v4/live/list?limit=" + amount + "&reading=false");

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				// BufferedReader br = new BufferedReader(new
				// InputStreamReader(url.openStream()));
				StringBuffer sb = new StringBuffer();
				String st;
				while ((st = br.readLine()) != null) {
					sb.append(st);
				}
				int old_id_data = Test1.findMaxFromGolden();
				// System.out.println(sb.toString());
				JSONObject first = JSONObject.fromObject(sb.toString());
				// System.out.println("============json解析第一层============");
				// System.out.println("news:" + first.getString("news"));
				int newsnum = first.getInt("news");

				// System.out.println("count:" + first.getString("count"));
				// System.out.println("top_id:" + first.getString("top_id"));
				int top_idnum = first.getInt("top_id");

				// System.out.println("bottom_id:" +
				// first.getString("bottom_id"));
				int bottom_idnum = first.getInt("bottom_id");

				// JSONArray解析数组，如果不是数组就直接用JSONObject就可以了
				JSONArray result = JSONArray.fromObject(first.getString("list"));
				// System.out.println("============json解析第二层============");
				for (int i = 0; i < result.size(); i++) {
					JSONObject second = result.getJSONObject(i);
					// System.out.println("需要解析的:" + second);
					// System.out.println("时间\t" + second.getString("date"));
					String time = second.getString("date");

					// System.out.println("============json解析第三层===========");
					JSONArray future = JSONArray.fromObject(second.get("lives"));
					for (int j = 0; j < future.size(); j++) {
						JSONObject thirdly = future.getJSONObject(j);
						// System.out.println("===========快讯新闻============");
						// System.out.println("id:" + thirdly.get("id"));
						int idnum = thirdly.getInt("id");
						// System.out.println("内容:" + thirdly.get("content"));
						String content = thirdly.getString("content");
						// System.out.println(content.indexOf("】"));
						// System.out.println("时间:" +
						// thirdly.get("created_at"));
						Long created_at = thirdly.getLong("created_at");
						// System.out.println("第一张图片:" + thirdly.get("url"));
						// System.out.println("第二张图片:" +
						// thirdly.get("thumbnail"));
						String title = null;
						if (content.indexOf("】") == -1) {

							// System.out.println(title);
						} else {
							title = content.substring(1, content.indexOf("】"));
							// System.out.println(title);
							content = content.substring(content.indexOf("】") + 1, content.length());

						}

						if (old_id_data >= idnum) {
							num1 += 1;
						} else {

							System.out.println("快讯更新:第" + quicki++ + "条");
							Test1.addToGolden(newsnum, top_idnum, bottom_idnum, idnum, created_at,
									(String) thirdly.get("url"), (String) thirdly.get("thumbnail"), title, content,
									time);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("快讯更新时发现:" + num1 + "条重复消息");
		num1 = 0;
	}

	// ************************************************************************金色财经的政策面板json文件
	public static void allInOneForPolicy(int amount) {// 无需多言,解析转码一套秒 就是强
		// 输入需要的条数
		System.out.println("开始更新政策");
		int policyi = 1;
		// "https://api.jinse.com/v4/live/list?limit=100&reading=false"

		// https://api.jinse.com/v6/information/list?catelogue_key=zhengce&limit=23&information_id=24238&flag=down&version=9.9.9

		// https://api.jinse.com/v6/information/list?catelogue_key=zhengce&limit=23&information_id=0&flag=down&version=9.9.9//金色财经的政策栏目初始请求,最新
		try {
			URL url = new URL("https://api.jinse.com/v6/information/list?catelogue_key=zhengce&limit=" + amount
					+ "&information_id=0&flag=down&version=9.9.9");

			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				// BufferedReader br = new BufferedReader(new
				// InputStreamReader(url.openStream()));
				StringBuffer sb = new StringBuffer();
				String st;
				while ((st = br.readLine()) != null) {
					sb.append(st);
				}
				int old_id_data = Test1.findMaxFromPolicy();
				// System.out.println(sb.toString());
				JSONObject first = JSONObject.fromObject(sb.toString());
				// System.out.println("============json解析第一层============");
				// System.out.println("news:" + first.getString("news"));
				int newsnum = first.getInt("news");

				// System.out.println("count:" + first.getString("count"));
				// System.out.println("top_id:" + first.getString("top_id"));
				int top_idnum = first.getInt("top_id");

				// System.out.println("bottom_id:" +
				// first.getString("bottom_id"));
				int bottom_idnum = first.getInt("bottom_id");

				// JSONArray解析数组，如果不是数组就直接用JSONObject就可以了
				JSONArray result = JSONArray.fromObject(first.getString("list"));

				for (int i = 0; i < result.size(); i++) {
					// System.out.println("============json解析第二层============");
					JSONObject second = result.getJSONObject(i);
					// System.out.println("需要解析的:" + second);
					// System.out.println("id\t" + second.getString("id"));//
					// 标题id
					int title_id = second.getInt("id");
					// System.out.println("title\t" +
					// second.getString("title"));
					String title = second.getString("title");
					// System.out.println("type\t" + second.getString("type"));
					int type = second.getInt("type");
					JSONArray future = JSONArray.fromObject(second.get("extra"));
					for (int j = 0; j < future.size(); j++) {
						// System.out.println("============json解析第三层===========");
						// if (future.size() != 1) {
						// System.out.println(
						// "***********************************************************************************************************************************");
						// }
						JSONObject thirdly = future.getJSONObject(j);
						// System.out.println("===========政策新闻============");
						// System.out.println("version:" +
						// thirdly.getString("version"));
						String version = thirdly.getString("version");
						// int idnum = thirdly.getInt("id");
						// System.out.println("topic_id:" +
						// thirdly.getString("topic_id"));// 内容id
						int topic_id = thirdly.getInt("topic_id");
						// String content = thirdly.getString("content");
						// System.out.println("summary:" +
						// thirdly.getString("summary"));// 内容
						String summary = thirdly.getString("summary");
						// Long created_at = thirdly.getLong("created_at");
						// System.out.println("published_at:" +
						// thirdly.getString("published_at"));// 时间
						long published_at = thirdly.getLong("published_at");
						// System.out.println("thumbnail_pic:" +
						// thirdly.getString("thumbnail_pic"));// 小图地址author
						String image_short = thirdly.getString("thumbnail_pic");

						String author = thirdly.getString("author");

						String source = thirdly.getString("source");
						// System.out.println("thumbnails_pics:" +
						// thirdly.getString("thumbnails_pics"));// 大图地址
						String image_big = thirdly.getString("thumbnails_pics");
						image_big.indexOf("[\"");
						image_big.indexOf("\"]");
						String image_big_test = image_big.substring(image_big.indexOf("[\"") + 2,
								image_big.indexOf("\"]"));
						// System.out.println(image_big_test + " " +
						// image_big.indexOf("[\"") + " "
						// + image_big.indexOf("\"]"));
						// System.out.println("topic_url:" +
						// thirdly.getString("topic_url"));// 内容地址
						String html_url = thirdly.getString("topic_url");// .trim();

						if (old_id_data >= topic_id) {
							num2 += 1;
						} else {
							String text = SpiderForHTML.ReadP(html_url);
							// System.out.println("text:" + text);
							// int text_num =
							// text.indexOf("您投送的稿件违反了金色财经的投稿协议");
							// System.out.println(text_num);
							// text = text.subSequence(0, text_num).toString();
							// System.out.println(text);

							System.out.println("政策更新:第" + policyi++ + "条");
							Test1.addToPolicy(newsnum, top_idnum, bottom_idnum, title_id, title, type, version,
									topic_id, summary, published_at, image_short, image_big_test, html_url, text,
									author, source);
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("政策更新时发现:" + num2 + "条重复消息");
		num2 = 0;
	}

	// ************************************************************************币世界深度json文件
	public static void allInOneForBishijie(int amount) {// 无需多言,解析转码一套秒 就是强
		System.out.println("开始更新币世界");
		int coinyi = 1;
		try {
			URL url = new URL("http://www.bishijie.com/api/Information/index?page=1&size=" + amount);

			try {

				BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
				StringBuffer sb = new StringBuffer();
				String st;
				while ((st = br.readLine()) != null) {
					sb.append(st);
				}
				int old_id_data = Test1.findMaxFromCoin();
				// System.out.println(sb.toString());
				JSONObject first = JSONObject.fromObject(sb.toString());

				// System.out.println("============json解析第一层============");
				// System.out.println("error:" + first.getString("error"));

				JSONObject result = JSONObject.fromObject(first.getString("data"));
				// for (int i = 0; i < result.size(); i++) {
				// System.out.println("============json解析第二层============" +
				// result.size());
				JSONArray future = JSONArray.fromObject(result.get("data"));
				for (int j = 0; j < future.size(); j++) {
					// System.out.println("============json解析第三层===========");
					JSONObject thirdly = future.getJSONObject(j);
					// System.out.println("===========深度新闻============");
					// System.out.println("需要解析的:" + thirdly);
					// System.out.println("news_id\t" +
					// thirdly.getString("news_id"));// 标题id
					int news_id = thirdly.getInt("news_id");
					// System.out.println("title\t" +
					// thirdly.getString("title"));
					String title = thirdly.getString("title");
					// System.out.println("img_url\t" +
					// thirdly.getString("img_url"));
					String img_url = thirdly.getString("img_url");
					// System.out.println("abstract\t" +
					// thirdly.getString("abstract"));
					String abstract_str = thirdly.getString("abstract");
					// System.out.println("source\t" +
					// thirdly.getString("source"));
					String source = thirdly.getString("source");
					// System.out.println("promulgator_title\t" +
					// thirdly.getString("promulgator_title"));
					String promulgator_title = thirdly.getString("promulgator_title");
					// System.out.println("issue_time:" +
					// thirdly.getString("issue_time"));
					String issue_time = thirdly.getString("issue_time");
					// int idnum = thirdly.getInt("id");
					// System.out.println("is_top:" +
					// thirdly.getString("is_top"));// 内容id
					int is_top = thirdly.getInt("is_top");
					// System.out.println(is_top);
					// String content = thirdly.getString("content");
					// System.out.println("logo_pic:" +
					// thirdly.getString("logo_pic"));// 内容
					String logo_pic = thirdly.getString("logo_pic");

					if (old_id_data >= news_id) {
						num3 += 1;
					} else {
						String text = SpiderForHTML.ReadConntent(news_id);
						// System.out.println(text);

						System.out.println("币世界更新:第" + coinyi++ + "条");
						Test1.addToCoin(news_id, title, img_url, abstract_str, source, promulgator_title, issue_time,
								is_top, logo_pic, text);

					}
				}
				// }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("币世界更新时发现:" + num3 + "条重复消息");
		num3 = 0;
	}

	// 币世界的链接 http://www.bishijie.com/api/Information/index?page=1&size=50
	public static String quicktoJson(int id) {
		// TODO Auto-generated method stub
		// 创建客户端
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet;
		if (id == 0) {
			httpGet = new HttpGet("http://www.bishijie.com/shendu_3130");
		} else {
			httpGet = new HttpGet("http://www.bishijie.com/shendu_" + id);
		}
		// 设置头部信息进行模拟登录（添加登录后的Cookie）
		httpGet.setHeader("Accept", "text/html,application/xhtml+xml," + "application/xml;q=0.9,image/webp,*/*;q=0.8");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64)AppleWebKit/537.36"
				+ " (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();//
		// 设置请求和传输超时时间
		httpGet.setConfig(requestConfig);
		String resdate = null;
		try {
			HttpResponse res = httpClient.execute(httpGet);
			resdate = EntityUtils.toString(res.getEntity(), "UTF-8");
			System.out.println(resdate);
			// System.out.println();
			// httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 执行请求
		return resdate;

	}

	public static String httpGet(String url) {

		// TODO Auto-generated method stub
		// 创建客户端
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet;
		if (url == null) {
			httpGet = new HttpGet("https://api.jinse.com/v4/live/list?limit=22&reading=false");
		} else {
			httpGet = new HttpGet(url);
		}
		// HttpGet httpGet = new
		// HttpGet("https://api.jinse.com/v4/live/list?limit=22&reading=false");
		// 设置头部信息进行模拟登录（添加登录后的Cookie）
		httpGet.setHeader("Accept", "text/html,application/xhtml+xml," + "application/xml;q=0.9,image/webp,*/*;q=0.8");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch, br");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64)AppleWebKit/537.36"
				+ " (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();//
		// 设置请求和传输超时时间
		httpGet.setConfig(requestConfig);
		String resdate = null;
		try {
			HttpResponse res = httpClient.execute(httpGet);
			resdate = EntityUtils.toString(res.getEntity(), "UTF-8");
			System.out.println(resdate);
			// System.out.println();
			// httpClient.execute(httpGet);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 执行请求
		return resdate;

	}

	/**
	 * 时间戳转换成日期格式字符串
	 * 
	 * @param seconds
	 *            精确到秒的字符串
	 * @param formatStr
	 * @return
	 */
	public static String timeStamp2Date(String seconds, String format) {
		if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
			return "";
		}
		if (format == null || format.isEmpty())
			format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds + "000")));
	}

	// // 解析json数据
	// public static int parseJson(String str) {
	// // JSONObject jObj = JSONObject.fromObject(str);
	// JSONObject jObj = JSONObject.fromObject(str);
	// System.out.println("test1");
	// Object obj = jObj.getJSONObject("list");
	// System.out.println("test2");
	// String s2 = obj.toString();
	//
	// System.out.println(s2);
	// Gson gson = new Gson();
	// Map map = gson.fromJson(s2, Map.class);
	// Number num = (Number) map.get("date");
	// return num.intValue();
	// }
}
