package nevermore.io.tbook.presenter;

import nevermore.io.tbook.entity.User;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface IRegistPresenter extends  IPresenter {
    /**
     * 加载验证码
     */
    public void loadImage();
    /**
     *注册
     */
    public void regist(User user, String code);
}
