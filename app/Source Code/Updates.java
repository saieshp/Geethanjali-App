package com.gctc.saiesh.geethanjali;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Updates extends Fragment
{
    private static final String TAG = Updates.class.getSimpleName();
    private List<Feeds> feedsList;
    private GridLayoutManager gridLayout;
    private FeedsAdapter adapter;


    SweetAlertDialog dialog;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.rfs, container, false);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        feedsList = new ArrayList<>();
        feeddb(0);

        gridLayout = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayout);

        adapter = new FeedsAdapter(getContext(), feedsList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {

                if (gridLayout.findLastCompletelyVisibleItemPosition() == feedsList.size())
                {
                    feeddb(feedsList.get(feedsList.size() ).getId());
                }

            }
        });


        return view;
    }

    private void feeddb(int id)
    {

        AsyncTask<Integer, Void, Void> asyncTask = new AsyncTask<Integer, Void, Void>()
        {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                dialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
                dialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                dialog.setTitleText("Loading...");
                dialog.setCancelable(false);
                dialog.show();

            }

            @Override
            protected Void doInBackground(Integer... movieIds)
            {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://www.geethanjaliapps.com/app/updts.php" )
                        .build();
                try
                {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        Feeds feeds = new Feeds(object.getInt("ID"), object.getString("TITLE"),
                                object.getString("CONTENT"), object.getString("IMAGE"),
                                object.getString("TIME"));

                        feedsList.add(feeds);
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid)
            {
                //pDialog.dismiss();

                dialog.dismiss();
                adapter.notifyDataSetChanged();
            }
        };

        asyncTask.execute(id);
    }
}
