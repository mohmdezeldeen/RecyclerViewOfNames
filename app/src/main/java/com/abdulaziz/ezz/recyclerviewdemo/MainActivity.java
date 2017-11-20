package com.abdulaziz.ezz.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements EmployeeAdapter.ListItemClickListener
{

	private RecyclerView mRecyclerView;
	private EmployeeAdapter mEmployeeAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mRecyclerView = findViewById(R.id.recycler_view);
		LinearLayoutManager layoutManager = new LinearLayoutManager(this);
		mRecyclerView.setLayoutManager(layoutManager);
		mRecyclerView.setItemAnimator(new DefaultItemAnimator());
		mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
		mRecyclerView.setHasFixedSize(true);

		mEmployeeAdapter = new EmployeeAdapter(Employee.names, this);
		mRecyclerView.setAdapter(mEmployeeAdapter);
	}

	@Override
	public void onListItemClick(int itemClickIndex)
	{
		Toast.makeText(MainActivity.this, Employee.names[itemClickIndex] + ".. Replace with your action", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onListItemLongClick(int itemClickIndex)
	{
		Toast.makeText(MainActivity.this, "onLongClick .. Replace with your action", Toast.LENGTH_LONG).show();
	}
}
