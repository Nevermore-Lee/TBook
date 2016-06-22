package nevermore.io.tbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

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
    @ViewInject(R.id.et_search)
    private EditText et_search;
    private StoreBookListAdapter recommendAdapter;
    private StorePresenter storePresenter;
    private List<Book> recommendBooks;

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
        return view;
    }


    @Override
    public void updateRecommendList(List<Book> books) {
        this.recommendBooks = books;
        recommendAdapter = new StoreBookListAdapter(getActivity(), recommendBooks);
        gv_recomand.setAdapter(recommendAdapter);
    }

    @Override
    public void updateHotList(List<Book> books) {

    }

    @Override
    public void updateNewList(List<Book> books) {

    }
}
