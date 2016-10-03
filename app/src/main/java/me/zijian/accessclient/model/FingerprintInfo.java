package me.zijian.accessclient.model;

import java.io.Serializable;

/**
 * 指纹信息
 */
public class FingerprintInfo implements Serializable {

    private static final long serialVersionUID = 5578178170319724299L;

    // 指纹
    private String fingerprint;
    // 用户名
    private String userName;
    // 哈希迭代次数
    private int hashTimes;

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getHashTimes() {
        return hashTimes;
    }

    public void setHashTimes(int hashTimes) {
        this.hashTimes = hashTimes;
    }
}
