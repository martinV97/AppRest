package rest.products;

import rest.users.UserList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by martin on 28/11/17.
 */

public interface ProductInterface {

    @GET("usuario")
    Call<ProductList> getListProducts();
}
