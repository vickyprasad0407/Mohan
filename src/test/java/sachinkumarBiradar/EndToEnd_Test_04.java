package sachinkumarBiradar;

import org.testng.annotations.Test;

import com.eCommerce.objectRepository.Categories_Page;
import com.orgName.genericUtility.MainClass;

public class EndToEnd_Test_04 extends MainClass {

	@Test
	public void TC_08_removeCategory() {
		adminHomePage.clickOncreateCategoryLink();
		Categories_Page category = new Categories_Page();
		category.removeCategory();
	}
}
