package nevermore.io.tbook.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2016/6/23.
 */
public class Cart  implements Serializable{

    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }
    public  boolean buy(Book book){
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            if (item.getBook().equals(book)) {
                item.setCount(item.getCount() + 1);
                return false;
            }
        }
        //没有添加过
        CartItem item = new CartItem(book, 1);
        items.add(item);
        return true;
    }
}
