package model;
import java.util.ArrayList;
import model.Animal;

public class Jogador {
    
    private String nickName;
    private ArrayList<Animal> listaCartas = new ArrayList();

    public Jogador(String nickname){
        this.nickName = nickname;
    }

    public String getNickName(){
        return nickName;
    }

    public void serNickName(String nickName){
        this.nickName = nickName;
    }

    public ArrayList getListaCartas(){
        return listaCartas;
    }

    public void addAnimal(Animal animal){
        listaCartas.add(animal);
    }

    public String toString() {
        return "JogoCartas{" + "nickName: " + nickName + " | listaCartas: " + listaCartas + "}\n";
    }
    
}