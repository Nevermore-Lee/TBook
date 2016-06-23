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

/**
 * Created by Administrator on 2016/6/22.
 */
public class CartFragment extends Fragment {
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart,null);
        x.view().inject(this,view);
        items = MyApplication.getContext().getCart().getItems();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setAdapter();
    }

    private void setAdapter() {
        cartAdapter = new CartItemAdapter(getActivity(),items);
        lvCart.setAdapter(cartAdapter);
    }
}
