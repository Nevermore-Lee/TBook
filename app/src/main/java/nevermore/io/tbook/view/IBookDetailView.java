package nevermore.io.tbook.view;

/**
 * Created by Lee on 2016/6/23.
 */
public interface IBookDetailView extends  IView {

    /**
     * 添加购物车成功后执行
     */
    public void addToCartSuccess();

    /**
     * 添加购物车失败后执行
     * @param errorMessage 失败原因信息
     */
    public void addToCartFail(String errorMessage);
}
