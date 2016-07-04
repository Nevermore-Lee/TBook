package nevermore.io.tbook.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.activity.LoginActivity;
import nevermore.io.tbook.R;
import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.User;
import nevermore.io.tbook.presenter.Impl.MinePresenter;
import nevermore.io.tbook.view.IMineView;

/**
 * Created by Administrator on 2016/6/22.
 */
public class MineFragment extends Fragment implements IMineView {

    private static final int REQUEST_CODE_LOGIN_USER = 1;

    @ViewInject(R.id.ivPhoto)
    private ImageView ivPhoto;
    @ViewInject(R.id.tvNickname)
    private TextView tvNickname;
    private MinePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine,null);
        x.view().inject(this,view);
        presenter = new MinePresenter(this);
        setListeners();
        //自动登录
        String token = MyApplication.getContext().getToken();
        if(token != null) {
            presenter.loginWithoutPwd(token);
        }
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
        User user = MyApplication.getContext().getCurrentUser();
        String nickname=user.getNickname();
        tvNickname.setText(nickname);
    }

    class MineListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.ivPhoto:
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivityForResult(intent,1);
                    break;
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case REQUEST_CODE_LOGIN_USER:
                if(resultCode == Activity.RESULT_OK) {
                    updateUserInfo();
                }
                break;
        }
    }
}
