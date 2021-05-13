package kz.iitu.endtermEE.model;

public class Comment {
    private Integer id;
    private String username;
    private String comment;
    private int postId;
    public Comment(Integer id, String username, String comment) {
        this.id = id;
        this.username = username;
        this.comment = comment;
    }

    public Comment() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
