public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;
    private int memberId;
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.memberId = -1;
    }
    public int id() {
        return id;
    }
    public String title() {
        return title;
    }
    public String author() {
        return author;
    }
    public boolean issued() {
        return issued;
    }
    public int member() {
        return memberId;
    }
    public void out(int memberId) {
        issued = true;
        this.memberId = memberId;
    }
    public void back() {
        issued = false;
        memberId = -1;
    }
}
