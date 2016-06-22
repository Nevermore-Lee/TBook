package nevermore.io.tbook.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import nevermore.io.tbook.R;
import nevermore.io.tbook.fragment.CartFragment;
import nevermore.io.tbook.fragment.MineFragment;
import nevermore.io.tbook.fragment.StoreFragment;

public class MainActivity extends FragmentActivity {
    @ViewInject(R.id.vp_home)
    private ViewPager viewPager;
    @ViewInject(R.id.rg_tab)
    private RadioGroup rgTab;
    @ViewInject(R.id.rb_car)
    private RadioButton rbCart;
    @ViewInject(R.id.rb_store)
    private RadioButton rbStore;
    @ViewInject(R.id.rb_mine)
    private RadioButton rbMine;
    private List<Fragment> fragments;
    private MyViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        获得控件
        x.view().inject(this);
//        给ViewPager设置适配器
        setViewPagerAdapter();
//        实现联动
        setListeners();
    }

    /**
     * 监听器
     */

    private void setListeners() {
        rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_store:
                        viewPager.setCurrentItem(0);
                        Log.i("lee", "选择了store");
                        break;
                    case R.id.rb_car:
                        viewPager.setCurrentItem(1);
                        Log.i("lee", "选择了cart");
                        break;
                    case R.id.rb_mine:
                        viewPager.setCurrentItem(2);
                        Log.i("lee", "选择了mine");
                        break;
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rbStore.setChecked(true);
                        Log.i("lee", "第一页");
                        break;
                    case 1:
                        rbCart.setChecked(true);
                        Log.i("lee", "第二页");
                        break;
                    case 2:
                        rbMine.setChecked(true);
                        Log.i("lee", "第三页");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 给ViewPager设置适配器
     */

    private void setViewPagerAdapter() {
//        构建Fragment数据源
        fragments = new ArrayList<Fragment>();
//        向fragments中添加fragment
        fragments.add(new StoreFragment());
        fragments.add(new CartFragment());
        fragments.add(new MineFragment());
        viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    /**
     * 获取控件
     */

    private void setViews() {
        viewPager = (ViewPager) findViewById(R.id.vp_home);
        rgTab = (RadioGroup) findViewById(R.id.rg_tab);
        rbStore = (RadioButton) findViewById(R.id.rb_store);
        rbCart = (RadioButton) findViewById(R.id.rb_car);
        rbMine = (RadioButton) findViewById(R.id.rb_mine);
    }

    /**
     * 编写ViewPager的adapter
     */

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


}
