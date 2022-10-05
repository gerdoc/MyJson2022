package com.example.myjson.json;

import java.io.Serializable;

public class MyInfo implements Serializable
{
    private String nombre;
    private Integer edad;
    private Float calificacion;
    private Boolean sexo;

    public MyInfo()
    {
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Integer getEdad()
    {
        return edad;
    }

    public void setEdad(Integer edad)
    {
        this.edad = edad;
    }

    public Float getCalificacion()
    {
        return calificacion;
    }

    public void setCalificacion(Float calificacion)
    {
        this.calificacion = calificacion;
    }

    public Boolean getSexo()
    {
        return sexo;
    }

    public void setSexo(Boolean sexo)
    {
        this.sexo = sexo;
    }


}

