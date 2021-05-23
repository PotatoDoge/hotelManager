package Tools;

public class TableAreas {

    private String clave;
    private String tipo;
    private int personal;
    private String nombre;

    public TableAreas(String clave, String tipo, int personal, String nombre) {
        this.clave = clave;
        this.tipo = tipo;
        this.personal = personal;
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPersonal() {
        return personal;
    }

    public void setPersonal(int personal) {
        this.personal = personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
