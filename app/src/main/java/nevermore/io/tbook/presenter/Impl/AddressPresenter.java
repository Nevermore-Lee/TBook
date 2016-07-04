package nevermore.io.tbook.presenter.Impl;

import java.util.List;

import nevermore.io.tbook.entity.Address;
import nevermore.io.tbook.model.IAddressModel;
import nevermore.io.tbook.model.IModel;
import nevermore.io.tbook.model.Impl.AddressModel;
import nevermore.io.tbook.presenter.IAddressPresenter;
import nevermore.io.tbook.view.IAddressView;

/**
 * Created by Administrator on 2016/7/4.
 */
public class AddressPresenter implements IAddressPresenter {

    private IAddressView view;
    private IAddressModel model;

    public AddressPresenter(IAddressView view ) {
        this.view = view;
        this.model = new AddressModel();
    }

    @Override
    public void saveAddress(Address address) {
        model.saveAddress(address, new IModel.AsyncCallback() {
            @Override
            public void onSucess(Object sucess) {
                view.dismissSaveAddressDialog();
            }

            @Override
            public void onError(Object error) {

            }
        });
    }

    @Override
    public void listAddress() {
        model.listAddress(new IModel.AsyncCallback() {
            @Override
            public void onSucess(Object sucess) {
                view.setAddress((List<Address>)sucess);
                view.setAdapter();
            }

            @Override
            public void onError(Object error) {

            }
        });
    }

    @Override
    public void setDefault(int id) {
        model.setDefault(id, new IModel.AsyncCallback() {
            @Override
            public void onSucess(Object sucess) {
                listAddress();
            }

            @Override
            public void onError(Object error) {

            }
        });
    }
}
