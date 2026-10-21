package core;

import java.util.Scanner;
import negocio.Asesor;
import negocio.Cliente;
import negocio.Credito;
import negocio.Vinculacion;
import negocio.tipoCredito;
import negocio.CreadorCodigo;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Asesor asesor = new Asesor();
        
        System.out.println("=========================================");
        System.out.println("   SISTEMA DE CREDITOS - BANCO PROMAX");
        System.out.println("=========================================");
        
        // Creación del cliente
        Cliente clienteA = new Cliente();
        
        System.out.print("Ingrese el nombre del cliente: ");
        clienteA.setNombre(sc.nextLine());
        
        System.out.print("Ingrese el apellido del cliente: ");
        clienteA.setApellido(sc.nextLine());
        
        System.out.print("Ingrese la cedula del cliente: ");
        clienteA.setCedula(sc.nextInt());
        
        System.out.print("Ingrese los ingresos mensuales del cliente: $");
        clienteA.setIngreso(sc.nextInt());
        
        System.out.print("Ingrese los egresos mensuales del cliente: $");
        clienteA.setEgresos(sc.nextInt());
        
        clienteA.setVinculacion(Vinculacion.EMPLEADO);
        
        // Solicitud del creditto
        Credito creditoA = new Credito();        
        creditoA.setCliente(clienteA);
        
        System.out.print("Ingrese el monto a solicitar: $");
        creditoA.setMonto(sc.nextFloat());
        
        System.out.println("\nSeleccione el tipo de credito:");
        System.out.println("1. Vehiculo (Tasa 2%, min 5 años)");
        System.out.println("2. Vivienda (Tasa 0.9%, min 15 años)");
        System.out.println("3. Libre Inversion (Tasa 5%, min 3 años)");
        System.out.print("Opcion: ");
        int opcion = sc.nextInt();
        
        switch (opcion) {
            case 1:
                creditoA.setTipoCredito(tipoCredito.VEHICULO);
                creditoA.setTasa(0.02f); 
                int aniosVehiculo = 0;
                do {
                    System.out.print("Ingrese el plazo en años (Minimo 5): ");
                    aniosVehiculo = sc.nextInt();
                    if (aniosVehiculo < 5) {
                        System.out.println("ERROR: El plazo minimo para Vehiculo es de 5 años. Intente de nuevo.");
                    }
                } while (aniosVehiculo < 5);
                creditoA.setPlazo(aniosVehiculo * 12); 
                break;
                
            case 2:
                creditoA.setTipoCredito(tipoCredito.VIVIENDA);
                creditoA.setTasa(0.009f); 
                int aniosVivienda = 0;
                do {
                    System.out.print("Ingrese el plazo en años (Minimo 15): ");
                    aniosVivienda = sc.nextInt();
                    if (aniosVivienda < 15) {
                        System.out.println("ERROR: El plazo minimo para Vivienda es de 15 años. Intente de nuevo.");
                    }
                } while (aniosVivienda < 15);
                creditoA.setPlazo(aniosVivienda * 12);
                break;
                
            case 3:
                creditoA.setTipoCredito(tipoCredito.LIBREINVERSION); 
                creditoA.setTasa(0.05f); 
                int aniosLibre = 0;
                do {
                    System.out.print("Ingrese el plazo en años (Minimo 3): ");
                    aniosLibre = sc.nextInt();
                    if (aniosLibre < 3) {
                        System.out.println("ERROR: El plazo minimo para Libre Inversion es de 3 años. Intente de nuevo.");
                    }
                } while (aniosLibre < 3);
                creditoA.setPlazo(aniosLibre * 12);
                break;
                
            default:
                System.out.println("Opcion no valida. Se asignara Libre Inversion por defecto con 3 años.");
                creditoA.setTipoCredito(tipoCredito.LIBREINVERSION); 
                creditoA.setTasa(0.05f);
                creditoA.setPlazo(36);
        }
        
        // Tabla
        System.out.println("\n################################");
        System.out.println("INFORMACION DEL CREDITO");
        
        Cliente clienteCredito = creditoA.getCliente();
        System.out.println("Cliente: " + clienteCredito.getNombre() + " " + clienteCredito.getApellido());
        
        int disponible = clienteCredito.calcularCapacidadDePago();
        int superavit = clienteCredito.calcularSuperavitRequerido();
        
        System.out.println("El superavit necesario (35%): $" + superavit);
        System.out.println("La capacidad de pago es: $" + disponible);
        
        if(clienteCredito.esAptoParaCredito()){
            creditoA.obtenerAmortizacion();
        }
        else {
            System.out.println("No es posible realizar la operacion por su capacidad de pago");
        }
        
        sc.close();
        System.out.println("");
        System.out.println("*********************************");
        System.out.println("Este codigo fue modificado por "+CreadorCodigo.FERNANDO_ANDRES_DURAN_MONTOYA);
        System.out.println("*********************************");
    }
    
    
}