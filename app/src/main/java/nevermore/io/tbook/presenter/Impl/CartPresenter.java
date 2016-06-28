package nevermore.io.tbook.presenter.Impl;

import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.model.ICartModel;
import nevermore.io.tbook.model.Impl.CartModel;
import nevermore.io.tbook.presenter.ICartPresenter;
import nevermore.io.tbook.view.ICartView;

/**
 * Created by Administrator on 2016/6/28.
 */
public class CartPresenter implements ICartPresenter {
    private ICartModel model;
    private ICartView view;
    public CartPresenter(ICartView view) {
        this.model = new CartModel();
        this.view = view;
    }

    @Override
    public boolean addBook(Book book) {
        return false;
    }

    @Override
    public void deleteBook(int bookId) {
        model.deleteBook(bookId);
        view.updateTotalPrice( model.getTotalPrice());
    }

    @Override
    public void modfiNum(int bookId, int num) {
        model.modifyNum(bookId,num);
        view.updateTotalPrice( model.getTotalPrice());
    }

    @Override
    public void loadTotalPrice() {
        view.updateTotalPrice( model.getTotalPrice());
    }
}
