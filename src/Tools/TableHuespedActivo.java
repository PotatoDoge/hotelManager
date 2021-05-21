package Tools;

public class TableHuespedActivo {

    private String cuarto;
    private String reservacion;
    private String checkIn;

    public TableHuespedActivo(){
    }

    public TableHuespedActivo(String cuarto, String reservacion, String checkIn) {
        this.cuarto = cuarto;
        this.reservacion = reservacion;
        this.checkIn = checkIn;
    }


    public String getCuarto() {
        return cuarto;
    }

    public void setCuarto(String cuarto) {
        this.cuarto = cuarto;
    }

    public String getReservacion() {
        return reservacion;
    }

    public void setReservacion(String reservacion) {
        this.reservacion = reservacion;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }




}
