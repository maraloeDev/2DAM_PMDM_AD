package Problema1;


public class Movimientos {
    
    int id_movimiento;
    String CIF;
    String cliente;
    String operacion;

    public Movimientos() {
    }

    public Movimientos(int id_movimiento, String CIF, String cliente, String operacion) {
        this.id_movimiento = id_movimiento;
        this.CIF = CIF;
        this.cliente = cliente;
        this.operacion = operacion;
    }

    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public String toString() {
        return "Movimientos{" + "id_movimiento=" + id_movimiento + ", CIF=" + CIF + ", cliente=" + cliente + ", operacion=" + operacion + '}';
    }
    
    
    
}
