package rest.clients;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dmd.martin.distribuidosapp.R;
import com.dmd.martin.distribuidosapp.activities.ClientsMenu;
import com.dmd.martin.distribuidosapp.activities.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by martin on 28/11/17.
 */

public class RestClient extends AsyncTask <Void, Integer, Void>{
    private AppCompatActivity activity;
    private ProgressBar progressBar;

    public RestClient(AppCompatActivity activity){
        this.activity = activity;
        this.progressBar = (ProgressBar) activity.findViewById(R.id.progressBarMenu);
    }

    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected Void doInBackground(Void... voids) {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ClientInterface productInterface = builder.create(ClientInterface.class);
        Call<ClientList> call = productInterface.getListClients();
        call.enqueue(new Callback<ClientList>() {
            @Override
            public void onResponse(Call<ClientList> call, Response<ClientList> response) {
                ClientList clientListaux = response.body();
                for (Client client:clientListaux.getClients()) {
                    if(client.getId_empresa() == Integer.parseInt(Constants.ID))
                        Constants.clientList.addClient(client);
                }
            }

            @Override
            public void onFailure(Call<ClientList> call, Throwable t) {
                Toast.makeText(activity.getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        progressBar.setVisibility(View.INVISIBLE);
        activity.startActivity(new Intent(activity.getBaseContext(),ClientsMenu.class));
    }
}
