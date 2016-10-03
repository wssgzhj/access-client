package me.zijian.accessclient.core;

import me.zijian.accessclient.model.FingerprintInfo;

/**
 * 指纹识别服务类
 */
public class FingerprintHelper {

    private static FingerprintHelper sInstance;

    private FingerprintHelper() {
    }

    public static FingerprintHelper getInstance() {
        if (sInstance == null) {
            synchronized (FingerprintHelper.class) {
                if (sInstance == null) {
                    sInstance = new FingerprintHelper();
                }
            }
        }
        return sInstance;
    }

    /**
     * TODO 获取指纹信息
     */
    public void obtainFingerprintInfo(final Callback callback){

    }

    public interface Callback {
        void onStart();
        void onSuccess(FingerprintInfo fingerprintInfo);
        void onFailure();
    }

}
