package spider;

public class user {

	private int news;// 获取的新闻条数

	private int top_id;// 最新的新闻id
	private int bottom_id;// 最旧的新闻id
	private int id;// 从json中取出的id
	private long created_id;// 文章时间
	private String imgurl1;// 第一张图片
	private String thumbnail;// 第二张图片
	// private int up_counts;//看好值
	// private int down_counts;//看空值

	private String content;// 文章内容

	public user(int news, int top_id, int bottom_id, int id, long created_id, String imgurl1, String thumbnail,
			String content) {
		super();
		this.news = news;
		this.top_id = top_id;
		this.bottom_id = bottom_id;
		this.id = id;
		this.created_id = created_id;
		this.imgurl1 = imgurl1;
		this.thumbnail = thumbnail;
		this.content = content;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "user [news=" + news + ", top_id=" + top_id + ", bottom_id=" + bottom_id + ", id=" + id + ", created_id="
				+ created_id + ", imgurl1=" + imgurl1 + ", thumbnail=" + thumbnail + ", content=" + content + "]";
	}

}
