package Blog;

import java.util.ArrayList;
import java.util.List;

public class Post extends Entry {
    private List<Comment> Comments = new ArrayList<>();

    public Post(String author, String text) {
        super(author, text);

    }

    public List<Comment> getComments() {
        return Comments;
    }

    public void setComment(Comment comment) {
        Comments.add(comment);
    }
}
