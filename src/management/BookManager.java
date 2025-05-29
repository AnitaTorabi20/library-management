package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private CustomHashMap<String, Book> books;

    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        this.books = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return books.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            return false;
        }
        return book.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = books.get(isbn);
        if (book != null) {
            book.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
        Book book = books.get(isbn);
        if (book != null) {
            Member member = memberManager.getMember(memberId);
            if (member != null) {
                book.addToWaitlist(member);
            }
        }
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            return book.getNextInWaitlist();
        }
        return null;
    }

    public boolean hasWaitlist(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            return book.hasWaitlist();
        }
        return false;
    }
}
