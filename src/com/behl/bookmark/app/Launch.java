package com.behl.bookmark.app;

import com.behl.bookmark.app.entities.Bookmark;
import com.behl.bookmark.app.entities.User;
import com.behl.bookmark.app.managers.BookmarkManager;
import com.behl.bookmark.app.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;

	private static void loadData() {
		System.out.println("1. Loading data....");
		DataStore.loadData();

		users = UserManager.getInstance().getusers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();

//		System.out.println("Printing data...");
//		printUserData();
//		printBookmarkData();
	}

	@SuppressWarnings("unused")
	private static void printUserData() {
		for (User user : users) {
			System.out.println(user);
		}
	}

	@SuppressWarnings("unused")
	private static void printBookmarkData() {
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				System.out.println(bookmark);

			}

		}
	}

	private static void start() {
//		System.out.println("\n 2. Bookmarking...");
		for (User user : users) {
			View.browse(user, bookmarks);
			
		}
	}

	public static void main(String[] args) {
		loadData();
		start();
	}

}
