package Ejercicios;


public class productos {
    
    int idProducto;
    String descripcion;
    double precio;
    int cantidad;
    int tipo;

    public productos(int idProducto, String descripcion, double precio, int cantidad, int tipo) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }

    public productos() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "productos{" + "idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad + ", tipo=" + tipo + '}';
    }
    
    
    
}
