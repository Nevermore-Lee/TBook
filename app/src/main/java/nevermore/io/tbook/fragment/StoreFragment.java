package nevermore.io.tbook.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import nevermore.io.tbook.activity.BookDtailActivity;
import nevermore.io.tbook.R;
import nevermore.io.tbook.adapter.StoreBookListAdapter;
import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.presenter.Impl.StorePresenter;
import nevermore.io.tbook.view.IStoreView;

/**
 * Created by Administrator on 2016/6/22.
 */
public class StoreFragment extends Fragment implements IStoreView {

    @ViewInject(R.id.gv_recommend)
    private GridView gv_recomand;
    @ViewInject(R.id.gv_new)
    private GridView gv_new;
    @ViewInject(R.id.gv_hot)
    private GridView gv_hot;
    @ViewInject(R.id.et_search)
    private EditText et_search;
    private StoreBookListAdapter recommendAdapter;
    private StoreBookListAdapter hotAdapter;
    private StoreBookListAdapter newAdapter;
    private StorePresenter storePresenter;
    private List<Book> recommendBooks;
    private List<Book> hotBooks;
    private List<Book> newBooks;

    public StoreFragment(){
        storePresenter = new StorePresenter(this);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, null);
        x.view().inject(this, view);
        et_search.clearFocus();
        storePresenter.loadRecommendBook();
        storePresenter.loadHotBook();
        storePresenter.loadNewBook();
        setListeners();
        return view;
    }

    /**
     * 设置监听器
     */

    private void setListeners() {
        gv_recomand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = recommendBooks.get(position);
                Intent intent = new Intent(getActivity(), BookDtailActivity.class);
                intent.putExtra("book",book);
                startActivity(intent);
            }
        });
        gv_hot.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = hotBooks.get(position);
                Intent intent = new Intent(getActivity(), BookDtailActivity.class);
                intent.putExtra("book",book);
                startActivity(intent);
            }
        });
        gv_new.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = newBooks.get(position);
                Intent intent = new Intent(getActivity(), BookDtailActivity.class);
                intent.putExtra("book",book);
                startActivity(intent);
            }
        });
    }


    @Override
    public void updateRecommendList(List<Book> books) {
        this.recommendBooks = books;
        recommendAdapter = new StoreBookListAdapter(getActivity(), recommendBooks);
        gv_recomand.setAdapter(recommendAdapter);
    }

    @Override
    public void updateHotList(List<Book> books) {
        this.hotBooks = books;
        hotAdapter = new StoreBookListAdapter(getActivity(),hotBooks);
        gv_hot.setAdapter(hotAdapter);
    }

    @Override
    public void updateNewList(List<Book> books) {
        this.newBooks = books;
        newAdapter = new StoreBookListAdapter(getActivity(),newBooks);
        gv_new.setAdapter(newAdapter);
    }
}
