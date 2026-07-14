package librarymanagementsystem;

class Book{

    private String bookName, authorName;
    private Student issuedTo;


    public String getBookName() {
        return bookName;
    }

    public boolean isIssued(){
        return issuedTo!=null;
    }

    public Student getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(Student issuedTo) {
        this.issuedTo = issuedTo;
    }

    public Book(String bookName, String authorName){
        this.bookName= bookName;
        this.authorName = authorName;
    }


    @Override
    public String toString() {
        return "Book {" +
                " Name = '" + bookName + '\'' +
                ", Author Name = '" + authorName + '\'' +
                ", Issued To : "+(isIssued() ? issuedTo.getName() : "Available")+
                " }";
    }

}
