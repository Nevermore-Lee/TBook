package nevermore.io.tbook.app;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2016/6/22.
 */
public class MyApplication extends Application {
    private static MyApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        context = this;
    }

    public static MyApplication getContext() {
        return context;
    }
}
