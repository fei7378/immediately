package user;

public class UserOfNavigate {
	private int id;
	private String type;
	private String img_url;
	private String title;
	private String gw_url;
	private String content;
	private String type_name;
	private String title_en;

	public UserOfNavigate(int id, String type, String img_url, String title, String gw_url, String content,
			String type_name, String title_en) {
		super();
		this.id = id;
		this.type = type;
		this.img_url = img_url;
		this.title = title;
		this.gw_url = gw_url;
		this.content = content;
		this.type_name = type_name;
		this.title_en = title_en;
	}

	@Override
	public String toString() {
		return "UserOfNavigate [id=" + id + ", type=" + type + ", img_url=" + img_url + ", title=" + title + ", gw_url="
				+ gw_url + ", content=" + content + ", type_name=" + type_name + ", title_en=" + title_en + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGw_url() {
		return gw_url;
	}

	public void setGw_url(String gw_url) {
		this.gw_url = gw_url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getTitle_en() {
		return title_en;
	}

	public void setTitle_en(String title_en) {
		this.title_en = title_en;
	}

}
