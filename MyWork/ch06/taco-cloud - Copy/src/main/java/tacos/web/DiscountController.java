package tacos.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.DiscountCodeProps;

@Controller  // Marks this class as a Spring MVC controller, responsible for handling web requests
@RequestMapping("/discounts")  // Maps all requests that start with "/discounts" to this controller
public class DiscountController {

  private DiscountCodeProps discountProps;  // The DiscountCodeProps bean that holds the discount codes

  // Constructor injection for DiscountCodeProps, ensuring the dependency is provided by Spring
  public DiscountController(DiscountCodeProps discountProps) {
    this.discountProps = discountProps;  // Assigns the injected DiscountCodeProps instance to the class field
  }

  // Handles GET requests to "/discounts" and renders a list of discount codes
  @GetMapping  // Specifies that this method will handle GET requests
  public String displayDiscountCodes(Model model) {

    // Retrieves the discount codes from DiscountCodeProps
    Map<String, Integer> codes = discountProps.getCodes();

    // Adds the discount codes to the model so they can be accessed in the view (discountList.html)
    model.addAttribute("codes", codes);

    // Returns the name of the view template to render (discountList.html)
    return "discountList";
  }

}
