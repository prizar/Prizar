package com.prizar.drawsearch;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.prizar.R;
import com.prizar.base.BaseActivity;
import com.prizar.model.draws.DrawDateResult;
import com.prizar.model.draws.DrawsDateList;
import com.prizar.model.drawsearch.DrawList;
import com.prizar.model.drawsearch.DrawSearchResult;
import com.prizar.networks.APIService;
import com.prizar.networks.ApiUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuickSearchActivity extends BaseActivity  {
    RelativeLayout main;
    RelativeLayout multiple_bond, range_search;
    ArrayList<Model> models = new ArrayList<Model>();
    ArrayList<DrawList> drawList = new ArrayList<DrawList>();
    RecyclerView rvTechSolPoint,rv_bondlist;
    RvAdapter rvAdapter;
    BondListAdapter bondListAdapter;
    DrawDateListAdapter drawDateListAdapter;
    Button btnAdd, btnUpdate,btnproceed;
   // Button btnclear;
    EditText et_multiple_bond,et_to,et_from;
    ProgressBar progressbar;
    String search_type;
    Spinner draw_date;
    List<DrawsDateList> dataList=new ArrayList();
    String denominations,denominations_id;
    int position;
    private APIService mApiService;
   // List<DrawList> drawList;
    protected DrawSearchResult adapter;

    //RelativeLayout adder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_search);
        range_search = (RelativeLayout) findViewById(R.id.range_search);
        multiple_bond = (RelativeLayout) findViewById(R.id.multiple_bond);
        progressbar=findViewById(R.id.progressBar);
        rvTechSolPoint = findViewById(R.id.rv_list_item);
        rv_bondlist = findViewById(R.id.rv_bondlist);
        btnAdd = findViewById(R.id.add);

        draw_date=(Spinner) findViewById(R.id.draw_date);
//        btnclear = findViewById(R.id.clear);
        et_multiple_bond = findViewById(R.id.et_multiple_bond);
        et_to = findViewById(R.id.et_to_search);
        et_from = findViewById(R.id.et_from_search);
        btnUpdate = findViewById(R.id.update);
        btnproceed=findViewById(R.id.btn_add);
        mApiService = ApiUtils.getApiService();


        Spinner denominations_search;
        denominations_search = (Spinner) findViewById(R.id.denominations_search);
        List<String> dominations = new ArrayList<String>();
        dominations.add("Select Denomination");
        dominations.add("100Rs");
        dominations.add("200Rs");
        dominations.add("750Rs");
        dominations.add("1500Rs");
        dominations.add("7500Rs");
        dominations.add("15000Rs");
        dominations.add("25000Rs");
        dominations.add("40000Rs");
        dominations.add("40000Rs Premium Bond");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, dominations);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        denominations_search.setAdapter(dataAdapter);
        denominations_search.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (position == 1) {
                    Toast.makeText(QuickSearchActivity.this, "100 bond selected", Toast.LENGTH_SHORT).show();
                    multiple_bond.setVisibility(View.GONE);
                    range_search.setVisibility(View.VISIBLE);
                    denominations="100";
                    denominations_id="1";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="200";
                    denominations_id="2";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }
                else if (position == 3) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="750";
                    denominations_id="3";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }
                else if (position == 4) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="1500";
                    denominations_id="3";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }else if (position == 5) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="7500";
                    denominations_id="4";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }else if (position == 6) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="15000";
                    denominations_id="5";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }
                else if (position == 7) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="25000";
                    denominations_id="6";
                    showList(denominations_id);

                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }
                else if (position == 8) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="40000";
                    denominations_id="7";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }
                else if (position == 9) {
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    denominations="40000";
                    denominations_id="8";
                    showList(denominations_id);
                    Toast.makeText(QuickSearchActivity.this,denominations+" bond selected", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(QuickSearchActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();

            }

        });

        //recycler setting
//        rvTechSolPoint.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//        rvTechSolPoint.setLayoutManager(layoutManager);
//        rvAdapter = new RvAdapter(getApplicationContext(), models,
//                new RvAdapter.Onclick() {
//                    @Override
//                    public void onEvent(Model model, int pos) {
//                        position = pos;
//                        btnUpdate.setVisibility(View.VISIBLE);
//                        et_multiple_bond.setText(model.getName());
//                        btnclear.setVisibility(View.GONE);
//                    }
//                });
//        rvTechSolPoint.setAdapter(rvAdapter);
        //recycler setting


     //   btnproceed.setOnClickListener(this);
//        btnAdd.setOnClickListener(this);
//        btnUpdate.setOnClickListener(this);
//        btnclear.setOnClickListener(this);

        //sppinerr setting





        final List<String> drawdate = new ArrayList<String>();
        drawdate.add("Select Draw Date");
        drawdate.add(""+dataList);
        ArrayAdapter<String> drawdateAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, drawdate);
        drawdateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        draw_date.setAdapter(drawdateAdapter);
        draw_date.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (position == 0) {

                    Toast.makeText(QuickSearchActivity.this,"date selected", Toast.LENGTH_SHORT).show();
                } else if (position == 1) {

                    Toast.makeText(QuickSearchActivity.this," date selected", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(QuickSearchActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();

            }

        });






        final Spinner ss_option = (Spinner) findViewById(R.id.ss_options);
        List<String> option = new ArrayList<String>();
        option.add("Range Search");
        option.add("Multiple Bond Search");
        ArrayAdapter<String> optionAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, option);
        optionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ss_option.setAdapter(optionAdapter);
        final String selected = ss_option.getSelectedItem().toString();
        ss_option.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (position == 0) {
                    Toast.makeText(QuickSearchActivity.this, "Range Search Selected", Toast.LENGTH_SHORT).show();
                    multiple_bond.setVisibility(View.GONE);
                    range_search.setVisibility(View.VISIBLE);
                    search_type="1";
                    //Toast.makeText(QuickSearchActivity.this, search_type, Toast.LENGTH_SHORT).show();
                } else if (position == 1) {
                    Toast.makeText(QuickSearchActivity.this, "Multiple Bond Search Selected", Toast.LENGTH_SHORT).show();
                    range_search.setVisibility(View.GONE);
                    multiple_bond.setVisibility(View.VISIBLE);
                    search_type="2";
                    //Toast.makeText(QuickSearchActivity.this, search_type, Toast.LENGTH_SHORT).show();
                    //adder.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(QuickSearchActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();

            }

        });
        //hide keyboard
//        main = (RelativeLayout) findViewById(R.id.main);
//        main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hideKeyboardwithoutPopulate(QuickSearchActivity.this);
//            }
//        });

    }


    private void  initializeDateRecyclerView(List<DrawsDateList> data) {

        LinearLayoutManager ListlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_bondlist.setLayoutManager(ListlayoutManager);
        drawDateListAdapter = new DrawDateListAdapter(this, data);
        rv_bondlist.setAdapter(drawDateListAdapter);
    }
    public void showList(final String denomination_id) {

        progressbar.setVisibility(View.VISIBLE);
        mApiService.saveList(denomination_id).enqueue(new Callback<DrawDateResult>() {
            @Override
            public void onResponse(Call<DrawDateResult> call, Response<DrawDateResult> response) {
                progressbar.setVisibility(View.GONE);
                try {
                    if (response.body().getStatus().equals("success")) {

                        dataList=response.body().getData();
                        initializeDateRecyclerView(dataList);
                       // drawdate.add(data);
                       // Toast.makeText(QuickSearchActivity.this,"+" data, Toast.LENGTH_SHORT).show();
                       // response.body().getData();
                      //  et_from.setText(""+data);
                        //et_multiple_bond.setText(""+data);
                        et_multiple_bond.setText("list is coming to me"+response.body().getMessage());
                    } else {
                        Toast.makeText(QuickSearchActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } catch (Throwable e) {

                    Toast.makeText(QuickSearchActivity.this, "You have entered something wrong!", Toast.LENGTH_SHORT).show();
                }
            }

            //run and show me the list of both postman and code??????????

            @Override
            public void onFailure(Call<DrawDateResult> call, Throwable t) {
                //progressDoalog.dismiss();
                progressbar.setVisibility(View.GONE);
                Toast.makeText(QuickSearchActivity.this, "You have entered something wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }











//    public static void hideKeyboardwithoutPopulate(Activity activity) {
//        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
//    }

//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.add: {
//                insertMethod(String.valueOf(et_multiple_bond.getText()));
//            }
//            break;
//            case R.id.update: {
//                models.get(position).setName(et_multiple_bond.getText().toString());
//                rvAdapter.notifyDataSetChanged();
//                btnUpdate.setVisibility(View.GONE);
//                btnclear.setVisibility(View.VISIBLE);
//            }
//            break;
//            case R.id.clear: {
//               // et_multiple_bond.setText("");
//              //  listInsertMethod(String.valueOf(et_to.getText()),String.valueOf(et_from.getText()),String.valueOf(et_multiple_bond.getText()),String.valueOf(et_multiple_bond.getText()));
//               // listInsertMethod("s","ddsd","sdsd","sdsd");
//            }
//
//            break;
//        }
//    }
    private void  initializeRecyclerView(List<DrawList> data) {

        LinearLayoutManager ListlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_bondlist.setLayoutManager(ListlayoutManager);
        bondListAdapter = new BondListAdapter(this, data);
        rv_bondlist.setAdapter(bondListAdapter);
    }

    public void postData(View view) {
        String draw_id = "1";
        String denomination_id = denominations;
        String search_type =getSearchtype();
        String from = null;
        String to = null;
        String comma_seperated = null;
        if(getSearchtype()=="1")
      {
         from =et_from.getText().toString();
        to = et_to.getText().toString();
       comma_seperated ="";}
       else if(getSearchtype()=="2")
       {  from ="";
          to = "";
          comma_seperated =et_multiple_bond.getText().toString();
       }
        sendPost(draw_id, denomination_id, search_type, from, to, comma_seperated);

    }
    public String getSearchtype() {
        return search_type;
    }
    public void sendPost(final String draw_id, final String denomination_id, final String search_type, final String from, final String to, final String comma_seperated) {

       progressbar.setVisibility(View.VISIBLE);
        mApiService.saveData(draw_id, denomination_id, search_type, from, to, comma_seperated).enqueue(new Callback<DrawSearchResult>() {
            @Override
            public void onResponse(Call<DrawSearchResult> call, Response<DrawSearchResult> response) {
                //progressDoalog.dismiss();
                progressbar.setVisibility(View.GONE);
                try {
                    if (response.body().getStatus().equals("success")) {
                       List<DrawList> data=new ArrayList();
                        data=response.body().getData();
                  //  String count= String.valueOf(data.size());
                        initializeRecyclerView(data);
                       // Toast.makeText(QuickSearchActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        et_from.setText(response.body().getMessage());
                    } else {
                       Toast.makeText(QuickSearchActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } catch (Throwable e) {

                    Toast.makeText(QuickSearchActivity.this, "You have entered something wrong!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DrawSearchResult> call, Throwable t) {
                //progressDoalog.dismiss();
                progressbar.setVisibility(View.GONE);
                Toast.makeText(QuickSearchActivity.this, "You have entered something wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}