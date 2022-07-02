package model;

public class Animal {
    private String nome;
    private double forca;
    private double defesa;
    private double velocidade;

    public Animal(String nome, double forca, double defesa, double velocidade) {
        this.nome = nome;
        this.forca = forca;
        this.defesa = defesa;
        this.velocidade = velocidade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getForca() {
        return forca;
    }

    public double getDefesa() {
        return defesa;
    }

    public double getVelocidade() {
        return velocidade;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setForca(double forca) {
        this.forca = forca;
    }
    
    public void setDefesa(double defesa) {
        this.defesa = defesa;
    }
    
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public String toString() {
        return "\nAnimal{Nome: "+ nome + " | Forca: " + forca + " | Defesa: " + defesa + " | Vlocidade: " + velocidade + "}";
    }
}
