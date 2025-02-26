package com.kdy.pooh.photogallery;

import java.util.List;

public interface PhotoGalleryMapper {
	public abstract int photoUpload(PhotoGallery pg);
	public abstract List<PhotoGallery> galleryGet(GalleryPostSelector gps);
	public abstract int photoDelete(PhotoGallery pg);
	public abstract int galleryPostCount(GalleryPostSelector gps);
}
