package nevermore.io.tbook.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.R;
import nevermore.io.tbook.presenter.ILoginPresenter;
import nevermore.io.tbook.presenter.Impl.LoginPresenter;
import nevermore.io.tbook.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView{
    @ViewInject(R.id.etLoginname)
    private EditText etLoginname;
    @ViewInject(R.id.etPwd)
    private EditText etPwd;
    @ViewInject(R.id.tvNewAccount)
    private TextView tvNewAccount;
    @ViewInject(R.id.tvModifyPwd)
    private TextView tvModifyPwd;
    @ViewInject(R.id.btnLogin)
    private Button btnLogin;
    private ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        x.view().inject(this);
        presenter = new LoginPresenter(this);
        setListeners();
    }

    /**
     * 设置监听器
     */

    private void setListeners() {
        LoginViewListener listener = new LoginViewListener();
        tvNewAccount.setOnClickListener(listener);
        btnLogin.setOnClickListener(listener);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }

    @Override
    public void loginFailed(String errorMessage) {

    }

    /**
     * 监听器
     */
    class  LoginViewListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.tvNewAccount:
                    Intent intent = new Intent(LoginActivity.this,RegistActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnLogin:
                    String name = etLoginname.getText().toString().trim();
                    String pwd = etPwd.getText().toString().trim();
                    if(name.equals("")||pwd.equals("")){
                        Toast.makeText(LoginActivity.this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    presenter.login(name,pwd);
                    Log.i("lee","btnLogin");
                    break;
            }

        }
    }
}
