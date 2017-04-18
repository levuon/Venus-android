package com.venus.android.data.network.request;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseRequest {
    public Map<String, Object> transferToMap() throws JSONException {
        return jsonToMap(new Gson().toJson((Object) this));
    }

    private Map jsonToMap(String str) throws JSONException {
        Map hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str2 = (String) keys.next();
            String obj = jSONObject.get(str2).toString();
            if (obj.startsWith("{") && obj.endsWith("}")) {
                hashMap.put(str2, jsonToMap(obj));
            } else {
                hashMap.put(str2, obj);
            }
        }
        return hashMap;
    }
}
