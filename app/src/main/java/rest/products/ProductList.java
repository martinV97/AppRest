package rest.products;

import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by martin on 28/11/17.
 */

public class ProductList{
    @SerializedName("productos")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        products.add(product);
    }
}
