package com.example.automaticelectricfaultdetectingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    ListView listView;
    ProgressDialog progressDoalog;
     CurrentValue currentValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getCurrentField();

        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
    }

    private void getCurrentField(){

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(GetCurrent.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();

        GetCurrent api = RetrofitClientInstance.getRetrofitInstance().create(GetCurrent.class); // retrofit.create(GetCurrent.class);
        Call<CurrentFeeds> call = api.getCurrentField();

        call.enqueue(new Callback<CurrentFeeds>() {
            @Override
            public void onResponse(Call<CurrentFeeds> call, Response<CurrentFeeds> response) {
                Log.d("MainActivity","onResponse is running" );

                Log.v(TAG, "Response Body ==>" +response.body());

                Toast.makeText(MainActivity.this, "onResponse(Call<CurrentFeeds> call, Response<CurrentFeeds> response)", Toast.LENGTH_SHORT).show();

                progressDoalog.dismiss();
                List<CurrentValue> feedList = new ArrayList();
                feedList = response.body().getFeeds();

                String [] displayList = new String[feedList.size()];
//                String[] noCurrentValue = {"No current value","No current value"};

                for (int i = 0; i < feedList.size(); i++){
                    if (feedList.get(i).getField1() != null) {
                        displayList[i] = feedList.get(i).getField1();
                        Log.v(TAG, "Feed Value ==>" + displayList[i]);
                    }else
                        displayList[i] = "No current value";
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, displayList);
                listView = findViewById(R.id.display_screen);
                listView.setAdapter(arrayAdapter);



            }

            @Override
            public void onFailure(Call<CurrentFeeds> call, Throwable t) {
                Log.d("MainActivity"," onFailure is running" );
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.status_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                getCurrentField();
                return true;
            case R.id.menu2:
                Toast.makeText(this,"Option not available",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu3:
                Toast.makeText(this,"Option not available",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu4:
                Toast.makeText(this,"Option not available",Toast.LENGTH_SHORT).show();
                return true;
            default:
            return super.onOptionsItemSelected(item);
        }
    }
}