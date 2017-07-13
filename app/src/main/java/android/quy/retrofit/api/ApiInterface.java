package android.quy.retrofit.api;

import android.quy.retrofit.model.Example;
import android.quy.retrofit.model.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by iamme on 17/06/12.
 */

public interface ApiInterface {
    @GET("/{list-user}")
    Call<List<Example>> getUsers(@Path("list-user") String listUser);

    @GET("users/{id}")
    Call<Example> getUsersId(@Path("id") int id);
}
