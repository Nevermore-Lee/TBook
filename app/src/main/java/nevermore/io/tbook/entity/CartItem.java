package nevermore.io.tbook.entity;

/**
 * Created by Lee on 2016/6/23.
 */
public class CartItem {
    private Book book;
    private int count;

    public CartItem() {

    }

    public CartItem(Book book, int count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                '}';
    }
}