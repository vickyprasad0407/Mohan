package sachinkumarBiradar;

import org.testng.annotations.Test;

import com.eCommerce.objectRepository.Insert_Product_Page;
import com.orgName.genericUtility.MainClass;
import com.orgName.genericUtility.UtilityClass;

public class EndToEnd_Test_06 extends MainClass {

	@Test
	public void TC_10_InsertProduct() {
		adminHomePage.clickOnInsertProduct();
		Insert_Product_Page insertProduct = new Insert_Product_Page();
		String productCompany = UtilityClass.getExcelLibrary().getData("subCategory", 0, 1);
		String productName = UtilityClass.getExcelLibrary().getData("subCategory", 1, 1);
		String ProductPriceBD = UtilityClass.getExcelLibrary().getData("subCategory", 2, 1);
		String productPriceAfterDiscount = UtilityClass.getExcelLibrary().getData("subCategory", 3, 1);
		String productDescription = UtilityClass.getExcelLibrary().getData("subCategory", 4, 1);
		String productShippingCharge = UtilityClass.getExcelLibrary().getData("subCategory", 5, 1);
		 String productAvailability = UtilityClass.getExcelLibrary().getData("subCategory", 6, 1);
		insertProduct.insertProduct(2, 1, productCompany, productName, 
				                     ProductPriceBD, productPriceAfterDiscount, productDescription, 
				                     productShippingCharge, productAvailability);
		String pathOfImage1 = "G:/API_TESTING/IMG-20230209-WA0000.jpg";
		String pathOfImage2 = "G:/API_TESTING/IMG-20230209-WA0001.jpg";
		String pathOfImage3 = "G:/API_TESTING/IMG-20230209-WA0002.jpg";
		insertProduct.uploadImage1(pathOfImage1, pathOfImage2, pathOfImage3);
		insertProduct.clickOnInsert();
	}
}
