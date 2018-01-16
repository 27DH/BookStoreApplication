package com.dailyart.bookstoreapplication.bookdb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

/**
 * Created by 27DH on 2018/1/2.
 */

@Entity(tableName = "book")
public class Book {
    @PrimaryKey
    @NonNull
    private int id;
    @ColumnInfo(name = "book_name")
    private String bookName;
    private String author;
    @ColumnInfo(name = "public_date")
    private Date publicDate;
    private String press;
    private String isbn;
    private float price;
    private String category;
    @ColumnInfo(name = "word_count")
    private int wordCount;

    public Book(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(Date publicDate) {
        this.publicDate = publicDate;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount() {
        this.wordCount = wordCount;
    }
}
