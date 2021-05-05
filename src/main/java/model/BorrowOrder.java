package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="borrow_Orders")
public class BorrowOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name="id_book")
    private Book book;

    private int borrowCode;

    private Date borrowDate;

    public BorrowOrder() {
    }

    public BorrowOrder(Long id, Book book, int borrowCode, Date borrowDate) {
        this.id = id;
        this.book = book;
        this.borrowCode = borrowCode;
        this.borrowDate = borrowDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
