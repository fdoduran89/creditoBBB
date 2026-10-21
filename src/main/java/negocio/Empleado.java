
package negocio;


public class Empleado {
    
    protected float salario;
    
    protected float retencion;

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getRetencion() {
        return retencion;
    }

    public void setRetencion(float retencion) {
        this.retencion = retencion;
    }
    
    public float liquidarSalario(){
        
        return salario - retencion;
    }
}
