package com.example.user.laundress2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ClientLaundryDetails extends AppCompatActivity {

    ArrayList<String> arrname = new ArrayList<>();
    ArrayList<Integer> arrid = new ArrayList<>();

    //  ListView listview;
    private Context context;
    private static final String URL_ALL ="http://192.168.254.117/laundress/detailscategory.php";
    ArrayList<LaundryDetailList> laundryDetailLists = new ArrayList<LaundryDetailList>();
    LaundryDetailsAdapter laundryDetailsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientlaundrydet);
        GridView androidGridView = findViewById(R.id.gridview);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),AddLaundryDetails.class);
                intent.putExtra("name",laundryDetailLists.get(position).getName());
                intent.putExtra("id",laundryDetailLists.get(position).getId());
                //intent.putExtra("image",laundryDetailId[position]);
                startActivity(intent);
            }
        });
        try {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_ALL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            getJsonResponse(response);
                            System.out.println("RESPONSEesponse");
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
                        }
                    });

            RequestQueue requestQueue = Volley.newRequestQueue(ClientLaundryDetails.this);
            requestQueue.add(stringRequest);
        }
        catch (Exception e)
        {

        }
        laundryDetailsAdapter = new LaundryDetailsAdapter(ClientLaundryDetails.this,laundryDetailLists);
        androidGridView.setAdapter(laundryDetailsAdapter);
    }

    private void getJsonResponse(String response)
    {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String success = jsonObject.getString("success");
            //JSONArray jArray = json.getJSONArray("platform");
            //JSONArray jsonArray = new JSONArray(response);
            JSONArray jsonArray = jsonObject.getJSONArray("category");
            if (success.equals("1")){
                for (int i =0;i<jsonArray.length();i++)
                {
                    String name=jsonArray.getJSONObject(i).getString("name").toString();
                    int id= Integer.parseInt(jsonArray.getJSONObject(i).getString("id").toString());
                    arrname.add(name);
                    arrid.add(id);
                    LaundryDetailList laundryDetailList = new LaundryDetailList();
                    laundryDetailList.setName(name);
                    laundryDetailList.setId(id);
                    laundryDetailLists.add(laundryDetailList);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(ClientLaundryDetails.this, "failedddd" +e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}