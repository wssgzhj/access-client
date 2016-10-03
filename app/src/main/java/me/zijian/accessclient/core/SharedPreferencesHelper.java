package me.zijian.accessclient.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import me.zijian.accessclient.MyApplication;
import me.zijian.accessclient.model.FingerprintInfo;

public class SharedPreferencesHelper {

    private static String FILE_NAME = "sp_access_client";

    private static SharedPreferencesHelper sInstance;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private SharedPreferencesHelper() {
        Context context = MyApplication.getContext();
        if (Build.VERSION.SDK_INT > 10) {
            mSharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_MULTI_PROCESS);
        } else {
            mSharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        }
        mEditor = mSharedPreferences.edit();
    }

    public static SharedPreferencesHelper getInstance() {
        if (sInstance == null) {
            synchronized (SharedPreferencesHelper.class) {
                if (sInstance == null) {
                    sInstance = new SharedPreferencesHelper();
                }
            }
        }
        return sInstance;
    }

    /**
     * 保存指纹信息
     *
     * @param fingerprintInfo 指纹信息
     */
    public void setFingerprintInfo(FingerprintInfo fingerprintInfo) {
        if (fingerprintInfo != null) {
            mEditor.putString("fingerprintInfo", new Gson().toJson(fingerprintInfo));
            mEditor.commit();
        }
    }

    /**
     * 获取保存的指纹信息
     *
     * @return 指纹信息
     */
    public FingerprintInfo getFingerprintInfo() {
        FingerprintInfo fingerprintInfo = null;
        try {
            String fingerprintInfoStr = mSharedPreferences.getString("fingerprintInfo", "");
            fingerprintInfo = new Gson().fromJson(fingerprintInfoStr, FingerprintInfo.class);
        } catch (JsonSyntaxException e) {
        }
        if (fingerprintInfo == null) {
            fingerprintInfo = new FingerprintInfo();
        }
        return fingerprintInfo;
    }

    /**
     * 清除指纹信息
     */
    public void removeFingerprintInfo() {
        mEditor.remove("fingerprintInfo");
        mEditor.commit();
    }

}
