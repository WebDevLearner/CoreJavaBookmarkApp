package com.behl.bookmark.app.entities.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.behl.bookmark.app.constants.BookGenre;
import com.behl.bookmark.app.entities.Book;
import com.behl.bookmark.app.managers.BookmarkManager;

public class BookTest {

	@Test
	public void test() {
	//Test 1
	Book book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
	
	boolean iskidFriendlyEligible = book.isKidFriendlyEligible();
	
	assertFalse("For Philosophy Genre - isKidFriendlyEligible should return falase", iskidFriendlyEligible);
		
	//Test 2
	book = BookmarkManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications", new String[] {"Henry David Thoreau"}, BookGenre.SELF_HELP, 4.3);
	
	iskidFriendlyEligible = book.isKidFriendlyEligible();
	
	assertFalse("For Self Help Genre - isKidFriendlyEligible should return falase", iskidFriendlyEligible);
		

	
	
	}

}
