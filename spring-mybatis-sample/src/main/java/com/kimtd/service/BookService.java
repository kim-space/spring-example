package com.kimtd.service;

import com.kimtd.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    Book queryById(long id);

    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int reduceNumber(long bookId);
}
