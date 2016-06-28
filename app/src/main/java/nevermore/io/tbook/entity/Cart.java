package nevermore.io.tbook.entity;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.util.GlobalConsts;

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

    /**
     * 持久化存储到本地
     */
    public void saveCart(){
        try {
            File file = new File(MyApplication.getContext().getCacheDir(), GlobalConsts.CART_CACHE_FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(this);
            oos.flush();
            Log.i("ssss","2");
            oos.close();
        } catch (IOException e) {
            Log.i("ssss","1");
            e.printStackTrace();
        }
    }
    /**
     * 从序列化的文件中读取购物车信息
     */
    public Cart readCart(){
        try {
            File file = new File(MyApplication.getContext().getCacheDir(), GlobalConsts.CART_CACHE_FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Cart cart = (Cart) ois.readObject();
            if(cart==null){
                Log.i("xxxx","123");
                return  new Cart();
            }
            Log.i("xxxx","12");
            return cart;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.i("xxxx","3");
        return  new Cart();
    }

    /**
     * toString
     * @return
     */
    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }
}
