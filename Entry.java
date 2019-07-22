package Blog;

import java.util.GregorianCalendar;

public abstract class Entry {
    private int id;
    private String date;
    private String author;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Entry(String author, String text) {
        this.id = Blog.identifier++;
        GregorianCalendar cal = new GregorianCalendar();
        this.date = cal.getTime().toString();
        this.author = author;
        this.text = text;
    }
}
