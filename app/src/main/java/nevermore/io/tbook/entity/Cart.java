package nevermore.io.tbook.entity;

import android.util.Log;

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
    /**
     * 修改图书的数量
     */
    public void modifyNum(int id, int num){
        for (CartItem item :items) {
            if (item.getBook().getId()==id){
                item.setCount(num);
                return;
            }
        }
    }
    /**
     * deleteBook
     */
    public void deleteBook(int id){
        for (CartItem item:items) {
            if(item.getBook().getId()==id){
                items.remove(item);
                return;
            }
        }
//        int size = items.size();
//        for (int i = 0; i < size; i++) {
//            CartItem item =items.get(i);
//            if(item.getBook().getId()==id){
//                items.remove(item);
//            }
//        }
    }
    /**
     *获得合计价格
     */
    public  double getTotalPrice(){
        double price = 0;
        for (CartItem item: items) {
            price =price+item.getBook().getDangPrice()*item.getCount();
        }
        return price;
    }

}
