package nevermore.io.tbook.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.R;
import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.presenter.Impl.BookDetailPresenter;
import nevermore.io.tbook.util.BitmapUtils;
import nevermore.io.tbook.util.GlobalConsts;
import nevermore.io.tbook.view.IBookDetailView;

public class BookDtailActivity extends AppCompatActivity implements IBookDetailView {

    private Book book;
    @ViewInject(R.id.ivBookPic)
    private ImageView ivBookPic;
    @ViewInject(R.id.ivHeaderBackground)
    private ImageView ivHeaderBackground;
    @ViewInject(R.id.tvAuthor)
    private TextView tvAuthor;
    @ViewInject(R.id.tvCategory)
    private TextView tvCategory;
    @ViewInject(R.id.tvDate)
    private TextView tvPublishDate;
    @ViewInject(R.id.tvPublish)
    private TextView tvPublish;
    @ViewInject(R.id.tvDescription)
    private TextView tvDescription;
    @ViewInject(R.id.btnAddToCart)
    private Button btnAddCart;
    private BookDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_dtail);
//        初始化Presenter
        presenter = new BookDetailPresenter(this);
        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra("book");
        Log.i("lee",""+book.toString());
        x.view().inject(this);
//        加载图书信息
        setBookInfo();
    }

    private void setBookInfo() {
        tvAuthor.setText(book.getAuthor());
        tvCategory.setText(book.getCatalogue());
        tvPublishDate.setText(book.getPublishedTime());
        tvPublish.setText(book.getPublishing());
        tvDescription.setText(book.getDescription());
        x.image().bind(ivBookPic, GlobalConsts.BASEURL + "productImages/" + book.getProduct_pic(), new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                Bitmap bitmap = ((BitmapDrawable) result).getBitmap();
                bitmap = BitmapUtils.createBlurBitmap(bitmap, 20);
                ivHeaderBackground.setImageBitmap(bitmap);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void addToCartSuccess() {
        Toast.makeText(this, "已添加到购物车", Toast.LENGTH_SHORT).show();
        btnAddCart.setText("已添加到购物车");
        btnAddCart.setEnabled(false);
        Log.i("info", "cart:" + MyApplication.getContext().getCart());
    }

    @Override
    public void addToCartFail(String errorMessage) {
        Toast.makeText(this, "购物车添加失败:" + errorMessage, Toast.LENGTH_SHORT).show();
        btnAddCart.setEnabled(true);
    }

    public void addCart(View view){
        btnAddCart.setEnabled(false);
        presenter.addToCart(book);
    }
}
