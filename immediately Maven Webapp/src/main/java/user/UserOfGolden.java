package user;

public class UserOfGolden {

	private Integer new_id;
	private Integer news;// 获取的新闻条数
	private Integer top_id;// 最新的新闻id
	private Integer bottom_id;// 最旧的新闻id
	private long old_id;// 从json中取出的id
	private long created_id;// 文章时间
	private String imgurl1;// 第一张图片
	private String thumbnail;// 第二张图片
	private String title;
	private String content;// 文章内容
	private String time;// 请求时间
	private Integer up;
	private Integer down;

	public UserOfGolden(Integer new_id, Integer news, Integer top_id, Integer bottom_id, long old_id, long created_id,
			String imgurl1, String thumbnail, String title, String content, String time, Integer up, Integer down) {
		super();
		this.new_id = new_id;
		this.news = news;
		this.top_id = top_id;
		this.bottom_id = bottom_id;
		this.old_id = old_id;
		this.created_id = created_id;
		this.imgurl1 = imgurl1;
		this.thumbnail = thumbnail;
		this.title = title;
		this.content = content;
		this.time = time;
		this.up = up;
		this.down = down;
	}

	@Override
	public String toString() {
		return "UserOfGolden [new_id=" + new_id + ", news=" + news + ", top_id=" + top_id + ", bottom_id=" + bottom_id
				+ ", old_id=" + old_id + ", created_id=" + created_id + ", imgurl1=" + imgurl1 + ", thumbnail="
				+ thumbnail + ", title=" + title + ", content=" + content + ", time=" + time + ", up=" + up + ", down="
				+ down + "]";
	}

	public Integer getNew_id() {
		return new_id;
	}

	public void setNew_id(Integer new_id) {
		this.new_id = new_id;
	}

	public Integer getNews() {
		return news;
	}

	public void setNews(Integer news) {
		this.news = news;
	}

	public Integer getTop_id() {
		return top_id;
	}

	public void setTop_id(Integer top_id) {
		this.top_id = top_id;
	}

	public Integer getBottom_id() {
		return bottom_id;
	}

	public void setBottom_id(Integer bottom_id) {
		this.bottom_id = bottom_id;
	}

	public long getOld_id() {
		return old_id;
	}

	public void setOld_id(long old_id) {
		this.old_id = old_id;
	}

	public long getCreated_id() {
		return created_id;
	}

	public void setCreated_id(long created_id) {
		this.created_id = created_id;
	}

	public String getImgurl1() {
		return imgurl1;
	}

	public void setImgurl1(String imgurl1) {
		this.imgurl1 = imgurl1;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

}