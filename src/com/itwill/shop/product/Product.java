package com.itwill.shop.product;

public class Product {
	private int p_no; //상품번호
	private String p_title; //상품명
	private int p_price; //상품가격
	private String p_desc; //상품상세설명
	private String p_image; //상품이미지
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int p_no, String p_title, int p_price, String p_desc, String p_image) {
		super();
		this.p_no = p_no;
		this.p_title = p_title;
		this.p_price = p_price;
		this.p_desc = p_desc;
		this.p_image = p_image;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_title=" + p_title + ", p_price=" + p_price + ", p_desc=" + p_desc
				+ ", p_image=" + p_image + "]";
	}

	
}
