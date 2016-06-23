package nevermore.io.tbook.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import nevermore.io.tbook.R;
import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.presenter.Impl.BookDetailPresenter;

public class BookDtailActivity extends AppCompatActivity {

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
        presenter = new BookDetailPresenter();
        x.view().inject(this);
    }
}
