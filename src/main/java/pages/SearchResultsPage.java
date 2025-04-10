package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.Map;

import static pages.BasePage.log;
import static pages.BasePage.page;

public class SearchResultsPage
{
    private HashMap<String, String> locatorMap = new HashMap<>();
    private HashMap<String, String> infoMap = new HashMap<>();

    public SearchResultsPage()
    {
        //Locators
        locatorMap.put("brownTshirt", "a[href='/product_details/29']");
        locatorMap.put("tshirtQuantity", "//input[@id='quantity']");
        locatorMap.put("addToCartBtn", "//button[normalize-space()='Add to cart']");
        locatorMap.put("vieCartButton", "//u[normalize-space()='View Cart']");

        //Info Messages for All Locators
        infoMap.put("brownTshirt","Brown Tshirt View Product");
        infoMap.put("tshirtQuantity","Tshirt Quantiy Button");
        infoMap.put("addToCartBtn","Add to Cart Button");
        infoMap.put("vieCartButton","View Shopping Cart Button");
    }

    public void enterTshirtQuantity(String quantity) {
        try {
            Locator tshirtQuantity = page.locator("//input[@id='quantity']");
            tshirtQuantity.fill(quantity);

        } catch (Exception e) {
            log.info("Failed to enter the T-shirt Quantity");
            throw new RuntimeException(e);
        }
    }


    public void clickTshirtProduct() {
        try {
            Locator viewProductBtn = page.locator("a[href='/product_details/29']");
            viewProductBtn.click();
        } catch (Exception e) {
            log.info("Failed to click on the T-Shirt View Product Button");
            throw new RuntimeException(e);
        }
    }

    public void clickAddToCartBtn() {
        try {
            Locator addToCartBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart") );
            addToCartBtn.click();
        } catch (Exception e) {
            log.info("Failed to click on the Add To Cart Button");
            throw new RuntimeException(e);
        }
    }

    public void clickViewShoppingCartBtn() {
        try {
            Locator viewCartBtn = page.locator("//u[normalize-space()='View Cart']");
            viewCartBtn.click();
        } catch (Exception e) {
            log.info("Failed to click on the View Cart Button");
            throw new RuntimeException(e);
        }
    }


}
