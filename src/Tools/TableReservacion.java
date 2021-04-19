package Tools;

public class TableReservacion {
    private String codigoCliente;
    private String codigoRes;
    private String tipo;
    private String checkIn;
    private String checkOut;
    private String numPersonas;

    public TableReservacion(String codigoCliente, String codigoRes, String tipo, String checkIn, String checkOut, String numPersonas) {
        this.codigoCliente = codigoCliente;
        this.codigoRes = codigoRes;
        this.tipo = tipo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.numPersonas = numPersonas;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoRes() {
        return codigoRes;
    }

    public void setCodigoRes(String codigoRes) {
        this.codigoRes = codigoRes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(String numPersonas) {
        this.numPersonas = numPersonas;
    }
}
