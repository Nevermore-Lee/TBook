package nevermore.io.tbook.view;

import android.graphics.Bitmap;

/**
 * Created by Lee on 2016/6/28.
 */
public interface IRegistView extends IView {
    /**
     * 显示验证码图片
     * @param bitmap
     */
    public void showImage(Bitmap bitmap);

    /**
     * 注册成功提示
     */
    public void registSucess();

    /**
     * 注册失败提示
     * @param errorMessage
     */
    public void registError(String errorMessage);
}
