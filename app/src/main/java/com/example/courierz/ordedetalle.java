package com.example.courierz;

public class ordedetalle {
    private String Contenido;
    private String FechaEntrega;
    private String ID_Order;
    private String LugarEntrega;
    private String Receptor;
    private String Precio;
    private String DNI;
    private String Detalle;
    private String Resultado;

    private ordedetalle(){}

    public ordedetalle(String contenido, String fechaEntrega, String ID_Order, String lugarEntrega, String receptor, String precio, String DNI, String detalle, String resultado) {
        Contenido = contenido;
        FechaEntrega = fechaEntrega;
        this.ID_Order = ID_Order;
        LugarEntrega = lugarEntrega;
        Receptor = receptor;
        Precio = precio;
        this.DNI = DNI;
        Detalle = detalle;
        Resultado = resultado;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String resultado) {
        Resultado = resultado;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public String getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        FechaEntrega = fechaEntrega;
    }

    public String getID_Order() {
        return ID_Order;
    }

    public void setID_Order(String ID_Order) {
        this.ID_Order = ID_Order;
    }

    public String getLugarEntrega() {
        return LugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        LugarEntrega = lugarEntrega;
    }

    public String getReceptor() {
        return Receptor;
    }

    public void setReceptor(String receptor) {
        Receptor = receptor;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }
}
