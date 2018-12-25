package com.example.prasoon.lnmsocial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.prasoon.lnmsocial.adapter.SearchResultAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultActivity extends AppCompatActivity {

    @BindView(R.id.search_result_recyclerView)
    public RecyclerView searchResultRecyclerView;

    SearchResultAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search Results");
        setSupportActionBar(toolbar);

        adapter = new SearchResultAdapter(Utility.getData());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        searchResultRecyclerView.setLayoutManager(mLayoutManager);
        searchResultRecyclerView.setItemAnimator(new DefaultItemAnimator());
        searchResultRecyclerView.setAdapter(adapter);

    }
}
