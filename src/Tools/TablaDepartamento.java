package Tools;

public class TablaDepartamento {

    private String codigo;
    private String nombre;
    private int empleados;

    public TablaDepartamento(String codigo, String nombre, int empleados) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }


}
