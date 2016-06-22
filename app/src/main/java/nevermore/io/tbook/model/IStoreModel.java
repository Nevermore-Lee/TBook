package nevermore.io.tbook.model;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface IStoreModel {
    void getRecommendList(IModel.AsyncCallback callback);

    void getHotList(IModel.AsyncCallback callback);

    void getNewList(IModel.AsyncCallback callback);
}
