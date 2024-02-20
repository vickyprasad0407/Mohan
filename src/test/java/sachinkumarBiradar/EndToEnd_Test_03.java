package sachinkumarBiradar;

import org.testng.annotations.Test;

import com.eCommerce.objectRepository.Categories_Page;
import com.eCommerce.objectRepository.Edit_Category_Page;
import com.orgName.genericUtility.MainClass;
import com.orgName.genericUtility.UtilityClass;

public class EndToEnd_Test_03 extends MainClass {

	@Test
	public void TC_07_Edit_Category() {
		adminHomePage.clickOncreateCategoryLink();
		Categories_Page category = new Categories_Page();
		category.edit();
		Edit_Category_Page editCategory = new Edit_Category_Page();
		String categoryName = UtilityClass.getExcelLibrary().getData("categories", 1, 0);
		String description = UtilityClass.getExcelLibrary().getData("categories", 1, 1);
		editCategory.editCategoryInfo(categoryName, description);
	}
}
