package net.junlai.domain;

public class Greeting {
    private Integer id;

    public Greeting(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
