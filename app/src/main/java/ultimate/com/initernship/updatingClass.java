package ultimate.com.initernship;

public class updatingClass {

    private String Title;
    private String Author;
    private String Topic;
    private String content;
    private String TimeOfPost;
    private String image;
    private String newsUrl;

    public updatingClass(String Title, String Author, String Topic, String TimeOfPost,String content,String image , String newsUrl) {
        this.Title = Title;
        this.Author = Author;
        this.Topic = Topic;
        this.TimeOfPost = TimeOfPost;
        this.content = content;
        this.image = image;
        this.newsUrl = newsUrl;

    }
    public updatingClass(){}

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return Title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getTimeOfPost() {
        return TimeOfPost;
    }

    public void setTimeOfPost(String timeOfPost) {
        TimeOfPost = timeOfPost;
    }

}
