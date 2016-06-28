package nevermore.io.tbook.presenter;

import nevermore.io.tbook.entity.Book;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface ICartPresenter extends  IPresenter {
//    添加图书
    public boolean addBook(Book book);

//    删除图书
   public  void deleteBook(int bookId);

//    修改某一本图书数量
   public void modfiNum(int bookId,int num);

//     加载总价
    public void loadTotalPrice();
}
