package com.prizar;

import android.os.Bundle;

import com.prizar.base.BaseActivity;

public class example_main extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_main);
        ExampleFragment fragment = ExampleFragment.newInstance("example text ", 123);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}