package databases;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.UserOfCoin;
import user.UserOfGolden;
import user.UserOfNavigate;
import user.UserOfPolicy;

public class Test1 {
	// mybatis的配置文件
	static String resource = "conf.xml";
	// 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
	static InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);

	// 构建sqlSession的工厂
	static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

	// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
	// Reader reader = Resources.getResourceAsReader(resource);
	// 构建sqlSession的工厂
	// SqlSessionFactory sessionFactory = new
	// SqlSessionFactoryBuilder().build(reader);
	// 创建能执行映射文件中sql的sqlSession
	static SqlSession session = sessionFactory.openSession();

	// public static void add(int news, int top_id, int bottom_id, int id, long
	// created_id, String imgurl1,
	// String thumbnail, String content) {
	// String statement = "mapping.userMapper.insertAuthor";// 映射sql的标识字符串
	//
	// // 执行查询返回一个唯一user对象的sql
	//
	// // UserRead user = session.insert(statement, upadd);
	//
	// }
	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(String s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	public static void main(String[] args) throws IOException {

		// System.out.println(stampToDate("1531619293000"));

		// System.out.println("1234567890");
		// System.out.println(selectUser("admin1"));
		// updateGolden("1", 5, 9);
		// selectGoldenAll();
		// allDeleteForGolden();
		// allDeleteForPolicy();
		// allDeleteForCoin();
		// selectGolden(1);
		// selectGoldenSub(6);
		// selectPolicyAll();

		// updateCoin("1", 5);
		// String ud[] = selectPolicyUD("2");
		// System.out.println(ud[0]);
		// System.out.println(ud[1]);

		// selectPolicy("2");
		// selectCoinSub(1);
		// selectUser("admin");
		// selectNavigationAll("1");

		// selectGoldenNum(0, 10);
		// updateUser("admin", "12345");
		// updateAdvertising("1", "2", "2");
		// System.out.println(selectGoldenAllNum());
		// selectGoldenAllNum();
		System.out.println(selectPolicyAllNum());
	}

	public static int selectGoldenAllNum() {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQLallDeleteForPolicy
		 */
		String statement = "mapping.userMapper.getGoldenAllNum";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int num = session.selectOne(statement);
		System.out.println(num);
		return num;

	}// findMax\

	public static int selectPolicyAllNum() {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQLallDeleteForPolicy
		 */
		String statement = "mapping.userMapper.getPolicyAllNum";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int num = session.selectOne(statement);
		System.out.println(num);
		return num;

	}// findMax

	public static void addToGolden(int news, int top_id, int bottom_id, int old_id, long created_id, String imgurl1,
			String thumbnail, String title, String content, String time) {// 添加数据
		String statement = "mapping.userMapper.insertGolden";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("news", news);
		map.put("top_id", top_id);
		map.put("bottom_id", bottom_id);
		map.put("old_id", old_id);
		map.put("created_id", created_id);
		map.put("imgurl1", imgurl1);
		map.put("thumbnail", thumbnail);
		map.put("title", title);
		map.put("content", content);
		map.put("time", time);
		session.insert(statement, map);
		session.commit();
		// User user = session.selectOne(statement, i);
	}

	public static void addToPolicy(int news, int top_id, int bottom_id, int title_id, String title, int type,
			String version, int topic_id, String summary, long published_at, String image_short, String image_big,
			String html_url, String text, String author, String source) {// 添加数据
		String statement = "mapping.userMapper.insertPolicy";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("news", news);
		map.put("top_id", top_id);
		map.put("bottom_id", bottom_id);
		map.put("title_id", title_id);
		map.put("title", title);
		map.put("type", type);
		map.put("version", version);
		map.put("topic_id", topic_id);
		map.put("summary", summary);
		map.put("published_at", published_at);
		map.put("image_short", image_short);
		map.put("image_big", image_big);
		map.put("html_url", html_url);
		map.put("text", text);
		map.put("author", author);
		map.put("source", source);
		session.insert(statement, map);
		session.commit();
		// User user = session.selectOne(statement, i);
	}

	public static void addToCoin(int news_id, String title, String img_url, String abstract_str, String source,
			String promulgator_title, String issue_time, int is_top, String logo_pic, String text) {// 添加数据
		String statement = "mapping.userMapper.insertCoin";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("news_id", news_id);
		map.put("title", title);
		map.put("img_url", img_url);
		map.put("abstract_str", abstract_str);
		map.put("source", source);
		map.put("promulgator_title", promulgator_title);
		map.put("issue_time", issue_time);
		map.put("is_top", is_top);
		map.put("logo_pic", logo_pic);
		map.put("text", text);
		session.insert(statement, map);
		session.commit();
		// User user = session.selectOne(statement, i);
	}

	public static void addToNavigetion(String type, String img_url, String title, String title_en, String gw_url,
			String content, String type_name) {// 添加数据
		String statement = "mapping.userMapper.insertNavigation";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("img_url", img_url);
		map.put("title", title);
		map.put("title_en", title_en);
		map.put("gw_url", gw_url);
		map.put("content", content);
		map.put("type_name", type_name);
		session.insert(statement, map);
		session.commit();
		// User user = session.selectOne(statement, i);
	}

	public static int findMaxFromGolden() {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.findMaxFromGolden";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		String user = session.selectOne(statement);
		// System.out.println(user);
		if (user == null) {
			user = "0";
		}
		int users = Integer.parseInt(user.trim());

		return users;

	}

	public static int findMaxFromPolicy() {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.findMaxFromPolicy";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		String user = session.selectOne(statement);
		// System.out.println(user);
		if (user == null) {
			user = "0";
		}
		int users = Integer.parseInt(user.trim());

		return users;

	}

	public static int findMaxFromCoin() {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.findMaxFromCoin";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		String user = session.selectOne(statement);
		// System.out.println(user);
		if (user == null) {
			user = "0";
		}
		int users = Integer.parseInt(user.trim());

		return users;

	}
	// ******************************************用户操作登陆

	public static String selectUser(String userName) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQLallDeleteForPolicy
		 */
		String statement = "mapping.userMapper.findUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		String password = session.selectOne(statement, userName);
		System.out.println(password);
		return password;

	}// findMax
		// ******************************************广告图片url

	public static String selectAdvertising(String id) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQLallDeleteForPolicy
		 */
		String statement = "mapping.userMapper.findAdvertising";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		String url = session.selectOne(statement, id);
		// System.out.println(user);
		return url;

	}// findMax
		// *********************************************************显示所有

	public static UserOfGolden selectGolden(String i) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQLallDeleteForPolicy
		 */
		String statement = "mapping.userMapper.getGoldenByUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		UserOfGolden user = session.selectOne(statement, i);
		// System.out.println(user);
		return user;

	}// findMax

	public static int updateGolden(String id, int up, int down) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.updateGolden";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("up", up);
		map.put("down", down);
		System.out.println(statement + "      " + map);
		int i = session.update(statement, map);
		session.commit();
		return i;

	}

	public static UserOfPolicy selectPolicy(String i) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getPolicyByUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		UserOfPolicy user = session.selectOne(statement, i);
		// System.out.println(user);
		return user;

	}

	public static int updatePolicy(String id, int look) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.updatePolicyLook";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("look", look);
		System.out.println(statement + "      " + map);
		int i = session.update(statement, map);
		session.commit();
		return i;

	}

	public static String[] selectPolicyUD(String inet) {// 显示所有getUserRankgetPolicyByUser
		String statement = "mapping.userMapper.getPolicyByUserall";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		List<user.UserOfPolicy> listPolicy = session.selectList(statement);

		int i = 0;
		String[] UD = new String[2];
		// System.out.println(listPolicy.size());
		Boolean flag = false;
		for (UserOfPolicy UserOfPolicy : listPolicy) {
			UD[1] = UserOfPolicy.getId() + "";
			if (flag) {
				break;
			}
			if (inet.equals(UserOfPolicy.getId() + "")) {
				// System.out.println(UserOfPolicy);
				i = listPolicy.indexOf(UserOfPolicy);
				flag = true;
			}
			if (!flag) {
				UD[0] = UserOfPolicy.getId() + "";
			}
		}
		// System.out.println(i);
		return UD;

	}

	public static UserOfCoin selectCoin(String i) {// 显示
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getCoinByUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		UserOfCoin user = session.selectOne(statement, i);
		// System.out.println(user);
		return user;

	}

	public static int updateCoin(String id, int look) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.updateCoinLook";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("look", look);
		System.out.println(statement + "      " + map);
		int i = session.update(statement, map);
		session.commit();
		return i;

	}

	public static int updateAdvertising(String id, String type, String url) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.updateAdvertising";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("image_url", url);
		map.put("type", type);
		System.out.println(statement + "      " + map);
		int i = session.update(statement, map);
		session.commit();
		return i;

	}

	public static int updateUser(String user, String password) {// 显示所有getUserRankgetPolicyByUser
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.updateUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		map.put("password", password);

		System.out.println(statement + "      " + map);
		int i = session.update(statement, map);
		session.commit();
		return i;

	}

	public static List<user.UserOfGolden> selectGoldenAll() {// 显示getGoldenByUserNum
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getGoldenByUserall";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		List<user.UserOfGolden> listGolden = session.selectList(statement);
		for (UserOfGolden userOfGolden : listGolden) {
			// System.out.println(userOfGolden);
		}
		// System.out.println(user);
		return listGolden;

	}

	public static List<user.UserOfGolden> selectGoldenNum(int up, int down) {// 显示getGoldenByUserNum
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getGoldenByUserNum";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("up", up);
		map.put("down", down);

		List<user.UserOfGolden> listGolden = session.selectList(statement, map);
		// for (UserOfGolden userOfGolden : listGolden) {
		// System.out.println(userOfGolden);
		// }
		// System.out.println(user);
		return listGolden;

	}

	public static List<user.UserOfPolicy> selectPolicyAll() {// 显示
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getPolicyByUserall";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		List<user.UserOfPolicy> listPolicy = session.selectList(statement);
		// System.out.println(listPolicy.size());
		for (UserOfPolicy UserOfPolicy : listPolicy) {
			// System.out.println(UserOfPolicy);
		}
		// System.out.println(user);
		return listPolicy;

	}

	public static List<user.UserOfPolicy> selectPolicyNum(int up, int down) {// 显示getGoldenByUserNum
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getPolicyByUserNum";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("up", up);
		map.put("down", down);

		List<user.UserOfPolicy> listPolicy = session.selectList(statement, map);
		// for (UserOfGolden userOfGolden : listGolden) {
		// System.out.println(userOfGolden);
		// }
		// System.out.println(user);
		return listPolicy;

	}

	public static List<user.UserOfGolden> selectGoldenSub(int i) {// 显示
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getGoldenByUserall";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		List<user.UserOfGolden> listGolden = session.selectList(statement);
		listGolden = listGolden.subList(0, i);
		for (UserOfGolden userOfGolden : listGolden) {
			// System.out.println(userOfGolden);
		}
		// System.out.println(user);
		return listGolden;

	}

	public static List<user.UserOfCoin> selectCoinSub(int i) {// 显示
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getCoinByUserall";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		List<user.UserOfCoin> listCoin = session.selectList(statement);

		// try {
		// listCoin = listCoin.subList(0, i);
		// } catch (NullPointerException e) {
		// // TODO Auto-generated catch block
		// listCoin = null;
		//
		// }

		// System.out.println(user);
		return listCoin;

	}

	public static List<user.UserOfNavigate> selectNavigationAll(String type) {// 显示
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getNavigationByUser";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		List<user.UserOfNavigate> listNavigate = session.selectList(statement, type);
		for (UserOfNavigate userOfNavigate : listNavigate) {
			System.out.println(userOfNavigate);
		}
		// System.out.println(user);
		return listNavigate;

	}

	public static String[] selectCoinUD(String inet) {// 显示所有getUserRankgetPolicyByUser
		String statement = "mapping.userMapper.getCoinByUserall";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql

		List<user.UserOfCoin> listCoin = session.selectList(statement);

		int i = 0;
		String[] UD = new String[2];
		// System.out.println(listPolicy.size());
		Boolean flag = false;
		for (UserOfCoin UserOfCoin : listCoin) {
			UD[1] = UserOfCoin.getId() + "";
			if (flag) {
				break;
			}
			if (inet.equals(UserOfCoin.getId() + "")) {
				// System.out.println(UserOfPolicy);
				i = listCoin.indexOf(UserOfCoin);
				flag = true;
			}
			if (!flag) {
				UD[0] = UserOfCoin.getId() + "";
			}
		}
		// System.out.println(i);
		return UD;

	}

	public static UserOfGolden selectGoldenRank(String rank) {// 显示所有getUserRank
		// 输入排序方式,DESC为降序,ASC为升序
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.getUserRank";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		UserOfGolden user = session.selectOne(statement, rank);
		// System.out.println(user);
		return user;

	}

	// *******************************************************删表且将主键重置
	public static int allDeleteForGolden() {// 全部删除且将主键重置
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.allDeleteForGolden";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int user = session.delete(statement);
		session.commit();
		System.out.println(user);
		return user;

	}

	public static int allDeleteForPolicy() {// 全部删除且将主键重置
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.allDeleteForPolicy";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int user = session.delete(statement);
		session.commit();
		System.out.println(user);
		return user;

	}

	public static int allDeleteForCoin() {// 全部删除且将主键重置
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.allDeleteForCoin";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int user = session.delete(statement);
		session.commit();
		System.out.println(user);
		return user;

	}

	// ****************************************************************选择删除
	public static int selectDeleteForGolden(int i) {// 输入行号,选择删除
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.deleteForGoldenById";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int user = session.delete(statement, i);
		session.commit();// 删除之后需要提交
		// System.out.println(user);
		return user;// 返回删除条数

	}

	public static int selectDeleteForPolicy(int i) {// 输入行号,选择删除
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.deleteForPolicyById";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int user = session.delete(statement, i);
		session.commit();// 删除之后需要提交
		// System.out.println(user);
		return user;// 返回删除条数

	}

	public static int selectDeleteForCoin(int i) {// 输入行号,选择删除
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "mapping.userMapper.deleteForCoinById";// 映射sql的标识字符串
		// 执行查询返回一个唯一user对象的sql
		int user = session.delete(statement, i);
		session.commit();// 删除之后需要提交
		// System.out.println(user);
		return user;// 返回删除条数

	}

}