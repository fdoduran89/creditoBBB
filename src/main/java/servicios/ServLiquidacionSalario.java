package servicios;

import java.util.List;
import negocio.Empleado;

public class ServLiquidacionSalario {
    
    public void liquidarSueldo(List<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            float total = empleado.liquidarSalario();
            float comision = empleado.getComision();
            
            System.out.println("Empleado: " + empleado.getNombre());
            System.out.println("  Salario Base: $" + Math.round(empleado.getSalarioBase() - empleado.getRetencion()));
            System.out.println("  Comisión:     $" + Math.round(comision));
            System.out.println("  TOTAL A PAGAR:$" + Math.round(total));
            System.out.println("-----------------------------------");
        }
    }
}