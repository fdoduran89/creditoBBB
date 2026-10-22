package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import negocio.Asesor;
import negocio.Cliente;
import negocio.Credito;
import negocio.Director;
import negocio.Empleado;
import negocio.Vinculacion;
import negocio.tipoCredito;
import negocio.CreadorCodigo;
import servicios.ServLiquidacionSalario;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        // 1. CREACION DE LOS EMPLEADOS
        Asesor asesor = new Asesor();
        Director director = new Director(); // Ya nace con nombre, salario y retención

        System.out.println("=========================================");
        System.out.println("   SISTEMA DE CREDITOS - BANCO PROMAX");
        System.out.println("=========================================");
        
        // Pedimos el nombre del asesor (el que atiende al cliente)
        System.out.print("Ingrese el nombre del asesor: ");
        asesor.setNombre(sc.nextLine());
        
        // 2. CREACION DEL CLIENTE
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
        
        // 3. SOLICITUD DEL CREDITO
        Credito creditoA = new Credito();        
        creditoA.setCliente(clienteA);
        System.out.print("Ingrese el monto a solicitar: $");
        creditoA.setMonto(sc.nextFloat());
        
        int opcion = 0;
        tipoCredito tipoElegido = null;
        do {
            System.out.println("\nSeleccione el tipo de credito:");
            System.out.println("1. Vehiculo");
            System.out.println("2. Vivienda");
            System.out.println("3. Libre Inversion");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1: tipoElegido = tipoCredito.VEHICULO; break;
                case 2: tipoElegido = tipoCredito.VIVIENDA; break;
                case 3: tipoElegido = tipoCredito.LIBREINVERSION; break;
                default:
                    System.out.println("ERROR: Opcion no valida. Seleccione 1, 2 o 3.");
                    tipoElegido = null;
            }
        } while (tipoElegido == null);
        
        int anios = 0;
        boolean plazoValido = false;
        do {
            System.out.print("Ingrese el plazo en años (Minimo " + tipoElegido.getPlazoMinimoAnios() + "): ");
            anios = sc.nextInt();
            plazoValido = creditoA.configurarDesdeEnum(tipoElegido, anios);
            if (!plazoValido) {
                System.out.println("ERROR: El plazo minimo es de " + tipoElegido.getPlazoMinimoAnios() + " años.");
            }
        } while (!plazoValido);
        
        // 4. VALIDACION Y RESULTADOS
        System.out.println("\n################################");
        System.out.println("INFORMACION DEL CREDITO");
        
        Cliente clienteCredito = creditoA.getCliente();
        System.out.println("Cliente: " + clienteCredito.getNombre() + " " + clienteCredito.getApellido());
        
        int disponible = clienteCredito.calcularCapacidadDePago();
        int superavit = clienteCredito.calcularSuperavitRequerido();
        
        System.out.println("El superavit necesario (35%): $" + superavit);
        System.out.println("La capacidad de pago es: $" + disponible);
        
        if(clienteCredito.esAptoParaCredito()){
            
            // 5. TABLA DE AMORTIZACION
            creditoA.obtenerAmortizacion();
            
            // 6. LIQUIDACION DE SALARIOS Y COMISIONES
            System.out.println("\n################################");
            System.out.println("LIQUIDACION DE NOMINA Y COMISIONES");
            
            // Le pasamos el crédito aprobado al asesor y al director para que calculen su comisión
            asesor.setCreditoAprobado(creditoA);
            director.setCreditoAprobado(creditoA);
            
            List<Empleado> empleados = new ArrayList<>();
            empleados.add(asesor);
            empleados.add(director);
            
            ServLiquidacionSalario servicio = new ServLiquidacionSalario();
            servicio.liquidarSueldo(empleados);
            
        }
        else {
            System.out.println("No es posible realizar la operacion por su capacidad de pago");
        }
        
        sc.close();
        
        System.out.println("");
        System.out.println("*********************************");
        System.out.println("Este codigo fue modificado por " + CreadorCodigo.FERNANDO_ANDRES_DURAN_MONTOYA);
        System.out.println("*********************************");
    }
}