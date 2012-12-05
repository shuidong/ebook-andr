package com.twituji.ebook.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.twituji.ebook.R;
import com.twituji.ebook.helper.MarkHelper;
import com.twituji.ebook.mydialog.MarkDialog;
import com.twituji.ebook.vo.MarkVo;

/**
 * 我的书签的自定义adapter
 * 
 * @author
 * 
 */
public class MarkAdapter extends BaseAdapter {
	private Context mContext;
	// private ArrayList<HashMap<String, String>> aList = null;
	private ArrayList<MarkVo> list = null;
	private ListView markList;
	private MarkHelper markhelper;

	public MarkAdapter(Context c, ArrayList<MarkVo> list, ListView markList) {
		mContext = c;
		this.list = list;
		this.markList = markList;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(mContext);
		View layout = inflater.inflate(R.layout.item_mark, null);
		TextView markText1 = (TextView) layout.findViewById(R.id.markText1);
		TextView markText2 = (TextView) layout.findViewById(R.id.markText2);
		markText1.setText(list.get(position).getText());
		// long begin = list.get(position).getBegin();
		int page = list.get(position).getPage();
		long count = list.get(position).getCount();
		markText2.setText("[" + page + "/" + count + "] "
				+ list.get(position).getTime().substring(0, 16));
		ImageView markImage2 = (ImageView) layout.findViewById(R.id.markImage2);
		final int id = position;
		// 实现对listview内按钮的点击事件的控制
		markImage2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				markhelper = new MarkHelper(mContext);
				String s = list.get(id).getBookPath();
				String s1 = list.get(id).getTime();
				SQLiteDatabase db2 = markhelper.getWritableDatabase();
				db2.delete("markhelper", "path='" + s + "' and time ='" + s1
						+ "'", null);
				db2.close();
				list.remove(id);
				MarkDialog.setAdapter(markList, mContext, list);

			}
		});
		return layout;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

}
