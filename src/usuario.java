public class usuario {
    String contrasenia;
    String correo;
    /*Constructores*/
    public usuario(){ }
    public usuario(String contrasenia, String correo) {
        this.contrasenia = contrasenia;
        this.correo = correo;
    }
    /*Setters y getters*/
    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
