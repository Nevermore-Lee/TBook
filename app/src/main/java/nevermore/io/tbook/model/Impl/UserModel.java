package nevermore.io.tbook.model.Impl;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.User;
import nevermore.io.tbook.model.IUserModel;
import nevermore.io.tbook.util.CommonRequest;
import nevermore.io.tbook.util.GlobalConsts;

/**
 * Created by Administrator on 2016/6/28.
 */
public class UserModel implements IUserModel {
    private RequestQueue queue;

    public UserModel() {
        this.queue = Volley.newRequestQueue(MyApplication.getContext());
    }

    @Override
    public void login(String loginame, String password, AsyncCallback callback) {

    }

    @Override
    public void regist(User user, String code, final AsyncCallback callback) {
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
        });
        queue.add(request);
    }

    @Override
    public void getImageCode(AsyncCallback callback) {
        String uri = GlobalConsts.URL_GET_IMAGE_CODE;
        ImageRequest request = new ImageRequest(uri, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

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
    }

    @Override
    public void loginWithoutPwd(String token, AsyncCallback callback) {

    }
}
