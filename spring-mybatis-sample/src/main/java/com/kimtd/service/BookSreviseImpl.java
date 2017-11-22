package com.kimtd.service;

import com.kimtd.entity.Book;
import com.kimtd.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookSreviseImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book queryById(long id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<Book> queryAll(int offset, int limit) {
        return bookMapper.queryAll(offset, limit);
    }

    @Override
    public int reduceNumber(long bookId) {
        return bookMapper.reduceNumber(bookId);
    }
}
