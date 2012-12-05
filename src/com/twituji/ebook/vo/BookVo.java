package com.twituji.ebook.vo;

/**
 * 
 * 记录书的地址及导入状态
 * 
 * @author
 */
public class BookVo {
	private String owen;// 书籍路径
	private int local;// 导入状态

	// 地址
	public String getOwen() {
		return owen;
	}

	public void setOwen(String owen) {
		this.owen = owen;
	}

	// 导入状态
	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

	public BookVo(String owen, int local) {
		super();
		this.owen = owen;
		this.local = local;
	}

}
