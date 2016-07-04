package nevermore.io.tbook.model.Impl;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nevermore.io.tbook.app.MyApplication;
import nevermore.io.tbook.entity.Address;
import nevermore.io.tbook.model.IAddressModel;
import nevermore.io.tbook.util.CommonRequest;
import nevermore.io.tbook.util.GlobalConsts;
import nevermore.io.tbook.util.JSONParser;

/**
 * Created by Lee on 2016/7/4.
 */
public class AddressModel implements IAddressModel{
    private RequestQueue queue;
    private MyApplication application;

    public AddressModel() {
        application = MyApplication.getContext();
        queue = application.getQueue();
    }

    @Override
    public void saveAddress(final Address address, final AsyncCallback callback) {
        String url= GlobalConsts.URL_SAVE_ADDRESS;
        CommonRequest request = new CommonRequest(Request.Method.POST,url,new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    if(obj.getInt("code")==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        callback.onSucess(null);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> resultMap = new HashMap<String, String>();
                resultMap.put("address.receiveName",address.getReceiveName());
                resultMap.put("address.full_address",address.getFull_address());
                resultMap.put("address.postalCode",address.getPostalCode());
                resultMap.put("address.mobile",address.getMobile());
                resultMap.put("address.phone",address.getPhone());
                return resultMap;
            }
        };
        queue.add(request);
    }

    @Override
    public void listAddress(final AsyncCallback callback) {
        String url=GlobalConsts.URL_LOAD_USER_ADDRESS;
        CommonRequest request = new CommonRequest(url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getInt("code")==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        JSONArray ary = jsonObject.getJSONArray("data");
                        List<Address> adds= JSONParser.parseAddress(ary);
                        callback.onSucess(adds);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }

    @Override
    public void setDefault(final int id, final AsyncCallback callback) {
        String url=GlobalConsts.URL_SET_ADDRESS_DEFAULT+"?id="+id;
        CommonRequest request = new CommonRequest(url, new Response.Listener<String>() {
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    if(jsonObject.getInt("code")==GlobalConsts.RESPONSE_CODE_SUCCESS){
                        callback.onSucess(null);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }
}
