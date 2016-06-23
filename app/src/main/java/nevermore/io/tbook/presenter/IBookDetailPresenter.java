package nevermore.io.tbook.presenter;

import nevermore.io.tbook.entity.Book;

/**
 * Created by Administrator on 2016/6/23.
 */
public interface IBookDetailPresenter extends IPresenter {
    /**
     * 把图书添加到购物车
     */
    public  void addToCart(Book book);
}
