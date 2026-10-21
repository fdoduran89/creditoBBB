
package negocio;


public class Cliente extends Persona{
    
    public int ingresos;        
    
    public int antiguedad;
    
    public int egresos;
    
    private Vinculacion vinculacion;
    
    public int patrimonio;

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
    
    
}
