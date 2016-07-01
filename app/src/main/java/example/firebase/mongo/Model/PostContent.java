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


    public PostContent() {
    }

    public PostContent(String title, String detail, String image) {
        this.title = title;
        this.detail = detail;
        this.imageUrl = image;
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

    public String getImage() {
        return imageUrl;
    }

    public void setImage(String image) {
        this.imageUrl = image;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> postValues = new HashMap<>();
         postValues.put("title", title);
         postValues.put("detail", detail);
         postValues.put("imageUrl", imageUrl);

        return postValues;
    }
}
