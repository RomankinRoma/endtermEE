package kz.iitu.endtermEE.model;

import java.util.List;

public class Post {
    Integer id;
    String head;
    String info;
    private int user_id;
    List<Comment> comments;

    public Post() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Post(Integer id, String head, String info, List<Comment> comments) {
        this.id = id;
        this.head = head;
        this.info = info;
        this.comments = comments;
    }
}
