package negocio;

public class Cliente extends Persona {
    
    private int ingresos;        
    private int antiguedad;
    private int egresos;
    private Vinculacion vinculacion;
    private int patrimonio;

    public int getIngreso() {
        return ingresos;
    }

    public void setIngreso(int ingresos) {
        this.ingresos = ingresos;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getEgresos() {
        return egresos;
    }

    public void setEgresos(int egresos) {
        this.egresos = egresos;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }

    public Vinculacion getVinculacion() {
        return vinculacion;
    }

    public void setVinculacion(Vinculacion vinculacion) {
        this.vinculacion = vinculacion;
    }
    
    //Aqui se da el encapsulamiento
    
    public int calcularCapacidadDePago() {
        return this.ingresos - this.egresos;
    }
    

    public int calcularSuperavitRequerido() {
        return (this.ingresos * 35) / 100;
    }  

    public boolean esAptoParaCredito() {
        return calcularCapacidadDePago() >= calcularSuperavitRequerido();
    }
}