package nevermore.io.tbook.view;

/**
 * Created by Lee on 2016/6/22.
 */
public interface ICartView extends  IView {
    /**
     * 修改总价格
     * @param price
     */
    public void updateTotalPrice(double price);
}
