# TBook
## 完成项目基本架构
## 引入框架
##  ViewPager+Fragment的基本联动
##  完成StoreFragment布局


1>
完成项目基本架构(MVP+Volley+Gson+xutils)
分包结构：
cn.tedu.tbook
  activity
  entity
  view
  presenter
  model
  util
  fragment
  adapter
  app

2>
导入： volley.jar   xutils.jar  gson.jar


3>
ViewPager+Fragment的基本联动
ViewPager
RadioGroup+RadioButton+selector
编写3个Fragment并且实现联动
  StoreFrament
  CartFragment
  MineFragment


4>
完成StoreFragment布局

完成StoreFragment中数据的显示。

执行MVP流程：

View层：
  IStoreView{
    void showRecommendBookList(List<Book> book);
    void showHotBookList(List<Book> book);
    void showNewBookList(List<Book> book);
  }

  StoreFragment implements IStoreView{...}


Presenter层：
  IStorePresenter {
     void loadRecommendBooks();
     void loadHotBooks();
     void loadNewBooks();
  }  
  StorePresenterImpl implements IStorePresenter{
     ....
  }


Model层：
  IStoreModel{
     void loadRecommendBooks(Callback back);
     void loadHotBooks(Callback back);
     void loadNewBooks(Callback back);
  }
  StoreModelImpl impl IStoreModel{
     使用Volley发送请求执行业务
     获取响应文本后解析json字符串(可以用Gson)
     List<Book>
  }



完成StoreFragment中数据的显示。
1>设计MVP三层的接口及接口方法。

2>编写实现类，实现Model层接口:
  使用Volley，注意Volley的使用规则。
  需要异步加载JSON字符串，解析List<Book>后
  在主线程回调callback接口方法。

3>编写实现类，实现Presenter层接口.
  一旦获取到List<Book>，调用view层相关的接口
  呈现界面。

4>让StoreFragment实现View层接口：
  实现3个更新GridView的接口方法。

5>自定义Adapter：
  注意GridView的高度不能小于Item的高度。
  getView方法中加载图片，推荐使用Volley。
