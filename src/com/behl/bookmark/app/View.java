package com.behl.bookmark.app;

import com.behl.bookmark.app.constants.KidFriendlyStatus;
import com.behl.bookmark.app.constants.UserType;
import com.behl.bookmark.app.controllers.BookmarkController;
import com.behl.bookmark.app.entities.Bookmark;
import com.behl.bookmark.app.entities.User;
import com.behl.bookmark.app.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {

		System.out.println("\n" + user.getEmail() + " is browsing items...");

		int bookmarkCount = 0;
		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// Bookmarking!!!
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Item Bookmarked..." + bookmark);
					}

				}

				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					// Mark as kid=friendly
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						getkidFriendlyStatusdecision(bookmark);
						String kidFriendlyStatus = getkidFriendlyStatusdecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);

						}
					}

					// Sharing !!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();

						if (isShared) {
							BookmarkController.getInstance().share(user, bookmark);

							// BookmarkController.getInstance().share(user,
							// bookmark);
						}
					}

				}

			}
		}

	}
	// TODO: Below Methods simulate user input. After IO, We take input via console.
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getkidFriendlyStatusdecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}

	// The below code could be removed as well
	// for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
	// int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
	// int bookmarkOffset = (int)(Math.random() *
	// DataStore.BOOKMARK_COUNT_PER_TYPE);
	//
	// Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	//
	// BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	//
	// System.out.println(bookmark);
	// }

	// public static void bookmark(User user, Bookmark[][] bookmarks){
	// System.out.println("\n" + user.getEmail() + " is bookmarking.");
	// for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) {
	// int typeOffset = (int)(Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
	// int bookmarkOffset = (int)(Math.random() *
	// DataStore.BOOKMARK_COUNT_PER_TYPE);
	//
	// Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	//
	// BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	//
	// System.out.println(bookmark);
	// }
	// }

}
