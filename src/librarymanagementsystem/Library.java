package librarymanagementsystem;

import java.util.ArrayList;

class Library{

    ArrayList <Book> books = new ArrayList<>();

    public Library(ArrayList<Book> b){
        this.books.addAll(b);
    }

    public void addBook(String Book, String Author){
        this.books.add(new Book(Book,Author));
        System.out.println("Book Added : "+new Book(Book,Author) );
    }

    public void issueBook(Book b, String name){
        b.setIsIssued(true);
        System.out.println(b+" Issued to : "+name+"\n");
    }

    public void ReturnBook(Book b, String name){
        b.setIsIssued(false);
        System.out.println(b+" Returned By : "+name+"\n");
    }

    public void showBooks(){
        if(books.isEmpty()){
            System.out.println("No books are available at this time...");
        }
        for (Book b: books){
            System.out.println(b);
        }
    }

    public Book findBook(String bookName){
        for(Book book : books){
            if(book.getBookName().equalsIgnoreCase(bookName)){
                return book;
            }
        }
        return null;
    }

}
