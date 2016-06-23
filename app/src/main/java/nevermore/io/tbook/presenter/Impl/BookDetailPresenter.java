package nevermore.io.tbook.presenter.Impl;

import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.model.ICartModel;
import nevermore.io.tbook.model.Impl.CartModel;
import nevermore.io.tbook.presenter.IBookDetailPresenter;
import nevermore.io.tbook.view.IBookDetailView;

/**
 * Created by Administrator on 2016/6/23.
 */
public class BookDetailPresenter implements IBookDetailPresenter {

    private ICartModel model;
    private IBookDetailView view;

    public BookDetailPresenter(IBookDetailView view) {
        this.view = view;
        this.model = new CartModel();
    }

    @Override
    public void addToCart(Book book) {
        boolean b = model.addBook(book);
        view.addToCartSuccess();
    }
}
