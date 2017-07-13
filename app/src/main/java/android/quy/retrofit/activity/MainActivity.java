package android.quy.retrofit.activity;

import android.quy.retrofit.R;
import android.quy.retrofit.adapter.MoviesAdapter;
import android.quy.retrofit.api.ApiClient;
import android.quy.retrofit.api.ApiInterface;
import android.quy.retrofit.model.Example;
import android.quy.retrofit.model.Movie;
import android.quy.retrofit.model.Results;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Example>> call = apiService.getUsers(API_KEY);
        call.enqueue(new Callback<List<Example>>() {


            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                int resultCode = response.code();
                List<Example> examples = new ArrayList<Example>();
                for(int i=0;i<response.body().size();i++){
                    examples.add(response.body().get(i));
                }
                recyclerView.setAdapter(new MoviesAdapter(examples,getBaseContext()));


            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.e(TAG, t.toString());
            }


        });
    }
}
