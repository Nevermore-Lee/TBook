package nevermore.io.tbook.model.Impl;

import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.entity.Cart;
import nevermore.io.tbook.model.ICartModel;

/**
 * Created by Administrator on 2016/6/23.
 */
public class CartModel implements ICartModel {

    private Cart cart;

    public CartModel() {
        cart = MyApplication.getContext().getCart();
    }

    @Override
    public boolean addBook(Book book) {
        cart.saveCart();
        return cart.buy(book);
    }

    @Override
    public void deleteBook(int bookId) {
        cart.deleteBook(bookId);
        cart.saveCart();
    }

    @Override
    public void modifyNum(int bookId, int num) {
        cart.modifyNum(bookId,num);
        cart.saveCart();
    }

    @Override
    public double getTotalPrice() {
        return cart.getTotalPrice();
    }
}
