package com.sdajava.jsonzad;

import java.time.LocalDate;

/**
 * Created by RENT on 2017-04-12.
 */
public class Model {

    private Object ID;
    private Object post_author;
    private LocalDate post_date;
    private Object post_content;
    private Object post_modified;
    private Object post_status;

    public Model(Object ID, Object post_author,
                 LocalDate post_date, Object post_content,
                 Object post_modified, Object post_status) {
        this.ID = ID;
        this.post_author = post_author;
        this.post_date =  post_date;
        this.post_content =  post_content;
        this.post_modified =  post_modified;
        this.post_status =  post_status;
    }

    @Override
    public String toString() {
        return "Model{" +
                "ID=" + ID +
                ", post_author='" + post_author + '\'' +
                ", post_date='" + post_date + '\'' +
                ", post_content='" + post_content + '\'' +
                ", post_modified='" + post_modified + '\'' +
                ", post_status='" + post_status + '\'' +
                '}';
    }

    public Object getID() {
        return ID;
    }

    public void setID(Object ID) {
        this.ID = ID;
    }

    public Object getPost_author() {
        return post_author;
    }

    public void setPost_author(Object post_author) {
        this.post_author = post_author;
    }

    public LocalDate getPost_date() {
        return post_date;
    }

    public void setPost_date(LocalDate post_date) {
        this.post_date = post_date;
    }

    public Object getPost_content() {
        return post_content;
    }

    public void setPost_content(Object post_content) {
        this.post_content = post_content;
    }

    public Object getPost_modified() {
        return post_modified;
    }

    public void setPost_modified(Object post_modified) {
        this.post_modified = post_modified;
    }

    public Object getPost_status() {
        return post_status;
    }

    public void setPost_status(Object post_status) {
        this.post_status = post_status;
    }
}
