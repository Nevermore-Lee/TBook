package nevermore.io.tbook.presenter;

/**
 * Created by Administrator on 2016/6/29.
 */
public interface ILoginPresenter extends IPresenter {
    /**
     * 登陆
     */
    public void login(String loginName,String password);
}
