package nevermore.io.tbook.model;

import nevermore.io.tbook.entity.User;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface IUserModel extends IModel {
    public void login(String loginame, String password, AsyncCallback callback);

    public void regist(User user, String code, AsyncCallback callback);

    public void getImageCode(AsyncCallback callback);

    public void loginWithoutPwd(String token, AsyncCallback callback);

}
