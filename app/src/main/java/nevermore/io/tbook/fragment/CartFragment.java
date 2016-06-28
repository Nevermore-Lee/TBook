package nevermore.io.tbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import nevermore.io.tbook.R;
import nevermore.io.tbook.adapter.CartItemAdapter;
import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.CartItem;
import nevermore.io.tbook.presenter.ICartPresenter;
import nevermore.io.tbook.presenter.Impl.CartPresenter;
import nevermore.io.tbook.view.ICartView;

/**
 * Created by Administrator on 2016/6/22.
 */
public class CartFragment extends Fragment implements ICartView {
    private ICartPresenter cartPresenter;
    private List<CartItem> items;
    private CartItemAdapter cartAdapter;
    @ViewInject(R.id.lv_cart_book_item)
    private ListView lvCart;
    @ViewInject(R.id.tv_remind_message)
    private TextView tvEmptyCart;
    @ViewInject(R.id.bt_cart_editor)
    private Button btnEdit;
    @ViewInject(R.id.tv_total)
    private TextView tvTotalPrice;
    @ViewInject(R.id.bt_submit)
    private Button btnSubmit;
    @ViewInject(R.id.lv_cart_book_item)
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart,null);
        x.view().inject(this,view);
        cartPresenter = new CartPresenter(this);
        items = MyApplication.getContext().getCart().getItems();
        setListeners();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setAdapter();
    }

    /**
     * 设置监听器
     */

    private void setListeners() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartAdapter.deleteToggle();
            }
        });
    }

    private void setAdapter() {
        cartAdapter = new CartItemAdapter(getActivity(),items,listView);
        lvCart.setAdapter(cartAdapter);
        cartAdapter.setPresenter(cartPresenter);
//        计算合计
        cartPresenter.loadTotalPrice();
    }

    @Override
    public void updateTotalPrice(double price) {
        tvTotalPrice.setText("￥"+price);
    }
}
