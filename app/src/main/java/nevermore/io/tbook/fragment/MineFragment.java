package nevermore.io.tbook.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.activity.LoginActivity;
import nevermore.io.tbook.R;
import nevermore.io.tbook.view.IMineView;

/**
 * Created by Administrator on 2016/6/22.
 */
public class MineFragment extends Fragment implements IMineView {
    @ViewInject(R.id.ivPhoto)
    private ImageView ivPhoto;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,null);
        x.view().inject(this,view);
        setListeners();
        return view;
    }

    /**
     * 设置监听器
     */

    private void setListeners() {
        MineListener listener = new MineListener();
        ivPhoto.setOnClickListener(listener);
    }

    @Override
    public void updateUserInfo() {
        // TODO
    }

    class MineListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.ivPhoto:
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

}
