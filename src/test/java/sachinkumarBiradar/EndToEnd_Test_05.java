package sachinkumarBiradar;

import org.testng.annotations.Test;

import com.eCommerce.objectRepository.Sub_Category_Page;
import com.orgName.genericUtility.MainClass;
import com.orgName.genericUtility.UtilityClass;

public class EndToEnd_Test_05 extends MainClass {

	@Test
	public void TC_09_SubCategory() {
		adminHomePage.clickOnSubCategory();
		Sub_Category_Page subCategory = new Sub_Category_Page();
		String categoryName = UtilityClass.getExcelLibrary().getData("categories", 3, 0);
		String subCategoryName = UtilityClass.getExcelLibrary().getData("categories", 4, 0);
		subCategory.createSubCategory(subCategoryName, 50, 10);
	}
}
