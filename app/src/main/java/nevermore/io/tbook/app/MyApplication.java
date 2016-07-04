package nevermore.io.tbook.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.xutils.x;

import nevermore.io.tbook.entity.Cart;
import nevermore.io.tbook.entity.User;

/**
 * Created by Administrator on 2016/6/22.
 */
public class MyApplication extends Application {
    private static MyApplication context;
    private Cart cart;
    private RequestQueue queue;
    private User user;
    private String token;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        context = this;
        cart = new Cart();
        cart = cart.readCart();
        queue = Volley.newRequestQueue(this);

    }

    public String getToken() {
        SharedPreferences preferences = getSharedPreferences("token",MODE_PRIVATE);
        String token = preferences.getString("token","");
        return token;
    }

    public  RequestQueue getQueue() {
        return queue;
    }

    public Cart getCart() {
        return cart;
    }

    public static MyApplication getContext() {
        return context;
    }

    /**
     * 保存当前用户
     * @param user
     */
    public void saveCurrentUser(User user){
        this.user = user;
    }

    public void saveToken(String token){
        this.token = token;
        SharedPreferences sharedPreferences = getSharedPreferences("token",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token",token);
        editor.commit();

    }

    public User getCurrentUser(){
        return this.user;
    }
}
