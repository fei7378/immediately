package user;

public class UserOfCoin {

	private Integer id;
	private Integer news_id;
	private String title;
	private String img_url;
	private String abstract_str;
	private String source;
	private String promulgator_title;
	private String issue_time;
	private int is_top;
	private String logo_pic;
	private String text;
	private Integer up;
	private Integer down;
	private Integer look;

	public UserOfCoin(Integer id, Integer news_id, String title, String img_url, String abstract_str, String source,
			String promulgator_title, String issue_time, int is_top, String logo_pic, String text, Integer up,
			Integer down, Integer look) {
		super();
		this.id = id;
		this.news_id = news_id;
		this.title = title;
		this.img_url = img_url;
		this.abstract_str = abstract_str;
		this.source = source;
		this.promulgator_title = promulgator_title;
		this.issue_time = issue_time;
		this.is_top = is_top;
		this.logo_pic = logo_pic;
		this.text = text;
		this.up = up;
		this.down = down;
		this.look = look;
	}

	@Override
	public String toString() {
		return "UserOfCoin [id=" + id + ", news_id=" + news_id + ", title=" + title + ", img_url=" + img_url
				+ ", abstract_str=" + abstract_str + ", source=" + source + ", promulgator_title=" + promulgator_title
				+ ", issue_time=" + issue_time + ", is_top=" + is_top + ", logo_pic=" + logo_pic + ", text=" + text
				+ ", up=" + up + ", down=" + down + ", look=" + look + "]";
	}

	public Integer getUp() {
		return up;
	}

	public void setUp(Integer up) {
		this.up = up;
	}

	public Integer getDown() {
		return down;
	}

	public void setDown(Integer down) {
		this.down = down;
	}

	public Integer getLook() {
		return look;
	}

	public void setLook(Integer look) {
		this.look = look;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNews_id() {
		return news_id;
	}

	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getAbstract_str() {
		return abstract_str;
	}

	public void setAbstract_str(String abstract_str) {
		this.abstract_str = abstract_str;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getPromulgator_title() {
		return promulgator_title;
	}

	public void setPromulgator_title(String promulgator_title) {
		this.promulgator_title = promulgator_title;
	}

	public String getIssue_time() {
		return issue_time;
	}

	public void setIssue_time(String issue_time) {
		this.issue_time = issue_time;
	}

	public int getIs_top() {
		return is_top;
	}

	public void setIs_top(int is_top) {
		this.is_top = is_top;
	}

	public String getLogo_pic() {
		return logo_pic;
	}

	public void setLogo_pic(String logo_pic) {
		this.logo_pic = logo_pic;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}