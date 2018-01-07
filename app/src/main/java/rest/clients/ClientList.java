package rest.clients;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import rest.products.Product;

/**
 * Created by martin on 28/11/17.
 */

public class ClientList {
    @SerializedName("clientes")
    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client){
        clients.add(client);
    }
}
