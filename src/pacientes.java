import org.w3c.dom.Text;

public class pacientes {
    String cedula;
    int historia;
    String nombre;
    String apellido;
    String telefono;
    int edad;
    String descri_enfe;

    /*Constructores*/
    public pacientes() {
    }

    public pacientes(String cedula, int historia, String nombre, String apellido, String telefono, int edad, Text descri_enfe) {
        this.cedula = cedula;
        this.historia = historia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.edad = edad;
        this.descri_enfe = String.valueOf(descri_enfe);
    }
    /*Stters y getters*/

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescri_enfe() {
        return descri_enfe;
    }

    public void setDescri_enfe(String descri_enfe) {
        this.descri_enfe = descri_enfe;
    }
}
