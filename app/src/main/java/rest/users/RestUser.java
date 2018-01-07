package rest.users;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dmd.martin.distribuidosapp.activities.Constants;
import com.dmd.martin.distribuidosapp.activities.Menu;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by martin on 16/11/17.
 */

public class RestUser extends AsyncTask <Void, Void, Void>{
    private String user;
    private String password;
    private AppCompatActivity activity;

    public RestUser(AppCompatActivity activity, String user, String passsword){
        this.activity = activity;
        this.user = user;
        this.password = passsword;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(Constants.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final UserInterface userInterfaceApi = builder.create(UserInterface.class);
        Call <UserList> call = userInterfaceApi.getListUsers();
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                for (User user : userList.getUsers()) {
                    if (user.getUsuario().equals(RestUser.this.user) && user.getClave().equals(password)) {
                        Constants.ID = user.getId();
                        activity.getApplicationContext().startActivity(new Intent(activity, Menu.class)
                               .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    }
                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Toast.makeText(activity.getBaseContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return null;
    }
}
