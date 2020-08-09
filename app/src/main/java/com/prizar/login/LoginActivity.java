package com.prizar.login;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;

import com.prizar.ActivityHome;
import com.prizar.R;
import com.prizar.base.BaseActivity;
import com.prizar.model.login.LoginResult;
import com.prizar.networks.APIService;
import com.prizar.networks.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    //Post example

    private EditText mEmail;
    private EditText mPass;
    private Button mLoginButton;
    //private TextView mResponse;
    private APIService mApiService;
    RelativeLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEmail = findViewById(R.id.et_email);
        mPass = findViewById(R.id.et_pass);
        mLoginButton = findViewById(R.id.btn_sgnin);
        main = (RelativeLayout) findViewById(R.id.main);
        mApiService = ApiUtils.getApiService();

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboardwithoutPopulate(LoginActivity.this);
            }
        });

    }
    public static void hideKeyboardwithoutPopulate(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
    public void postData(View view) {
        String sEmail = mEmail.getText().toString().trim();
        String sPass = mPass.getText().toString().trim();
        if (sEmail.length() == 0 || sPass.length() == 0) {
            Toast.makeText(LoginActivity.this, "Email & Password Fields are must not empty ", Toast.LENGTH_SHORT).show();
        } else {
            sendPost(sEmail, sPass);
        }


    }

    public void sendPost(final String sEmail, final String sPass) {
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(LoginActivity.this);
        progressDoalog.setMessage("Please Wait....");
        progressDoalog.show();
        mApiService.saveData(sEmail, sPass, "eqwe", "qweqw").enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                progressDoalog.dismiss();
                try {
                    //  mResponse.setText(response.body().getData().getName() + " ".concat(response.body().getData().getToken() + " ").concat(response.body().getData().getId().toString() + " ").concat(response.body().getData().toString()) + " ");
                    SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                    String auth_token = response.body().getData().getToken();
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("auth_token", auth_token);
                    myEdit.commit();
                    Intent login = new Intent(LoginActivity.this, ActivityHome.class);
                    startActivity(login);
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                } catch (Throwable e) {

                    Toast.makeText(LoginActivity.this, "Email or Password wrong!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(LoginActivity.this, "Email or Password wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
