package Tools;

public class TableGerentes {

    private String codigoGerente;
    private String nombre;
    private String telefono;
    private String direccion;
    private String horaEnt;
    private String horaSal;
    private String pass;

    public TableGerentes(String codigoGerente, String nombre, String telefono, String direccion, String horaEnt, String horaSal, String pass) {
        this.codigoGerente = codigoGerente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.horaEnt = horaEnt;
        this.horaSal = horaSal;
        this.pass = pass;
    }

    public String getCodigoGerente() {
        return codigoGerente;
    }

    public void setCodigoGerente(String codigoGerente) {
        this.codigoGerente = codigoGerente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHoraEnt() {
        return horaEnt;
    }

    public void setHoraEnt(String horaEnt) {
        this.horaEnt = horaEnt;
    }

    public String getHoraSal() {
        return horaSal;
    }

    public void setHoraSal(String horaSal) {
        this.horaSal = horaSal;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


}
