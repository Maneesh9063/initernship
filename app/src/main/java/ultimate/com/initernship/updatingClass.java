package ultimate.com.initernship;

public class updatingClass {

    private String Title;
    private String Author;
    private String Topic;
    private String content;
    private long TimeOfPost;
    private int image;

    public updatingClass(String Title, String Author, String Topic, long TimeOfPost,String content,int image) {
        this.Title = Title;
        this.Author = Author;
        this.Topic = Topic;
        this.TimeOfPost = TimeOfPost;
        this.content = content;
        this.image = image;

    }
    public updatingClass(){}

    public long getImage() {
        return image;
    }

    public void setImage(int image) {
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

    public long getTimeOfPost() {
        return TimeOfPost;
    }

    public void setTimeOfPost(long timeOfPost) {
        TimeOfPost = timeOfPost;
    }

}
