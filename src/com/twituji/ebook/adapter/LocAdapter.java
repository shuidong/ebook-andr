package com.twituji.ebook.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

import com.twituji.ebook.R;
 

public class LocAdapter extends BaseAdapter {
	private Context mContext;
	private ArrayList<HashMap<String, Object>> listItem = null;
	protected int i;

	public LocAdapter(Context context,
			ArrayList<HashMap<String, Object>> listItem, int i) {
		this.mContext = context;
		this.listItem = listItem;
		this.i = i;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return listItem.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unused")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(mContext);
		View view = inflater.inflate(R.layout.item, null);
		ImageView itemback = (ImageView) view.findViewById(R.id.itemback);
		ImageView ItemImage = (ImageView) view.findViewById(R.id.ItemImage);
		TextView bookName = (TextView) view.findViewById(R.id.bookName);
		TextView ItemTitle = (TextView) view.findViewById(R.id.ItemTitle);
		TextView ItemTitle1 = (TextView) view.findViewById(R.id.ItemTitle1);
		TextView ItemTitle2 = (TextView) view.findViewById(R.id.ItemTitle2);
		ImageView ItemImage9 = (ImageView) view.findViewById(R.id.ItemImage9);
		TextView last = (TextView) view.findViewById(R.id.last);

		final int p = position;
		ItemImage
				.setImageResource((Integer) (listItem.get(p).get("ItemImage")));
		if (listItem.get(p).get("itemback") != null) {
			itemback.setImageResource((Integer) (listItem.get(p)
					.get("itemback")));
			itemback.setScaleType(ScaleType.CENTER_CROP);
		}
		bookName.setText((String) (listItem.get(p).get("BookName")));
		ItemTitle.setText((String) (listItem.get(p).get("ItemTitle")));
		ItemTitle1.setText((String) (listItem.get(p).get("ItemTitle1")));
		last.setText((String) (listItem.get(p).get("LastImage")));
		return view;
	}

}
