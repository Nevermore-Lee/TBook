package nevermore.io.tbook.model;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface IModel {
    public interface  AsyncCallback{
        void onSucess(Object sucess);
        void onError(Object error);
    }
}
