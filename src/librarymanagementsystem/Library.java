package librarymanagementsystem;

import java.util.ArrayList;

class Library{

    private ArrayList <Book> books = new ArrayList<>();

    public Library(ArrayList<Book> b){
        this.books.addAll(b);
    }

    public void addBook(String Book, String Author){
        Book book = new Book(Book,Author);
        this.books.add(book);
        System.out.println("Book Added : "+book);
    }

    public void issueBook(Book b, Student s){
        b.setIssuedTo(s);
        System.out.println(b+"\n");
    }

    public void returnBook(Book b, Student s){
        b.setIssuedTo(null);
        System.out.println(b+" Returned By : "+s+"\n");
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

    public Book issuedBook(Student s){
        for(Book b : books){
            if(b.getIssuedTo()==s){
                return b;
            }
        }
        return null;
    }

}
