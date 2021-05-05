package service.impl;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IBookRepository;
import service.IBookService;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);

    }
}
