package com.behl.bookmark.app.entities.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.behl.bookmark.app.entities.WebLink;
import com.behl.bookmark.app.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test 1: porn in url -- false
		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-porn-part-2.html",
				"http://www.javaworld.com");
		boolean isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("for port in url - isKidFriendlyeligilble() must return false", isKidFriendlyEligible);
		
		// Test 2: porn in title -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger porn, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("for porn in title - isKidFriendlyeligilble() must return false", isKidFriendlyEligible);
	
		// Test 3: adult in host -- false
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-part-2.html",
				"http://www.adult.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertFalse("for adult in host - isKidFriendlyeligilble() must return false", isKidFriendlyEligible);
			
		// Test 4: adult in url, but not in host part -- true
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-adult-part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue("for adult in url but not host - isKidFriendlyeligilble() must return True", isKidFriendlyEligible);
			
		// Test 5: adult in title only -- true
		weblink = BookmarkManager.getInstance().createWebLink(2000, "Taming adult, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger-part-2.html",
				"http://www.javaworld.com");
		isKidFriendlyEligible = weblink.isKidFriendlyEligible();
		
		assertTrue("for adult in title - isKidFriendlyeligilble() must return True", isKidFriendlyEligible);
			
		
	}

}
