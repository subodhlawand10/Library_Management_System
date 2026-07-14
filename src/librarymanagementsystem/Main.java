package librarymanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Book> oldBooks = new ArrayList<>();

        oldBooks.add(new Book("C++", "Bjarne"));

        oldBooks.add(new Book("Python", "Subodh"));

        oldBooks.add(new Book("JavaScript", "Gallion"));

        oldBooks.add(new Book("DataBase", "James"));

        Library l = new Library(oldBooks);

        Student.registerStudent(new Student(101, "Subodh"));
        Student.registerStudent(new Student(102,"Amit"));
        Student.registerStudent(new Student(103,"Dhruv"));
        Student.registerStudent(new Student(104,"Amar"));
        Student.registerStudent(new Student(105,"Suman"));
        Student.registerStudent(new Student(106,"Arijit"));
        Student.registerStudent(new Student(107, "Samir"));


        boolean start = true;
        Scanner sc = new Scanner(System.in);
        while(start){
            System.out.println("ENTER WHICH OPERATION DO YOU WANT TO PERFORM : \n" +
                    "1 -> Add New Book\n" +
                    "2 -> To Issue Book\n" +
                    "3 -> To Return Book\n" +
                    "4 -> To Register\n" +
                    "5 -> To Delete\n" +
                    "6 -> To View Books\n" +
                    "7 -> To View Students\n" +
                    "8 -> To Exit...\n");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1 :
                    System.out.println("Enter Book Name");
                    String bookName = sc.nextLine();
                    System.out.println("Enter Author Name");
                    String bookAuthor = sc.nextLine();
                    l.addBook(bookName,bookAuthor);
                    break;

                case 2 :
                    System.out.println("Enter Your id : ");
                    int issuedId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Book Name : ");
                    String issueBookName = sc.nextLine();

                    Student student = Student.findStudent(issuedId);
                    Book book = l.findBook(issueBookName);

                    if( book == null && student == null ){
                        System.out.println("Student and Book not Found");
                    } else if( student == null ){
                        System.out.println("Student not registered to the library");
                    } else if( book == null ) {
                        System.out.println("Book Not Found");
                    } else if( book.isIssued()){
                        System.out.println("Book is Issued");
                    } else {
                        l.issueBook(book,student);
                    }

                    break;

                case 3 :
                    System.out.println("Enter Your ID : ");
                    int returnedId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Book Name : ");
                    String returnBookName = sc.nextLine();

                    Student returnStudentName = Student.findStudent(returnedId);
                    Book rBookName = l.findBook(returnBookName);

                    if( rBookName == null && returnStudentName == null){
                        System.out.println("Student and Book Not Found");
                    } else if ( returnStudentName == null ) {
                        System.out.println("Student not registered to the library");
                    } else if ( rBookName == null ) {
                        System.out.println("Book not Exists in the library");
                    } else if ( !rBookName.isIssued() ) {
                        System.out.println("Book is not issued to anyone");
                    } else {
                        l.returnBook(rBookName,returnStudentName);
                    }

                    break;

                case 4 :
                    System.out.println("Enter Your ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Your Name : ");
                    String name = sc.nextLine();

                    if( id<=0 ){
                        System.out.println("Invalid ID");
                    } else{
                        Student.registerStudent(new Student(id,name));
                    }
                    break;

                case 5 :
                    System.out.println("Enter Your ID : ");
                    int deleteid = sc.nextInt();
                    sc.nextLine();

                    Student delStudent = Student.findStudent(deleteid);
                    Book issued = l.issuedBook(delStudent);
                    if( delStudent == null ){
                        System.out.println("Student not found");
                    } else if(issued!=null) {
                        System.out.println("Please return"+issued);
                    } else {
                        Student.deleteStudent(delStudent);
                    }

                    break;

                case 6 :
                    l.showBooks();
                    break;

                case 7 :
                    Student.getAllStudents();
                    break;

                case 8 :
                    start = false;
                    System.out.println("Thank You...");
                    break;

                default :
                    System.out.println("Invalid Choice...\nPlease try again");
            }
        }
        sc.close();

    }
}
