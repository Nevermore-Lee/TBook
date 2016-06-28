package nevermore.io.tbook.presenter;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface IMinePresenter extends IPresenter {
    /**
     * 无密码登陆
     */
    public void loginWithoutPwd(String token);
}
