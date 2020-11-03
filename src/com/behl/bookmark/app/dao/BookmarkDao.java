package com.behl.bookmark.app.dao;

import com.behl.bookmark.app.DataStore;
import com.behl.bookmark.app.entities.Bookmark;
import com.behl.bookmark.app.entities.UserBookmark;

public class BookmarkDao {
	public Bookmark[][] getBookmarks(){
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}

}
