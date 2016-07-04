package nevermore.io.tbook.model;

import nevermore.io.tbook.entity.Address;

/**
 * Created by Lee on 2016/7/4.
 */

public interface IAddressModel  extends IModel{
    /**
     *添加地址
     */
    public void saveAddress(Address address, AsyncCallback callback);

    /**
     * 地址列表
     */
    public void listAddress(AsyncCallback callback);

    /**
     * 设置默认地址
     */
    public void setDefault(int id, AsyncCallback callback);
}
