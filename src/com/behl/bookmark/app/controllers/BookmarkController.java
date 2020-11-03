package com.behl.bookmark.app.controllers;

import com.behl.bookmark.app.entities.Bookmark;
import com.behl.bookmark.app.entities.User;
import com.behl.bookmark.app.managers.BookmarkManager;

public class BookmarkController {

	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {}

	public static BookmarkController getInstance() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user, bookmark);
	}

}
