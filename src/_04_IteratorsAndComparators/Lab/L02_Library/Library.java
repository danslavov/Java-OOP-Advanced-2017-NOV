package _04_IteratorsAndComparators.Lab.L02_Library;

import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {

    private Book[] books;
    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book> {
        private int counter = 0;

        public boolean hasNext() {
            return this.counter < books.length;
        }

        public Book next() {
            counter++;
            return books[counter - 1];
        }
    }
}
