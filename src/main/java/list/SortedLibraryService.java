package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedLibraryService {

    /**
     * Метод возвращает все книги которые имеют нужный тип.
     * @param books книги
     * @return книги Б/У или Новые.
     */
    public List<Book> getBooksByType(List<Book> books, TypeBook typeBook) {
        List<Book> result = new ArrayList<>();
        for (Book book: books) {
            if (book.getTypeBook() == typeBook) {
                result.add(book);
            }
        }

        return result;
    }
}