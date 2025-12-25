package FirstPackage;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.LoadState;

import java.util.List; // Only needed import

public class FirstPlaywrightClass {
	public static void main(String[] args) {

		Browser browser = null;
		Page page = null;

		try {
			browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			page = browser.newPage();
			page.navigate("https://advantageonlineshopping.com/#/");
			PlaywrightAssertions.assertThat(page).hasTitle("Advantage Shopping");
			page.waitForSelector("#img-special-offer"); // Use # for ID

			page.locator("#hrefUserIcon").click();

			page.waitForSelector("input[name='username']");

			// Enter username and password
			page.locator("xpath=//*[@name='username']").fill("Rudra");
			page.locator("input[name='password']").fill("Mahadev@777");

			// Click the Sign In button
			page.locator("#sign_in_btn").click();

		} finally {
//    		 page.close();
//    	     browser.close();
		}

		// ✅ newPage() = new tab in same context
		// ⚠️ This is Playwright's Chromium, not your regular Chrome

	}
}
