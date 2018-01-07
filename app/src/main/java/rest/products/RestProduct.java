package rest.products;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dmd.martin.distribuidosapp.activities.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by martin on 28/11/17.
 */

public class RestProduct extends AsyncTask<Void, Void, Void> {
    private AppCompatActivity activity;
    private ProductList productList;

    public RestProduct(AppCompatActivity activity){
        this.activity = activity;
        this.productList = new ProductList();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ProductInterface productInterface = builder.create(ProductInterface.class);
        Call<ProductList> call = productInterface.getListProducts();
        call.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                ProductList productListaux = response.body();
                for (Product product:productListaux.getProducts()) {
                    if(product.getId_empresa() == Integer.parseInt(Constants.ID))
                        productList.addProduct(product);
                }
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Toast.makeText(activity.getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }

    public ProductList getProductList() {
        return productList;
    }

    public void setProductList(ProductList productList) {
        this.productList = productList;
    }
}
