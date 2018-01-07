package rest.users;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by martin on 16/11/17.
 */

public interface UserInterface {

    @GET("usuario")
    Call <UserList> getListUsers();
}
