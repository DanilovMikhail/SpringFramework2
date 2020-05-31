package OnlineStore.Controllers;

import OnlineStore.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    private final ProductService productService;

    @Autowired
    public CategoriesController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String categories(@RequestParam(value = "page") Optional<Integer> page,
                           @RequestParam(value = "size") Optional<Integer> size,
                           Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("productsPage",
                productService.findAll(PageRequest.of(page.orElse(1) - 1, size.orElse(4))
        ));
        return "categories";
    }

}
