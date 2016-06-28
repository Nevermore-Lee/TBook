package nevermore.io.tbook.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.R;

public class LoginActivity extends AppCompatActivity {
    @ViewInject(R.id.tvNewAccount)
    private TextView tvNewAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        x.view().inject(this);
        setListeners();
    }

    /**
     * 设置监听器
     */

    private void setListeners() {
        LoginViewListener listener = new LoginViewListener();
        tvNewAccount.setOnClickListener(listener);
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
            }

        }
    }
}
