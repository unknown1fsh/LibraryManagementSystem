import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;

    // Constructor injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        List<Product> productList = productService.getAllProducts();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @GetMapping("/add")
    public String showAddProductForm(Product product) {
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("edit-product");
        Product product = productService.getProductById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") int id, Product product) {
        productService.updateProduct(id, product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}
