package rest.clients;

import rest.products.ProductList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by martin on 28/11/17.
 */

public interface ClientInterface {
    @GET("cliente")
    Call<ClientList> getListClients();
}
