package Tools;

public class TableCuarto {
    private String codigo;
    private int capacidad;
    private String tipo;
    private int numero;
    private int piso;
    private char disp;

    public TableCuarto(String codigo, int capacidad, String tipo, int numero, int piso, char disp) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.numero = numero;
        this.piso = piso;
        this.disp = disp;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public char getDisp() {
        return disp;
    }

    public void setDisp(char disp) {
        this.disp = disp;
    }
}
