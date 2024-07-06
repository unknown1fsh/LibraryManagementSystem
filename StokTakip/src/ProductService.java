import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> productList;

    public ProductService() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getAllProducts() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(int id, Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, updatedProduct);
                return;
            }
        }
    }

    public void deleteProduct(int id) {
        productList.removeIf(product -> product.getId() == id);
    }
}
