package sachinkumarBiradar;

import org.testng.annotations.Test;

import com.eCommerce.objectRepository.ChoosePaymentMethod_Page;
import com.eCommerce.objectRepository.Home_Page;
import com.eCommerce.objectRepository.MyCart_Page;
import com.orgName.genericUtility.MainClass;
import com.orgName.genericUtility.UtilityClass;

public class EndToEnd_Test_02 extends MainClass {

	@Test
	public void TC_02_Order() {
		Home_Page hp = new Home_Page();
		hp.searchTheProduct(UtilityClass.getExcelLibrary().getData("CommonData", 8, 1));
		hp.addToCart();
		String billingAddress = UtilityClass.getExcelLibrary().getData("Billing", 0, 1);
		String billingState = UtilityClass.getExcelLibrary().getData("Billing", 1, 1);
		String billingCity = UtilityClass.getExcelLibrary().getData("Billing", 2, 1);
		String billingPinCode = UtilityClass.getExcelLibrary().getData("Billing", 3, 1);
		String shippingAddress = UtilityClass.getExcelLibrary().getData("Billing", 4, 1);
		String shippingState = UtilityClass.getExcelLibrary().getData("Billing", 5, 1);
		String shippingCity = UtilityClass.getExcelLibrary().getData("Billing", 6, 1);
		String shippingPincode = UtilityClass.getExcelLibrary().getData("Billing", 7, 1);
		MyCart_Page myCart = new MyCart_Page();
		myCart.placeOrder(billingAddress, billingState, billingCity, billingPinCode, shippingAddress, shippingState, shippingCity, shippingPincode);
		ChoosePaymentMethod_Page choosePayment = new ChoosePaymentMethod_Page();
		choosePayment.placeOrderUsingCOD();
		
	}
}
