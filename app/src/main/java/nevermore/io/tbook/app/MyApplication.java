package nevermore.io.tbook.app;

import android.app.Application;

import org.xutils.x;

import nevermore.io.tbook.entity.Cart;

/**
 * Created by Administrator on 2016/6/22.
 */
public class MyApplication extends Application {
    private static MyApplication context;
    private Cart cart;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        context = this;
        cart = new Cart();

    }

    public Cart getCart() {
        return cart;
    }

    public static MyApplication getContext() {
        return context;
    }
}
