package com.e1;

public class Guitarra {

    private int id;
    private String marcaG;
    private String modeloG;
    private String corG;
    private String cordaG;

    public Guitarra(int id, String marcaG, String modeloG, String corG, String cordaG) {
        this.id = id;
        this.marcaG = marcaG;
        this.modeloG = modeloG;
        this.corG = corG;
        this.cordaG = cordaG;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMarcaG() { return marcaG; }
    public void setMarcaG(String marcaG) { this.marcaG = marcaG; }
    public String getModeloG() { return modeloG; }
    public void setModeloG(String modeloG) { this.modeloG = modeloG; }
    public String getCorG() { return corG; }
    public void setCorG(String corG) { this.corG = corG; }
    public String getCordaG() { return cordaG; }
    public void setCordaG(String cordaG) { this.cordaG = cordaG; }

    @Override
    public String toString() {
        return "Guitarra{" +
                "id=" + id +
                ", marca='" + marcaG + '\'' +
                ", modelo='" + modeloG + '\'' +
                ", cor='" + corG + '\'' +
                ", cordas='" + cordaG + '\'' +
                '}';
    }
}
