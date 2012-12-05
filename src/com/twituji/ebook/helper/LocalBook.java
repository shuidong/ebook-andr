package com.twituji.ebook.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 创建数据库
 * 
 * @author
 * 
 */
public class LocalBook extends SQLiteOpenHelper {
	private static String DATABASE_NAME = "book.db";
	private static int DATABASE_VERSION = 1;
	private String PATH = "path";
	private String TYPE = "type";
	private String s = null;

	public LocalBook(Context context, String s) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.s = s;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + s + " ( parent text not null, " + PATH
				+ " text not null, " + TYPE + " text not null"
				+ ", now  text not null, ready);";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
