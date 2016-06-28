package nevermore.io.tbook.adapter;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import nevermore.io.tbook.R;
import nevermore.io.tbook.entity.CartItem;
import nevermore.io.tbook.presenter.ICartPresenter;
import nevermore.io.tbook.presenter.Impl.CartPresenter;
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
    private ListView listView;
    private ICartPresenter presenter;
    public CartItemAdapter(Context context, List<CartItem> data, ListView listView) {
        super(context, data);
        this.listView = listView;
    }

    public void setPresenter(ICartPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
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
        if(!show){
            holder.ivDel.setScaleX(0);
            holder.ivDel.setScaleY(0);
        }else {
            holder.ivDel.setScaleX(1);
            holder.ivDel.setScaleY(1);
        }
        holder.ivDel.setOnClickListener(new DelItemListener(position));
        holder.ivp.setOnClickListener(new ModifyNumListener(position,ModifyNumListener.BUTTON_PLUS));
        holder.ivm.setOnClickListener(new ModifyNumListener(position,ModifyNumListener.BUTTON_MINUS));
        return convertView;
    }
    public boolean show =false;
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

    /**
     * 书籍数目的加减
     */

    class ModifyNumListener implements View.OnClickListener{
        public  static  final  int BUTTON_PLUS =1;
        public  static  final  int BUTTON_MINUS=2;
        private int position;
        private int type;

        public ModifyNumListener(int position, int type) {
            this.position = position;
            this.type = type;
        }

        @Override
        public void onClick(View v) {
            TextView tvNum = (TextView) listView.findViewWithTag("tvNum" + position);
            TextView tvCount = (TextView) listView.findViewWithTag("tvCount" + position);
            int number = Integer.parseInt(tvNum.getText().toString());
            switch (type){
                case BUTTON_PLUS:
                    number++;
                    tvNum.setText(number+"");
                    tvCount.setText("x"+number);
                    break;
                case BUTTON_MINUS:
                    number = number==1 ? number: number-1;
                    tvNum.setText(number+"");
                    tvCount.setText("x"+number);
                    break;
            }
            presenter.modfiNum(getItem(position).getBook().getId(),number);
        }
    }



    /**
     * 删除条目
     */

    class DelItemListener implements  View.OnClickListener{
        private int position;
        public DelItemListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            presenter.deleteBook(getItem(position).getBook().getId());
            CartItemAdapter.this.notifyDataSetChanged();
        }
    }

    /**
     * 切换显示删除图标
     */
    public void deleteToggle(){
        int maxPosition = getCount()-1;
        if(show){//立即隐藏
            for (int i = 0; i <= maxPosition ; i++) {
                final ImageView ivDel = (ImageView) listView.findViewWithTag("ivDel"+i);
                ObjectAnimator anim = ObjectAnimator.ofFloat(ivDel,"abc",1f,0f);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float val = (Float)animation.getAnimatedValue();
                        ivDel.setScaleX(val);
                        ivDel.setScaleY(val);
                    }
                });
                anim.setDuration(500);
                anim.start();
            }
            show = false;
        }else {//立即显示
            for (int i = 0; i <= maxPosition ; i++) {
                final  ImageView ivDel = (ImageView) listView.findViewWithTag("ivDel"+i);
                ObjectAnimator anim = ObjectAnimator.ofFloat(ivDel,"abc",0f,1f);
                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float val = (Float)animation.getAnimatedValue();
                        ivDel.setScaleX(val);
                        ivDel.setScaleY(val);
                    }
                });
                anim.setDuration(500);
                anim.start();
            }
            show = true;
        }
    }
}
