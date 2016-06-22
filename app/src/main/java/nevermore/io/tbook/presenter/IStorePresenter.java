package nevermore.io.tbook.presenter;

/**
 * Created by Administrator on 2016/6/22.
 */
public interface IStorePresenter extends IPresenter{

    /**
     * 通过接口获得编辑推荐列表
     */
    public void loadRecommendBook();

    /**
     * 通过接口获得热销图书列表
     */
    public void loadHotBook();
    /**
     * 通过接口获得最新上架的图书列表
     */
    public void loadNewBook();

}
