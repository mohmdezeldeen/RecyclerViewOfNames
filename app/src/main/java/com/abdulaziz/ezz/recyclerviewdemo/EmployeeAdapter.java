package com.abdulaziz.ezz.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by EZZ on 2017-11-15.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>
{
	String[] names;
	private final ListItemClickListener mOnClickListener;

	public EmployeeAdapter(String[] names, ListItemClickListener listener)
	{
		this.names = names;
		this.mOnClickListener = listener;
	}

	@Override
	public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
	{
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
		return new EmployeeViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(EmployeeViewHolder holder, int position)
	{
		holder.employeeName.setText(names[position]);
	}

	@Override
	public int getItemCount()
	{
		return names.length;
	}

	public class EmployeeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener
	{
		private TextView employeeName;

		public EmployeeViewHolder(View itemView)
		{
			super(itemView);
			employeeName = itemView.findViewById(R.id.tvName);
			itemView.setOnClickListener(this);
			itemView.setOnLongClickListener(this);
		}

		@Override
		public void onClick(View view)
		{
			int clickPosition = getAdapterPosition();
			mOnClickListener.onListItemClick(clickPosition);
		}

		@Override
		public boolean onLongClick(View view)
		{
			int clickPosition = getAdapterPosition();
			mOnClickListener.onListItemLongClick(clickPosition);
			return true;
		}
	}

	public interface ListItemClickListener
	{
		void onListItemClick(int itemClickIndex);

		void onListItemLongClick(int itemClickIndex);

	}

}
