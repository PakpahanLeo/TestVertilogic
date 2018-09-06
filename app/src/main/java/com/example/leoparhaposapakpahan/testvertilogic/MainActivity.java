package com.example.leoparhaposapakpahan.testvertilogic;

import android.app.ProgressDialog;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Data> movieList;
    private RecyclerView.Adapter adapter;

    private String url = "http://jsonplaceholder.typicode.com/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = findViewById(R.id.main_list);

        movieList = new ArrayList<>();
        adapter = new ShowAdapter(getApplicationContext(),movieList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        getData();
    }


    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Data movie = new Data();
                        movie.setId(jsonObject.getString("id"));
                        movie.setName(jsonObject.getString("name"));
                        movie.setUsername(jsonObject.getString("username"));
                        movie.setEmail(jsonObject.getString("email"));



                        // Address node is JSON Object
                        JSONObject address = jsonObject.getJSONObject("address");
                        movie.setStreet(address.getString("street"));
                        movie.setSuite(address.getString("suite"));
                        movie.setCity(address.getString("city"));
                        movie.setZipcode(address.getString("zipcode"));

                        // Geo node is JSON Object
                        JSONObject geo = address.getJSONObject("geo");
                        movie.setLat(geo.getString("lat"));
                        movie.setLng(geo.getString("lng"));


                        movie.setPhone(jsonObject.getString("phone"));
                        movie.setWebsite(jsonObject.getString("website"));


                        // Company node is JSON Object
                        JSONObject company = jsonObject.getJSONObject("company");
                        movie.setCompany_name(company.getString("name"));
                        movie.setCatchPhrase(company.getString("catchPhrase"));
                        movie.setBs(company.getString("bs"));


                        movieList.add(movie);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

}
