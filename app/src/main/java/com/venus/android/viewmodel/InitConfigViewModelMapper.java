package com.venus.android.viewmodel;

import android.text.TextUtils;

import com.venus.android.data.entity.InitConfigEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;


public class InitConfigViewModelMapper {
    public static InitConfigViewModel transfer(InitConfigEntity initConfigEntity) {
        InitConfigViewModel initConfigViewModel = new InitConfigViewModel();
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(initConfigEntity.getExtra().getStart_page());
            initConfigViewModel.startPageUrl = jSONObject.getString("img_url");
            initConfigViewModel.startPageDelayTime = (long) (Integer.parseInt(jSONObject.getString("time")) * 1000);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jSONObject = new JSONObject(initConfigEntity.getExtra().getImportant_notice());
            String string = jSONObject.getString("content");
            if (!TextUtils.isEmpty(string)) {
                initConfigViewModel.notifyMessage = string + "          ";
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            initConfigViewModel.notifyMessageStartTime = simpleDateFormat.parse(jSONObject.getString("start_time"));
            initConfigViewModel.notifyMessageEndTime = simpleDateFormat.parse(jSONObject.getString("end_time"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject = new JSONObject(initConfigEntity.getExtra().getHome_banner());
            JSONArray jSONArray = jSONObject.getJSONArray("imgs");
            initConfigViewModel.bannerImgUrls = new String[jSONArray.length()];
            initConfigViewModel.bannerClickJumpUrls = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i));
                initConfigViewModel.bannerImgUrls[i] = jSONObject2.getString("img");
                initConfigViewModel.bannerClickJumpUrls[i] = jSONObject2.getString("click_url");
            }
            initConfigViewModel.bannerDelayTime = (long) (Integer.parseInt(jSONObject.getString("time")) * 1000);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return initConfigViewModel;
    }
}
