package negocio;

public class Asesor extends Empleado {
    
    private int codigo;
    private int antiguedad;
    private Credito creditoAprobado; 

    public Asesor() {
        // ENCAPSULAMIENTO: El asesor ya sabe cuánto gana por defecto
        this.salarioBase = 2000000;
        this.retencion = 200000;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }

    public int getAntiguedad() { return antiguedad; }
    public void setAntiguedad(int antiguedad) { this.antiguedad = antiguedad; }

    public void setCreditoAprobado(Credito credito) { this.creditoAprobado = credito; }

    @Override
    public float getComision() {
        if (creditoAprobado == null) return 0.0f;
        return creditoAprobado.getMonto() * creditoAprobado.getTipoCredito().getComisionAsesor();
    }

    @Override
    public float liquidarSalario() {
        return super.liquidarSalario() + getComision();
    }
}