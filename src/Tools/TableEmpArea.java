package Tools;

public class TableEmpArea {

    private String claveEmp;
    private String claveArea;
    private String horario;

    public TableEmpArea(String claveEmp, String claveArea, String horario) {
        this.claveEmp = claveEmp;
        this.claveArea = claveArea;
        this.horario = horario;
    }

    public String getClaveEmp() {
        return claveEmp;
    }

    public void setClaveEmp(String claveEmp) {
        this.claveEmp = claveEmp;
    }

    public String getClaveArea() {
        return claveArea;
    }

    public void setClaveArea(String claveArea) {
        this.claveArea = claveArea;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
