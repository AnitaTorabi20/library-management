package library;

import datastructures.queues.CustomQueue;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    private CustomQueue waitlist;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;

        waitlist = new CustomQueue();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void addToWaitlist(Member member) {
        waitlist.add(member);
    }

    public Member getNextInWaitlist() {
        Object next = waitlist.poll();
        if (next == null) {
            return null;
        }
        return (Member) next;
    }

    public boolean hasWaitlist() {
        return !waitlist.isEmpty();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + isAvailable +
                '}';
    }
}
