
package negocio;

import java.text.DecimalFormat;


public class Credito {
    
    private float monto;
    
    private int plazo;
    
    private float tasa;
    
    private double cuota;
    
    private Cliente cliente; 
    
    private tipoCredito tipoCredito;

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public float getTasa() {
        return tasa;
    }

    public void setTasa(float tasa) {
        this.tasa = tasa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public tipoCredito getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(tipoCredito tipoCredito) {
        this.tipoCredito = tipoCredito;
    }
    
        
    public double getCuota() {
        return cuota;
    }
    
    public void obtenerAmortizacion(){
        
        DecimalFormat df = new DecimalFormat("###,###,###.##");
        
        cuota = calcularCuota();
        
        System.out.println("El valor de la cuota es: " + df.format(Math.round(cuota)) );
        
        
        System.out.println("Tabla de Amortización");
        System.out.println("=====================");
    
        System.out.println("Mes\tCuota Fija Mensual\tInterés Mensual\t\tCapital\t\tSaldo Pendiente");
    
        double interesPagado = 0;
        double interesMensual = 0;
        double capital = 0;
        double restante = 0;
        
        // CONTINUAR CON EL METODO PARA GENERAR LA TABLA DE AMORTIZACION
        //
        //
       
        System.out.println("El interes pagado es: $" + df.format(Math.round(interesPagado)));
    }
    
    // CONTINUAR CON EL METODO PARA CALCULAR LA CUOTA MENSUAL
    private double calcularCuota(){
                       
       // 
       //
       
        this.cuota = 0;
        
        return cuota;
    }
}

