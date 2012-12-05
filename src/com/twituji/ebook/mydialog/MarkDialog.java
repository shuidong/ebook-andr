package com.twituji.ebook.mydialog;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.twituji.ebook.R;
import com.twituji.ebook.adapter.MarkAdapter;
import com.twituji.ebook.vo.MarkVo;

/**
 * 我的书签的自定义dialog
 * 
 * @author
 * 
 */
public class MarkDialog extends Dialog implements OnItemClickListener {

	private ListView markList;
	@SuppressWarnings("unused")
	private ArrayList<HashMap<String, String>> aList = null;
	private ArrayList<MarkVo> list = null;
	private Context context;
	private static int begin;
	private Handler mHandler;
	private static Dialog dialog;

	public MarkDialog(Context context, ArrayList<MarkVo> list,
			Handler mHandler, int theme) {
		super(context, theme);
		this.context = context;
		this.list = list;
		this.mHandler = mHandler;
		dialog = this;
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mymark);

		markList = (ListView) findViewById(R.id.markid);

		markList.setAdapter(new MarkAdapter(context, list, markList));
		markList.setOnItemClickListener(this);
	}

	public static void setAdapter(ListView markList, Context context,
			ArrayList<MarkVo> list) {
		if (list.size() == 0) {
			dialog.dismiss();
		} else {
			markList.setAdapter(new MarkAdapter(context, list, markList));
		}
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			this.dismiss();
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		this.dismiss();
		begin = list.get(arg2).getBegin();
		System.out.println(begin);
		Message msg = new Message();
		msg.what = 0;
		msg.arg1 = begin;
		mHandler.sendMessage(msg);
	}

}
