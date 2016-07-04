package nevermore.io.tbook.presenter;

import nevermore.io.tbook.entity.Address;

/**
 * Created by Administrator on 2016/7/4.
 */
public interface IAddressPresenter extends IPresenter {
    /**
     * 保存地址
     */
    public void saveAddress(Address address);

    /**
     * 访问地址列表
     */
    public void listAddress();

    /**
     * 设置默认地址
     */
    public void setDefault(int id);

}
