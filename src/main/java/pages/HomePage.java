package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.Map;

import static pages.BasePage.log;
import static pages.BasePage.page;

public class HomePage
{
    private HashMap<String, String> locatorMap = new HashMap<>();
    private HashMap<String, String> infoMap = new HashMap<>();

    public HomePage()
    {
        //Locators
        locatorMap.put("productsTabButton", "//a[@href='/products']");
        locatorMap.put("searchProduct", "//input[@id='search_product']");
        locatorMap.put("searchSubmitBtn", "//button[@id='submit_search']");

        //Info Messages for All Locators
        infoMap.put("productsTabButton","Products Section Tab Home Page");
        infoMap.put("searchProduct","Search Products Box");
        infoMap.put("searchSubmitBtn","Search Submit Button");
    }

    public void clickProductsLinkBtn() {
        try {
            // Locate and click the "Products" anchor tag using getByRole
            Locator productsLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Products"));
            productsLink.click();
        } catch (Exception e) {
            log.info("Failed to click on the Products section Button on Home Page");
            throw new RuntimeException(e);
        }
    }

    public void clickSearchSubmitBtn() {
        try {
            Locator searchSubmitBtn = page.locator("//button[@id='submit_search']");
            searchSubmitBtn.click();
        } catch (Exception e) {
            log.info("Failed to click on the Search Submit Button");
            throw new RuntimeException(e);
        }
    }

    public void enterProductNameInSearchBox(String productName) {
        try {
            Locator searchProductBox = page.getByPlaceholder("Search Product");
            searchProductBox.fill(productName);
        } catch (Exception e) {
            log.info("Failed to Enter the Product Name in the Search Box");
            throw new RuntimeException(e);
        }
    }

}
