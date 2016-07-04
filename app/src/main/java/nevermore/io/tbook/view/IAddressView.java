package nevermore.io.tbook.view;


import java.util.List;

import nevermore.io.tbook.entity.Address;

/**
 * Created by Lee on 2016/7/4.
 */


public interface IAddressView extends IView {
    /**
     * 设置数据源集合
     */
    public void setAddress(List<Address> addresses);
    /**
     * 设置适配器
     */
    public void setAdapter();
    /**
     * 使保存地址的对话框消失
     */
    public void dismissSaveAddressDialog();
}
