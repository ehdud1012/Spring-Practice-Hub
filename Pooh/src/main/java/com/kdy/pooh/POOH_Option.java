package com.kdy.pooh;


// 유지보수 할 거리 몰아 넣기
public class POOH_Option {
	private int snsPostPerPage;
	private int galleryPostPerPage;
	
	public POOH_Option() {
		// TODO Auto-generated constructor stub
	}

	public POOH_Option(int snsPostPerPage, int galleryPostPerPage) {
		super();
		this.snsPostPerPage = snsPostPerPage;
		this.galleryPostPerPage = galleryPostPerPage;
	}

	public int getSnsPostPerPage() {
		return snsPostPerPage;
	}

	public void setSnsPostPerPage(int snsPostPerPage) {
		this.snsPostPerPage = snsPostPerPage;
	}

	public int getGalleryPostPerPage() {
		return galleryPostPerPage;
	}

	public void setGalleryPostPerPage(int galleryPostPerPage) {
		this.galleryPostPerPage = galleryPostPerPage;
	}
}
