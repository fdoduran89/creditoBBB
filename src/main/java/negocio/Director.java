package negocio;

public class Director extends Empleado {
    
    private Credito creditoAprobado; 

    public Director() {
        // ENCAPSULAMIENTO: El Director ya viene embebido con sus datos por defecto
        this.nombre = "Director General"; 
        this.salarioBase = 5000000;
        this.retencion = 500000;
    }

    public void setCreditoAprobado(Credito credito) { 
        this.creditoAprobado = credito; 
    }

    @Override
    public float getComision() {
        if (creditoAprobado == null) return 0.0f;
        return creditoAprobado.getMonto() * creditoAprobado.getTipoCredito().getComisionDirector();
    }

    @Override
    public float liquidarSalario() {
        return super.liquidarSalario() + getComision();
    }
}