package nevermore.io.tbook.presenter.Impl;

import android.util.Log;

import nevermore.io.tbook.model.IModel;
import nevermore.io.tbook.model.IUserModel;
import nevermore.io.tbook.model.Impl.UserModel;
import nevermore.io.tbook.presenter.ILoginPresenter;
import nevermore.io.tbook.view.ILoginView;

/**
 * Created by Administrator on 2016/6/29.
 */
public class LoginPresenter implements ILoginPresenter {
    private IUserModel model;
    private ILoginView view;
    public LoginPresenter(ILoginView view) {
        this.model = new UserModel();
        this.view = view;
    }

    @Override
    public void login(String loginName, String password) {
        model.login(loginName, password, new IModel.AsyncCallback() {
            @Override
            public void onSucess(Object sucess) {
                view.loginSuccess();
                Log.i("lee","LoginPresenteronSucess");

            }

            @Override
            public void onError(Object error) {
                view.loginFailed((String)error);
                Log.i("lee","LoginPresenteronError");
            }
        });
    }
}
