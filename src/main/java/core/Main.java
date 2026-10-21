
package core;

// import java.text.DecimalFormat;
import java.text.DecimalFormat;
import negocio.Asesor;
import negocio.Cliente;
import negocio.Credito;
import negocio.Vinculacion;
import negocio.tipoCredito;

public class Main {


    public static void main(String[] args) {
        
        Asesor asesor = new Asesor();
        DecimalFormat df = new DecimalFormat("###,###,###.##");
        
        // #############################################################
        //                      CREACION DE UN CLIENTE
        // #############################################################
        
        Cliente clienteA = new Cliente();
        clienteA.setNombre("Pedro");
        clienteA.setApellido("Perez");
        clienteA.setCedula(123);
        clienteA.setIngreso(10_000_000);
        clienteA.setEgresos(5_000_000);
        clienteA.setVinculacion(Vinculacion.EMPLEADO);
        
        // DEBE CREAR LA FUNCIONALIDAD PARA CREAR EL CLIENTE DINAMICAMENTE 
        // 
        //
        //
        
        
        // #############################################################
        //                      SOLICITUD DEL CREDITO
        // #############################################################
        Credito creditoA = new Credito();        
        creditoA.setCliente(clienteA);
        creditoA.setMonto(10_000_000);
        creditoA.setPlazo(36);
        creditoA.setTasa(0.05f);
        creditoA.setTipoCredito(tipoCredito.VIVIENDA);
        
        
        // DEBE CREAR LA FUNCIONALIDAD PARA CREAR EL CREDITO DINAMICAMENTE 
        // BASADO EN EL TIPO DE CREDITO QUE SOLICITA EL CLIENTE
        //
        //
        
        System.out.println("################################");
        System.out.println("INFORMACION DEL CREDITO");
        
        int disponible = 0;
        int ingreso = 0;
        int superavit = 0;
        
        Cliente clienteCredito = creditoA.getCliente();
        System.out.println("Cliente: " + clienteCredito.getNombre() + " " + clienteCredito.getApellido());
        
         disponible = clienteCredito.getIngreso() - clienteA.getEgresos();
         ingreso = clienteCredito.getIngreso();
         superavit = (ingreso * 35)/100;
        
        System.out.println("El superavit necesario: $" + df.format(Math.round(superavit)));
        System.out.println("La capacidad de pago es: $" + df.format(Math.round(disponible)));
        //System.out.println("La cuota maxima que uede pagar es: " +);
        
        if(disponible >= superavit){
            
            // INVOCACION DEL METODO ENCAPSULADO PARA CALCULAR EL CREDITO
            // 
        }
        else 
            System.out.println("No es posible realizar la operacion por su capacidad de pago");
                        
    }
    
}
