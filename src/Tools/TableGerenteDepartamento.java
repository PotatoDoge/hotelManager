package Tools;

public class TableGerenteDepartamento {

    private String claveGerente;
    private String claveDepa;
    private double sueldo;

    public TableGerenteDepartamento(String claveGerente, String claveDepa, double sueldo) {
        this.claveGerente = claveGerente;
        this.claveDepa = claveDepa;
        this.sueldo = sueldo;
    }

    public String getClaveGerente() {
        return claveGerente;
    }

    public void setClaveGerente(String claveGerente) {
        this.claveGerente = claveGerente;
    }

    public String getClaveDepa() {
        return claveDepa;
    }

    public void setClaveDepa(String claveDepa) {
        this.claveDepa = claveDepa;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
