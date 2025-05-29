package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private CustomHashMap<String, Book> bookMap;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.bookMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        return getBookByIsbn(isbn).isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        getBookByIsbn(isbn).setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        getBookByIsbn(isbn).addToWaitlist(memberManager.getMember(memberId));
    }

    public Member getNextFromWaitlist(String isbn) {
        return getBookByIsbn(isbn).getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        return getBookByIsbn(isbn).hasWaitlist();
    }
}