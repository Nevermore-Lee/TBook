package nevermore.io.tbook.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import nevermore.io.tbook.R;
import nevermore.io.tbook.adapter.AddressAdapter;
import nevermore.io.tbook.entity.Address;
import nevermore.io.tbook.presenter.IAddressPresenter;
import nevermore.io.tbook.presenter.Impl.AddressPresenter;
import nevermore.io.tbook.view.AddressDialog;
import nevermore.io.tbook.view.IAddressView;

public class AddressActivity extends AppCompatActivity implements IAddressView {

    @ViewInject(R.id.lvAddress)
    private ListView listView;
    private Dialog dialog;
    private IAddressPresenter presenter;
    private AddressAdapter adapter;
    private List<Address> addresss=new ArrayList<Address>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        x.view().inject(this);
        presenter = new AddressPresenter(this);

        presenter.listAddress();
    }

    /**
     * 添加监听
     *
     * @param view
     */
    public void doClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddAddress:
                showAddAddressDialog();
                break;
        }
    }

    private void showAddAddressDialog() {
        dialog = new AddressDialog(this, new AddressDialog.Callback() {
            @Override
            public void onSubmit(Address address) {
                presenter.saveAddress(address);
            }
        });
        dialog.show();
    }

    @Override
    public void setAddress(List<Address> addresses) {

    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void dismissSaveAddressDialog() {

    }
}
