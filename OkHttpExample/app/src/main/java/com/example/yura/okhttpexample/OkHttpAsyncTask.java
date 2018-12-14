package com.example.yura.okhttpexample;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpAsyncTask extends AsyncTask<URI, Void, ArrayList<RepositoryEntity>> {
    private Callback callback;

    @Override
    protected ArrayList<RepositoryEntity> doInBackground(URI... uris) {
        Request request = new Request.Builder()
                .get()
                .url("https://api.github.com/repositories")
                .build();
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();

            String jsonResponse = response.body().string();
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<RepositoryEntity>>() {}.getType();
            ArrayList<RepositoryEntity> repositories = gson.fromJson(jsonResponse, listType);
            return repositories;
        } catch (IOException exception) {
            Log.e("!!!", exception.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(ArrayList<RepositoryEntity> repositoryEntities) {
        super.onPostExecute(repositoryEntities);
        RepositoryEntityList.initsializeList(repositoryEntities);
        callback.doChanges();
    }

    void setCallback(Callback callback){
        this.callback=callback;
    }

    interface Callback{
        void doChanges();
    }
}
