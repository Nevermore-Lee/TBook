package nevermore.io.tbook.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.R;
import nevermore.io.tbook.entity.User;
import nevermore.io.tbook.presenter.IRegistPresenter;
import nevermore.io.tbook.presenter.Impl.RegistPresenter;
import nevermore.io.tbook.view.IRegistView;

public class RegistActivity extends AppCompatActivity implements IRegistView {

    @ViewInject(R.id.ivCode)
    private ImageView ivCode;
    @ViewInject(R.id.btnLogin)
    private Button btLogin;
    @ViewInject(R.id.etLoginname)
    private EditText etLoginname;
    @ViewInject(R.id.etPwd)
    private EditText etPwd;
    @ViewInject(R.id.etRealname)
    private EditText etRealname;
    @ViewInject(R.id.etCode)
    private EditText etCode;
    private IRegistPresenter registPresenter;

    public RegistActivity() {
        this.registPresenter = new RegistPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        x.view().inject(this);
        registPresenter.loadImage();
    }

    @Override
    public void showImage(Bitmap bitmap) {
        if(bitmap!=null){
            ivCode.setImageBitmap(bitmap);
        }
    }

    @Override
    public void registSucess() {
        Toast.makeText(RegistActivity.this,"注册成功",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void registError(String errorMessage) {
        Toast.makeText(RegistActivity.this,"注册失败"+errorMessage,Toast.LENGTH_SHORT).show();
    }

    public void regist(View v){
        User user = new User();
        user.setEmail(etLoginname.getText().toString());
        user.setPassword(etPwd.getText().toString());
        user.setNickname(etRealname.getText().toString());
        String code = etCode.getText().toString();
        registPresenter.regist(user, code);
    }
}
