package Blog;

import java.util.GregorianCalendar;

public abstract class Entry {
    private Integer id;
    private String date;
    private String author;
    private String text;

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Entry(String author, String text) {
        this.id = Blog.identifier++;
        GregorianCalendar cal = new GregorianCalendar();
        this.date = cal.getTime().toString();
        this.author = author;
        this.text = text;
        Blog.entries++;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }
}
