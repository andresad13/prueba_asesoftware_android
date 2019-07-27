package com.prueba.prueba_asesoftware.helpers;

public class Utilidades {

    public static final String TABLA_PRODUCTO="productos";
    public static final String CAMPO_PRODUCTO="producto";
    public static final String CAMPO_DESCRIPCION="descripcion";
    public static final String CAMPO_PRECIO="precio";
    public static final String CAMPO_IMG="img";


    public static final String CREAR_TABLA_PRODUCTO="CREATE TABLE " +
            ""+TABLA_PRODUCTO+" ("+CAMPO_PRODUCTO+" " +
            "INTEGER, "+CAMPO_DESCRIPCION+" TEXT,"+CAMPO_PRECIO+" TEXT,"+CAMPO_IMG+")";


}