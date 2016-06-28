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


----------------------------
1. 删除购物车中的购物项

2. 更改购物项中商品的数量

3. 更新购物车中商品总价格



## 在Cart对象中编写操作购物车的方法：

buy()

delete()

modifyNum()

getTotalPrice()



## 更新购物车中商品总价格

ICartView

  updateTotalPrice()
  
ICartPresenter 

  loadTotalPrice( )

ICartModel

  getTotalPrice()
  



## 删除购物车中的购物项
1>删除按钮的的动画操作
  在adapter对象中添加show标志位 true/false
  判断show变量的状态，执行对应的动画。
  获取每一个ivDel时，使用findViewWithTag()
2>在getView方法中给删除按钮添加onClickListener。
  需要让监听器获取点击的是哪一个item的删除按钮。
  然后删除集合中的item，更新Adapter。
  presenter.deleteBook();



## 更改购物项中商品的数量
1>在getView方法中给每一个+/-都添加监听。
  在监听方法中执行更改商品数量的业务。
2>获取点击修改按钮相应的item的position。
  获取tvCount/tvNum, 更改两个TextView的内容。
  需要使用findViewWithTag()
3>presenter.modifyNum()方法修改Cart对象。
  在presenter中修改成功后需要重新加载并且
  更新总价格。

