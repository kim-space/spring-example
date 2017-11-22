package com.kimtd.mapper;


import com.kimtd.entity.Book;
import com.kimtd.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookMapperTest {

    @Autowired
    private BookService bookService;

    @Test
    public void queryById() throws Exception {
        long bookId = 1000;
        Book book = bookService.queryById(bookId);
        System.out.println(book);
    }

    @Test
    public void queryAll() throws Exception {
        List<Book> books = bookService.queryAll(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void reduceNumber() throws Exception {
        long bookId = 1000;
        int update = bookService.reduceNumber(bookId);
        System.out.println("update=" + update);
    }

}