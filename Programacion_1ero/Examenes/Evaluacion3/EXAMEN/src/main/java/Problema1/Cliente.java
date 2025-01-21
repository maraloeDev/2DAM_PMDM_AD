package Problema1;

public class Cliente {
    
    private String CIF_cliente;
    private String nombre_cliente;

    public Cliente() {
    }

    public Cliente(String CIF_cliente, String nombre_cliente) {
        this.CIF_cliente = CIF_cliente;
        this.nombre_cliente = nombre_cliente;
    }

    public String getCIF_cliente() {
        return CIF_cliente;
    }

    public void setCIF_cliente(String CIF_cliente) {
        this.CIF_cliente = CIF_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    @Override
    public String toString() {
        return "CIF_cliente " + CIF_cliente + "\n" + 
                "Nombre_cliente " + nombre_cliente;
    }
    
    
    
}
