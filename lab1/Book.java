public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String name, double price ){
        this.title = title;
        this.author = name;
        this.price = price;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String name){
        this.author = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
}
