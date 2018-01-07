package rest.users;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("usuario")
    @Expose
    private String usuario;
    @SerializedName("clave")
    @Expose
    private String clave;
    @SerializedName("serialempresa")
    @Expose
    private Integer serialempresa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getSerialempresa() {
        return serialempresa;
    }

    public void setSerialempresa(Integer serialempresa) {
        this.serialempresa = serialempresa;
    }

}
