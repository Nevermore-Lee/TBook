package nevermore.io.tbook.model.Impl;

import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.model.ICartModel;

/**
 * Created by Administrator on 2016/6/23.
 */
public class CartModel implements ICartModel {
    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public void deleteBook(int bookId) {

    }

    @Override
    public void modifyNum(int bookId, int num) {

    }

    @Override
    public double getTotalPrice() {
        return 0;
    }
}
