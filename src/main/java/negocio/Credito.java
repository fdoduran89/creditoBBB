package negocio;

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
        
        cuota = calcularCuota();
        
        System.out.println("El valor de la cuota es: $" + Math.round(cuota));
        
        System.out.println("Tabla de Amortización");
        System.out.println("=====================");
    
        System.out.println("Mes\tCuota Fija Mensual\tInterés Mensual\t\tCapital\t\tSaldo Pendiente");
    
        double interesPagado = 0;
        double interesMensual = 0;
        double capital = 0;
        double restante = monto;
        
        for (int i = 1; i <= plazo; i++) {
            interesMensual = restante * tasa;
            capital = cuota - interesMensual;
            
            if (i == plazo) {
                capital = restante;
                cuota = interesMensual + capital;
            }
            
            restante -= capital;
            if (restante < 0.01) restante = 0;
            
            interesPagado += interesMensual;
            
            System.out.printf("%d\t$%d\t\t$%d\t\t$%d\t\t$%d%n",
                    i,
                    Math.round(cuota),
                    Math.round(interesMensual),
                    Math.round(capital),
                    Math.round(restante));
        }
       
        System.out.println("El interes pagado es: $" + Math.round(interesPagado));
    }
    
    private double calcularCuota(){
        
        if (tasa == 0) {
            this.cuota = monto / plazo;
        } else {
            this.cuota = monto * (tasa / (1 - Math.pow(1 + tasa, -plazo)));
        }
        
        return cuota;
    }
}