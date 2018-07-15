package user;

public class UserOfPolicy {
	private int id;// 主键
	private int news;
	private int top_id;
	private int bottom_id;
	private int title_id;
	private String title;
	private int type;
	private String version;
	private int topic_id;
	private String summary;
	private long published_at;
	private String image_short;
	private String image_big;
	private String html_url;
	private String text;
	private int look;
	private String author;
	private String source;

	public UserOfPolicy(int id, int news, int top_id, int bottom_id, int title_id, String title, int type,
			String version, int topic_id, String summary, long published_at, String image_short, String image_big,
			String html_url, String text, int look, String author, String source) {
		super();
		this.id = id;
		this.news = news;
		this.top_id = top_id;
		this.bottom_id = bottom_id;
		this.title_id = title_id;
		this.title = title;
		this.type = type;
		this.version = version;
		this.topic_id = topic_id;
		this.summary = summary;
		this.published_at = published_at;
		this.image_short = image_short;
		this.image_big = image_big;
		this.html_url = html_url;
		this.text = text;
		this.look = look;
		this.author = author;
		this.source = source;
	}

	@Override
	public String toString() {
		return "UserOfPolicy [id=" + id + ", news=" + news + ", top_id=" + top_id + ", bottom_id=" + bottom_id
				+ ", title_id=" + title_id + ", title=" + title + ", type=" + type + ", version=" + version
				+ ", topic_id=" + topic_id + ", summary=" + summary + ", published_at=" + published_at
				+ ", image_short=" + image_short + ", image_big=" + image_big + ", html_url=" + html_url + ", text="
				+ text + ", look=" + look + ", author=" + author + ", source=" + source + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNews() {
		return news;
	}

	public void setNews(int news) {
		this.news = news;
	}

	public int getTop_id() {
		return top_id;
	}

	public void setTop_id(int top_id) {
		this.top_id = top_id;
	}

	public int getBottom_id() {
		return bottom_id;
	}

	public void setBottom_id(int bottom_id) {
		this.bottom_id = bottom_id;
	}

	public int getTitle_id() {
		return title_id;
	}

	public void setTitle_id(int title_id) {
		this.title_id = title_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public long getPublished_at() {
		return published_at;
	}

	public void setPublished_at(long published_at) {
		this.published_at = published_at;
	}

	public String getImage_short() {
		return image_short;
	}

	public void setImage_short(String image_short) {
		this.image_short = image_short;
	}

	public String getImage_big() {
		return image_big;
	}

	public void setImage_big(String image_big) {
		this.image_big = image_big;
	}

	public String getHtml_url() {
		return html_url;
	}

	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getLook() {
		return look;
	}

	public void setLook(int look) {
		this.look = look;
	}

}
