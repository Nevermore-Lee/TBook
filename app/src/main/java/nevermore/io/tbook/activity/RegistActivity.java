package nevermore.io.tbook.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.R;
import nevermore.io.tbook.presenter.IRegistPresenter;
import nevermore.io.tbook.presenter.Impl.RegistPresenter;
import nevermore.io.tbook.view.IRegistView;

public class RegistActivity extends AppCompatActivity implements IRegistView {

    @ViewInject(R.id.ivCode)
    private ImageView ivCode;
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
        ivCode.setImageBitmap(bitmap);
    }
}
