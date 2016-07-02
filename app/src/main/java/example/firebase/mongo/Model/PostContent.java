package example.firebase.mongo.Model;


import java.util.HashMap;
import java.util.Map;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class PostContent {

    private String title;
    private String detail;
    private String imageUrl;
    private String author;
    private int rating;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    public PostContent() {
    }

    public PostContent(String title, String detail, String image, String author, int rating) {
        this.title = title;
        this.detail = detail;
        this.imageUrl = image;
        this.author = author;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> postValues = new HashMap<>();
         postValues.put("title", title);
         postValues.put("detail", detail);
         postValues.put("imageUrl", imageUrl);
         postValues.put("author", author);
         postValues.put("rating", rating);

        return postValues;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
