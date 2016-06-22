package nevermore.io.tbook.view;

import java.util.List;

import nevermore.io.tbook.entity.Book;

/**
 * Created by Lee on 2016/6/22.
 */
@SuppressWarnings("DefaultFileTemplate")
public interface IStoreView extends IView{

    /**
     * 更新编辑推荐列表信息
     */
    void updateRecommendList(List<Book> books);
    /**
     * 更新热销图书列表信息
     */
    void updateHotList(List<Book> books);
    /**
     * 更新新上架图书信息
     */
    void updateNewList(List<Book> books);

}
