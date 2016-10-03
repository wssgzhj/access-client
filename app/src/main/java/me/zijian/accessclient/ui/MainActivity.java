package me.zijian.accessclient.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.zijian.accessclient.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_register)
    void register(){
        RegisterActivity.launch(this);
    }

    @OnClick(R.id.btn_verify)
    void verify(){
        VerifyActivity.launch(this);
    }

}
