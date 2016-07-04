package nevermore.io.tbook.presenter.Impl;

import nevermore.io.tbook.model.IModel;
import nevermore.io.tbook.model.IUserModel;
import nevermore.io.tbook.model.Impl.UserModel;
import nevermore.io.tbook.presenter.IMinePresenter;
import nevermore.io.tbook.view.IMineView;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MinePresenter implements IMinePresenter {
    private IMineView view;
    private IUserModel model;

    public MinePresenter(IMineView view) {
        this.view = view;
        this.model = new UserModel();
    }

    @Override
    public void loginWithoutPwd(String token) {
        model.loginWithoutPwd(token, new IModel.AsyncCallback() {
            @Override
            public void onSucess(Object sucess) {
                view.updateUserInfo();
            }

            @Override
            public void onError(Object error) {

            }
        });
    }
}
