package me.zijian.accessclient.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zijian.accessclient.R;
import me.zijian.accessclient.core.FingerprintHelper;
import me.zijian.accessclient.model.FingerprintInfo;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.tv_status)
    TextView mTvStatus;
    @BindView(R.id.btn_send)
    Button mBtnSend;

    private FingerprintInfo mFingerprintInfo;

    public static void launch(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mBtnSend.setEnabled(false);
        initFingerprintServer();
    }

    private void initFingerprintServer() {
        FingerprintHelper.getInstance().obtainFingerprintInfo(new FingerprintHelper.Callback() {
            @Override
            public void onStart() {
                mBtnSend.setEnabled(false);
                mTvStatus.setText("正在识别...");
            }

            @Override
            public void onSuccess(FingerprintInfo fingerprintInfo) {
                mBtnSend.setEnabled(true);
                mTvStatus.setText("识别成功");
            }

            @Override
            public void onFailure() {
                mBtnSend.setEnabled(false);
                mTvStatus.setText("识别失败");
            }
        });
    }

    @OnClick(R.id.btn_send)
    void send() {
        if(mFingerprintInfo == null){
            return;
        }
        // TODO NFC 传输
    }

}
