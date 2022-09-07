package list;

import java.util.ArrayList;
import java.util.List;

public class Library implements StoreBook {

    private final List<Book> books = new ArrayList<>();

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAllByNamed(String criteria) {

        return List.of();
    }
}