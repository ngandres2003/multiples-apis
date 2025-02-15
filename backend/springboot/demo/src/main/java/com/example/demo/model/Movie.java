package com.example.demo.model;

public class Movie {
    private int id;
    private String nombre;
    private String director;
    private int ano;
    private String genero;
    private int duracion;

    // Constructor con todos los campos
    public Movie(int id, String nombre, String director, int ano, String genero, int duracion) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.ano = ano;
        this.genero = genero;
        this.duracion = duracion;
    }

    // Constructor vacío
    public Movie() {
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
