package nevermore.io.tbook.model.Impl;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.Book;
import nevermore.io.tbook.model.IModel;
import nevermore.io.tbook.model.IStoreModel;
import nevermore.io.tbook.util.GlobalConsts;
import nevermore.io.tbook.util.JSONParser;

/**
 * Created by Lee on 2016/6/22.
 */
public class StoreModel implements IStoreModel{
    private RequestQueue queue;
    public StoreModel(){
        queue = Volley.newRequestQueue(MyApplication.getContext());
        Log.i("lee",queue.hashCode()+"");
    }

    @Override
    public void getRecommendList(final IModel.AsyncCallback callback) {
        String url = GlobalConsts.URL_LOAD_RECOMMEND_BOOK_LIST;
        StringRequest request = new StringRequest(StringRequest.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.getInt("code");
                    if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        JSONArray array = object.getJSONArray("data");
                        List<Book> books = JSONParser.parseBookList(array);
                        Log.i("lee",books.toString());
                        callback.onSucess(books);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("lee","error"+error.getMessage());
            }
        });
        queue.add(request);
    }

    @Override
    public void getHotList(final IModel.AsyncCallback callback) {
        String url = GlobalConsts.URL_LOAD_HOT_BOOK_LIST;
        StringRequest request = new StringRequest(StringRequest.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.getInt("code");
                    if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        JSONArray array = object.getJSONArray("data");
                        List<Book> books = JSONParser.parseBookList(array);
                        Log.i("lee",books.toString());
                        callback.onSucess(books);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("lee","error"+error.getMessage());
            }
        });
        queue.add(request);
    }

    @Override
    public void getNewList(final IModel.AsyncCallback callback) {
        String url = GlobalConsts.URL_LOAD_NEW_BOOK_LIST;
        StringRequest request = new StringRequest(StringRequest.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    int code = object.getInt("code");
                    if(code==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        JSONArray array = object.getJSONArray("data");
                        List<Book> books = JSONParser.parseBookList(array);
                        Log.i("lee",books.toString());
                        callback.onSucess(books);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("lee","error"+error.getMessage());
            }
        });
        queue.add(request);
    }
}
