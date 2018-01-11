package com.lanou3g.bookstore.book.service;

import com.lanou3g.bookstore.book.dao.BookDao;
import com.lanou3g.bookstore.book.domain.Book;
import com.lanou3g.bookstore.book.domain.Category;

import javax.servlet.jsp.jstl.sql.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookDao bookDao = new BookDao();
    public List<Book> pull() throws SQLException {
        ResultSet allBook = bookDao.queryAll();
        List<Book> list = new ArrayList<>();
        try {
            while (allBook.next()){
                String bid = allBook.getString("bid");
                String bname = allBook.getString("bname");
                double price = allBook.getDouble("price");
                String author = allBook.getString("author");
                String image = allBook.getString("image");
                String cid = allBook.getString("cid");
                Book book = new Book();
                book.setBid(bid);
                book.setBname(bname);
                book.setPrice(price);
                book.setAuthor(author);
                book.setImage(image);
                book.setCid(cid);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Book> findCid(String ccid) {
        ResultSet resultSet = bookDao.queryByCid(ccid);
        List<Book> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                String bid = resultSet.getString("bid");
                String bname = resultSet.getString("bname");
                double price = resultSet.getDouble("price");
                String author = resultSet.getString("author");
                String image = resultSet.getString("image");
                String cid = resultSet.getString("cid");
                Book book = new Book();
                book.setBid(bid);
                book.setBname(bname);
                book.setPrice(price);
                book.setAuthor(author);
                book.setImage(image);
                book.setCid(cid);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
