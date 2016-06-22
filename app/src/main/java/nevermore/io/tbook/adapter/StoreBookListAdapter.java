package nevermore.io.tbook.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import nevermore.io.tbook.R;
import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.fragment.StoreFragment;
import nevermore.io.tbook.util.GlobalConsts;

/**
 * Created by Administrator on 2016/6/22.
 */
public class StoreBookListAdapter extends BaseAdapter<Book> {
    /**
     * ���췽��
     *  @param context Context���󣬲�����Ϊnull
     * @param data*/
    public StoreBookListAdapter(FragmentActivity context, List<Book> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = getData().get(position);
        ViewHolder holder;
        if(convertView==null){
            convertView = getLayoutInflater().inflate(R.layout.item_recommand_book,null);
            holder = new ViewHolder();
            holder.iv_recommand_book = (ImageView) convertView.findViewById(R.id.iv_recommand_book);
            holder.tv_recommand_book = (TextView)convertView.findViewById(R.id.tv_recommand_book);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_recommand_book.setText(book.getProductName());
        x.image().bind(holder.iv_recommand_book, GlobalConsts.BASEURL+"productImages/"+book.getProduct_pic());
        return convertView;
    }
    class ViewHolder{
        ImageView iv_recommand_book;
        TextView tv_recommand_book;
    }
}
