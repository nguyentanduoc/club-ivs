package com.vn.ivs.ctu.utils;

public class Pagination {
	
	public static int MAX_SIZE_MEMBER = 5;
	
	public static int totalPage(long rows, int size) {
		return (int) (rows / size + ((rows % size == 0) ? 0 : 1)); 
	}
}
