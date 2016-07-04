package nevermore.io.tbook.model.Impl;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.User;
import nevermore.io.tbook.model.IUserModel;
import nevermore.io.tbook.util.CommonRequest;
import nevermore.io.tbook.util.GlobalConsts;
import nevermore.io.tbook.util.JSONParser;

/**
 * Created by Lee on 2016/6/28.
 */
public class UserModel implements IUserModel {
    private RequestQueue queue;

    public UserModel() {
        this.queue = MyApplication.getContext().getQueue();
    }

    @Override
    public void login(final String loginame, final String password, final AsyncCallback callback) {
        final String url = GlobalConsts.URL_USER_LOGIN;
        CommonRequest request = new CommonRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//              解析res
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getInt("code")==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        JSONObject userObj=jsonObject.getJSONObject("user");
                        MyApplication app = MyApplication.getContext();
                        app.saveCurrentUser(JSONParser.parseUser(userObj));
                        //持久化保存token，免登录
                        String token = jsonObject.getString("token");
                        app.saveToken(token);
                        callback.onSucess(null);
                        Log.i("lee","UserModel");
                    }else {
                        callback.onError(jsonObject.getString("error_msg"));
                        Log.i("lee","UserModelError");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onError("登陆失败");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", loginame);
                params.put("password", password);
                return params;
            }
        };
        queue.add(request);
    }

    @Override
    public void regist(final User user, final String code, final AsyncCallback callback) {
        String url = GlobalConsts.URL_USER_REGIST;
        CommonRequest request = new CommonRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                解析res
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.getInt("code") == GlobalConsts.RESPONSE_CODE_SUCCESS) {
                        callback.onSucess(null);
                    } else {
                        callback.onError(jsonObject.getString("erro_msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("user.email", user.getEmail());
                map.put("user.nickname", user.getNickname());
                map.put("user.password", user.getPassword());
                map.put("number", code);
                return map;
            }
        };
        queue.add(request);
    }

    @Override
    public void getImageCode(final AsyncCallback callback) {
        String uri = GlobalConsts.URL_GET_IMAGE_CODE;
        ImageRequest request = new ImageRequest(uri, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                    callback.onSucess(response);
            }
        }, 130, 50, ImageView.ScaleType.CENTER_INSIDE, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Response<Bitmap> parseNetworkResponse(NetworkResponse response) {
                Map<String, String> headers = response.headers;
                String sessionid = headers.get("Set-Cookie");
                if (sessionid != null) {
                    CommonRequest.JSESSIONID = sessionid.split(";")[0];
                }
                return super.parseNetworkResponse(response);
            }
        };
        queue.add(request);
    }

    @Override
    public void loginWithoutPwd(String token, final AsyncCallback callback) {
        String url = GlobalConsts.URL_USER_LOGIN_WITHOUT_PWD +"?token=" + token;
        CommonRequest request = new CommonRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if(jsonObject.getInt("code")==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        JSONObject userObj = jsonObject.getJSONObject("user");
                        MyApplication app = MyApplication.getContext();
                        app.saveCurrentUser(JSONParser.parseUser(userObj));
                        Log.i("lee","loginWithoutPwd"+userObj.toString());
                        callback.onSucess(response);
                    }else {
                        Log.i("lee","loginWithoutPwd");
                        callback.onError(response);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

    }
}
