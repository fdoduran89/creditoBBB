package negocio;

public class Empleado extends Persona {
    
    protected float salarioBase;
    protected float retencion;

    public float getSalarioBase() { return salarioBase; }
    public void setSalarioBase(float salarioBase) { this.salarioBase = salarioBase; }

    public float getRetencion() { return retencion; }
    public void setRetencion(float retencion) { this.retencion = retencion; }

    public float liquidarSalario() {
        return salarioBase - retencion;
    }
    
    public float getComision() {
        return 0.0f;
    }
}