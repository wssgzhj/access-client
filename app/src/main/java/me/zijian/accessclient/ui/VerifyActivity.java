package me.zijian.accessclient.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import me.zijian.accessclient.R;

public class VerifyActivity extends BaseActivity {

    public static void launch(Context context){
        Intent intent = new Intent(context, VerifyActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        ButterKnife.bind(this);
    }

}
