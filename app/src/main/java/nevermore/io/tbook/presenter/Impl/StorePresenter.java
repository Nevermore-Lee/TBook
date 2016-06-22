package nevermore.io.tbook.presenter.Impl;

import java.util.List;

import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.model.IModel;
import nevermore.io.tbook.model.IStoreModel;
import nevermore.io.tbook.model.Impl.StoreModel;
import nevermore.io.tbook.presenter.IStorePresenter;
import nevermore.io.tbook.view.IStoreView;

/**
 * Created by Administrator on 2016/6/22.
 */
public class StorePresenter implements IStorePresenter{
    private IStoreModel storeModel;
    private IStoreView storeView;

    public StorePresenter(IStoreView view) {
        this.storeModel =new StoreModel() ;
        this.storeView = view;
    }

    @Override
    public void loadRecommendBook() {
        storeModel.getRecommendList(new IModel.AsyncCallback() {
            @Override
            public void onSucess(Object sucess) {
                List<Book> books = (List<Book>)sucess;
                storeView.updateRecommendList(books);
            }

            @Override
            public void onError(Object error) {

            }
        });
    }

    @Override
    public void loadHotBook() {

    }

    @Override
    public void loadNewBook() {

    }
}
