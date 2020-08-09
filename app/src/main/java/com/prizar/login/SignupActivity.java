package com.prizar.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.prizar.R;
import com.prizar.model.login.SignupResult;
import com.prizar.networks.APIService;
import com.prizar.networks.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    RelativeLayout main;
    EditText et_full_name,et_email, et_phone,et_pass,et_confrim_pass;
    TextView btn_login;
    Button btn_create;
    private APIService mApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        et_full_name = (EditText) findViewById(R.id.et_full_name);
        et_email = (EditText) findViewById(R.id.et_email);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_pass = (EditText) findViewById(R.id.et_pass);
        et_confrim_pass = (EditText) findViewById(R.id.et_confrim_pass);
        btn_login = (TextView) findViewById(R.id.btn_login);
        btn_create = (Button) findViewById(R.id.btn_create);
        main = (RelativeLayout) findViewById(R.id.main);
        mApiService = ApiUtils.getApiService();

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboardwithoutPopulate(SignupActivity.this);
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
    String sFullname = et_full_name.getText().toString().trim();
    String sEmail = et_email.getText().toString().trim();
    String sPhone = et_phone.getText().toString().trim();
    String sPass = et_pass.getText().toString().trim();
    String sConfrimpass = et_confrim_pass.getText().toString().trim();
    if (sFullname.length() == 0 || sEmail.length() == 0|| sPhone.length() == 0|| sPass.length() == 0|| sConfrimpass.length() == 0)
    {
        Toast.makeText(SignupActivity.this, "Please Fill all the Fields", Toast.LENGTH_SHORT).show();
    }
    else {
        sendPost(sFullname, sEmail,sPhone,sPass,sConfrimpass);
    }


}

    public void sendPost(final String sFullname, final String sEmail, final String sPhone, final String sPass, final String sConfrimpass) {

        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(SignupActivity.this);
        progressDoalog.setMessage("Please Wait....");
        progressDoalog.show();
        mApiService.saveData(sFullname, sEmail, sPhone, sPass,sConfrimpass).enqueue(new Callback<SignupResult>() {
            @Override
            public void onResponse(Call<SignupResult> call, Response<SignupResult> response) {
                progressDoalog.dismiss();
                try {
                    if(response.body().getStatus().equals("success"))
                    {
                        Toast.makeText(SignupActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                } catch (Throwable e) {

                    Toast.makeText(SignupActivity.this, "You have entered something wrong!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignupResult> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(SignupActivity.this, "You have entered something wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}