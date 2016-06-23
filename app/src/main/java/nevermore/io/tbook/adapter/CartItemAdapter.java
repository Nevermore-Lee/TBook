package nevermore.io.tbook.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import nevermore.io.tbook.R;
import nevermore.io.tbook.entity.CartItem;
import nevermore.io.tbook.util.GlobalConsts;

/**
 * Created by Administrator on 2016/6/23.
 */
public class CartItemAdapter extends BaseAdapter<CartItem> {
    /**
     * ���췽��
     *
     * @param context Context���󣬲�����Ϊnull
     * @param data
     */
    public CartItemAdapter(Context context, List<CartItem> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartItem item = getData().get(position);
        ViewHolder holder = null;
        if(convertView==null){
            convertView = getLayoutInflater().inflate(R.layout.item_cart_lv_cartitem,null);
            holder = new ViewHolder();
            holder.ivBookPic = (ImageView) convertView.findViewById(R.id.ivBookPic);
            holder.ivm = (ImageView) convertView.findViewById(R.id.ivm);
            holder.ivp = (ImageView) convertView.findViewById(R.id.ivp);
            holder.ivDel = (ImageView) convertView.findViewById(R.id.ivDel);
            holder.tvBookName = (TextView) convertView.findViewById(R.id.tvBookName);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tvPrice);
            holder.tvCount = (TextView) convertView.findViewById(R.id.tvCount);
            holder.tvNum = (TextView) convertView.findViewById(R.id.tvNum);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        x.image().bind(holder.ivBookPic, GlobalConsts.BASEURL+"productImages/"+item.getBook().getProduct_pic());
        holder.tvBookName.setText(item.getBook().getProductName());
        holder.tvPrice.setText(item.getBook().getDangPrice() + "￥");
        holder.tvCount.setText("x" + item.getCount());
        holder.tvCount.setTag("tvCount" + position);
        holder.tvNum.setText(item.getCount() + "");
        holder.tvNum.setTag("tvNum" + position);
        holder.ivDel.setTag("ivDel" + position);
        return convertView;
    }
    class ViewHolder {
        ImageView ivBookPic;
        TextView tvBookName;
        TextView tvPrice;
        TextView tvCount;
        ImageView ivm;
        ImageView ivp;
        TextView tvNum;
        ImageView ivDel;
    }
}
