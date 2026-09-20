public class BookDemo {
    public static void main(String[] args) {
        Book book = new Book(
            "Developing Java Software","Russel Winder", 79.75);
        System.out.println("The title is : "+book.getTitle());
        System.out.println("The author is : "+book.getAuthor());
    }
}
