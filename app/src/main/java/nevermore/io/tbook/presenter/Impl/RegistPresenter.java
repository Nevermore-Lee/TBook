package nevermore.io.tbook.presenter.Impl;

import android.graphics.Bitmap;

import nevermore.io.tbook.model.IModel;
import nevermore.io.tbook.model.IUserModel;
import nevermore.io.tbook.model.Impl.UserModel;
import nevermore.io.tbook.presenter.IRegistPresenter;
import nevermore.io.tbook.view.IRegistView;

/**
 * Created by Administrator on 2016/6/28.
 */
public class RegistPresenter implements IRegistPresenter {
    private IRegistView view;
    private IUserModel model;

    public RegistPresenter(IRegistView view) {
        this.view = view;
        model = new UserModel();
    }

    @Override
    public void loadImage() {
        model.getImageCode(new IModel.AsyncCallback() {
            @Override
            public void onSucess(Object sucess) {
                view.showImage((Bitmap) sucess);
            }

            @Override
            public void onError(Object error) {

            }
        });
    }
}
