package Tools;

public class TableEmpleadoDepa {

    private String claveEmpleado;
    private String claveDepa;
    private String puesto;
    private double sueldo;

    public TableEmpleadoDepa(String claveEmpleado, String claveDepa, String puesto, double sueldo) {
        this.claveEmpleado = claveEmpleado;
        this.claveDepa = claveDepa;
        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    public String getClaveEmpleado() {
        return claveEmpleado;
    }

    public void setClaveEmpleado(String claveEmpleado) {
        this.claveEmpleado = claveEmpleado;
    }

    public String getClaveDepa() {
        return claveDepa;
    }

    public void setClaveDepa(String claveDepa) {
        this.claveDepa = claveDepa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
