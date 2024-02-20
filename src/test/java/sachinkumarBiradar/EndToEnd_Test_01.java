package sachinkumarBiradar;

import org.testng.annotations.Test;

import com.eCommerce.objectRepository.Home_Page;
import com.eCommerce.objectRepository.MyCart_Page;
import com.orgName.genericUtility.MainClass;
import com.orgName.genericUtility.UtilityClass;

public class EndToEnd_Test_01 extends MainClass {
	
	
	@Test
	public void TC_01_AddToCart() {
		Home_Page hp = new Home_Page();
		hp.searchTheProduct(UtilityClass.getExcelLibrary().getData("CommonData", 8, 1));
		hp.addToCart();
		MyCart_Page myCart = new MyCart_Page();
		myCart.nameOfProduct();
		
	}
}
