package com.gyaaanfbtest;

public class model {
    String c_name, c_author, c_thumb_link;

    public model(String c_name, String c_author, String c_thumb_link) {
        this.c_name = c_name;
        this.c_author = c_author;
        this.c_thumb_link = c_thumb_link;
    }

    public model() {
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_author() {
        return c_author;
    }

    public void setC_author(String c_author) {
        this.c_author = c_author;
    }

    public String getC_thumb_link() {
        return c_thumb_link;
    }

    public void setC_thumb_link(String c_thumb_link) {
        this.c_thumb_link = c_thumb_link;
    }
}
