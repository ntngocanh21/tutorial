package com.a14tclc.ngocanh.tutorial.view.activity.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.a14tclc.ngocanh.tutorial.R;
import com.a14tclc.ngocanh.tutorial.service.APIClient;
import com.a14tclc.ngocanh.tutorial.service.APILogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements LoginView{
    @BindView(R.id.username)
    EditText edtUsername;

    @BindView(R.id.password)
    EditText edtPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void onClick() {
        LoginPresenterImpl loginPresenterImpl = new LoginPresenterImpl(this);
        loginPresenterImpl.login(edtUsername.getText().toString(), edtPassword.getText().toString());
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
