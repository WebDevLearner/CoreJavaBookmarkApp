package com.behl.bookmark.app.entities.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.behl.bookmark.app.constants.MovieGenre;
import com.behl.bookmark.app.entities.Movie;
import com.behl.bookmark.app.managers.BookmarkManager;

public class MovieTest {

	@Test
	public void test() {
		//Test 1
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[] {"Orson Welles", "Joseph Cotten"},	 new String[] {"Orson Welles"}, MovieGenre.HORROR, 8.5);
		
		boolean iskidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse("For Horror Genre - isKidFriendlyEligible should return false", iskidFriendlyEligible);
		
		//Test 2
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941, new String[] {"Orson Welles", "Joseph Cotten"},	 new String[] {"Orson Welles"}, MovieGenre.THRILLERS, 8.5);
		
		iskidFriendlyEligible = movie.isKidFriendlyEligible();
		
		assertFalse("For Thrillers Genre - isKidFriendlyEligible should return false", iskidFriendlyEligible);
	}

	
	
}
