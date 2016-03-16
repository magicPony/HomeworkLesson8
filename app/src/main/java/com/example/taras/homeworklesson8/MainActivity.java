package com.example.taras.homeworklesson8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ShowPersonActivityStarter {
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new CustomAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /// only one item
        /// no need in switch
        Intent intent = new Intent(MainActivity.this, CreatePersonActivity.class);
        startActivityForResult(intent, 0);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 0) {
            return;
        }

        DataModel newPerson = (DataModel) data.getSerializableExtra(Values.NEW_PERSON_TAG);
        Data.add(newPerson);

        mAdapter.notifyItemInserted(Data.size() - 1);
        mAdapter.notifyItemRangeInserted(Data.size() - 1, Data.size());
    }

    public static void removePerson(int listPosition) {
        Data.remove(listPosition);
        mAdapter.notifyItemRemoved(listPosition);
        mAdapter.notifyItemRangeChanged(listPosition, Data.size());
    }

    @Override
    public void startShowPersonActivity(int listPosition) {
        Intent intent = new Intent(this, ShowPersonActivity.class);
        intent.putExtra(Values.PERSON_TO_SHOW_TAG, Data.get(listPosition));
        startActivity(intent);
    }
}
