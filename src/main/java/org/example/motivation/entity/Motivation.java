package org.example.motivation.entity;

public class Motivation {

    int id;
    String regDate;
    String author;
    String body;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Motivation(int id, String regDate, String author, String body) {
        this.id = id;
        this.regDate = regDate;
        this.author = author;
        this.body = body;
    }
}
