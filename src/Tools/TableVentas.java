package Tools;

public class TableVentas {

    private String empleado;
    private String claveRes;
    private double precio;

    public TableVentas(String empleado, String claveRes, double precio) {
        this.empleado = empleado;
        this.claveRes = claveRes;
        this.precio = precio;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getClaveRes() {
        return claveRes;
    }

    public void setClaveRes(String claveRes) {
        this.claveRes = claveRes;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}
