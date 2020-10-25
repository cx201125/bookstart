package com.chenxin.domain;

import java.util.ArrayList;
import java.util.List;

public class Pagebean<T> {
	    //当前页数
		private int dangqianpage;
		//总页数
		private int  zongpage;
		//一页有多少个商品
		private int  onepage;
		//一共有多少个商品
		private int Allproduct;
		//每一页存的数据
		private List<T> onepageproduct =new ArrayList<T>();
		
		
		
		
		
		public Pagebean() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getDangqianpage() {
			return dangqianpage;
		}
		public void setDangqianpage(int dangqianpage) {
			this.dangqianpage = dangqianpage;
		}
		public int getZongpage() {
			return zongpage;
		}
		public void setZongpage(int zongpage) {
			this.zongpage = zongpage;
		}
		public int getOnepage() {
			return onepage;
		}
		public void setOnepage(int onepage) {
			this.onepage = onepage;
		}
		public int getAllproduct() {
			return Allproduct;
		}
		public void setAllproduct(int allproduct) {
			Allproduct = allproduct;
		}
		public List<T> getOnepageproduct() {
			return onepageproduct;
		}
		public void setOnepageproduct(List<T> onepageproduct) {
			this.onepageproduct = onepageproduct;
		}
	
}
