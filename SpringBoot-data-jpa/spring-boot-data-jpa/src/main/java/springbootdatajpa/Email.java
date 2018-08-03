package springbootdatajpa;

import java.util.Date;

public class Email {
    private String title;
    private String name;
    private Date date;

    public Email(String title, String name, Date date) {
        this.title = title;
        this.name = name;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Email{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
