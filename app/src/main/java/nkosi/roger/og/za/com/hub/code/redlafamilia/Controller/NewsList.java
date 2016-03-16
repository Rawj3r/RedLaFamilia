package nkosi.roger.og.za.com.hub.code.redlafamilia.Controller;

/**
 * Created by empirestate on 3/16/16.
 */
public class NewsList {
    private String title, image, detail;
    private String[] restNews;

    public NewsList(String detail, String image, String[] restNews, String title) {
        this.detail = detail;
        this.image = image;
        this.restNews = restNews;
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getRestNews() {
        return restNews;
    }

    public void setRestNews(String[] restNews) {
        this.restNews = restNews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
