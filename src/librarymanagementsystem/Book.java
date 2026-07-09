package librarymanagementsystem;

class Book{

    private String bookName, authorName;
    private boolean isIssued = false;

    public String getBookName() {
        return bookName;
    }

    public boolean getIsIssued(){
        return isIssued;
    }

    public void setIsIssued(boolean issued){
        this.isIssued = issued;
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
                ", Status : "+(isIssued ? "Issued " : "Available ")+
                " }";
    }

}
