package jogo.cartas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Animal;
import model.Jogador;

public class Main {
    private static ArrayList<Animal> baralho = new ArrayList();
    private static ArrayList<Jogador> jogadores = new ArrayList();
    
    public static void main(String[] args) {
        telaPrincipal();
    }
    
    public static void telaPrincipal(){
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu Principal \n" +
                    "1- Jogar \n" + 
                    "2- Adicionar animal \n" +
                    "3- Exibir lista de animais \n" +
                    "4- Sair"));
            
            switch(opcao){
                case 1:
                    iniciarJogo();
                    break;
                case 2:
                    criarAnimal();
                    break;
                case 3:
                    exibirAnimais();
                    break;
            }
        }while(opcao != 4);
   
    }
    
    public static void criarAnimal(){
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantas cartas você vai " + "querer adicionar?"));
        
        for(int i = 0; i< quantidade; i++){
            //Cabeçario
            String mensagemTela = "CRIANDO ANIMAL";
            mensagemTela += "\nAdicionando a "+ (i+1) + "° carta: \n";
            
            //Escritas das atribuições
            String nome = JOptionPane.showInputDialog(mensagemTela + "\n" +
                    "Informe um nome para o animal:");
            double forca = Double.parseDouble(JOptionPane.showInputDialog(mensagemTela + "\n" +
                    "Informe um valor para a força:"));
            double defesa = Double.parseDouble(JOptionPane.showInputDialog(mensagemTela + "\n" +
                    "Informe um valor para a defesa:"));
            double velocidade = Double.parseDouble(JOptionPane.showInputDialog(mensagemTela + "\n" +
                    "Informe um valor para a velocidade:"));
            
            //Adicionar animal
            baralho.add(new Animal(nome, forca, defesa, velocidade));
            
            //Demonstração visual
            JOptionPane.showMessageDialog(null, "A " + (i+1) + "° carta foi adicionada: \n" + baralho.get(i));
        }
    }
    
    public static void iniciarJogador(String nome){
        jogadores.add(new Jogador(nome));
    }
    
    public static void iniciarJogo(){
        iniciarJogador(
        JOptionPane.showInputDialog("Informe um nickname para o jogador 1:"));
        selecaoDeCartas(jogadores.get(0));
        
        iniciarJogador(
        JOptionPane.showInputDialog("Informe um nickname para o jogador 2:"));
        selecaoDeCartas(jogadores.get(1));
        
        iniciarBatalha();
        
        jogadores.removeAll(jogadores);
    }
    
    public static void iniciarBatalha(){
        String ganhadorRodada = "";
        do{
            
            int atributoRodada = Integer.parseInt(
                    JOptionPane.showInputDialog("SELEÇÃO DE ATRIBUTO \n"
                    + "1 - Força \n"
                    + "2 - Defesa \n"
                    + "3 - Velocidade \n"));

            switch(atributoRodada){
                case 1:
                    ganhadorRodada = compararForca();
                    break;
                case 2:
                    ganhadorRodada = compararDefesa();
                    break;
                case 3:
                    ganhadorRodada = compararVelocidade();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }

            if(!(ganhadorRodada.equals("empate"))){
                JOptionPane.showMessageDialog(null, "O ganhador da rodada foi: " + ganhadorRodada);
            }
            else{
                JOptionPane.showMessageDialog(null, "Empate! ");
            }
        }while(jogadores.get(0).getListaCartas().size() > 0 && jogadores.get(1).getListaCartas().size() > 0);
        JOptionPane.showMessageDialog(null, "O ganhador do jogo foi: " + ganhadorRodada);
    }
    
    public static String compararForca(){
        ArrayList<Animal> listaCartasJogadorUm = jogadores.get(0).getListaCartas();
        ArrayList<Animal> listaCartasJogadorDois = jogadores.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(0).getForca() > listaCartasJogadorDois.get(0).getForca()){
            removerAnimal(jogadores.get(1).getListaCartas(), 0);
            return jogadores.get(0).getNickName();
        }
        else if(listaCartasJogadorUm.get(0).getForca() < listaCartasJogadorDois.get(0).getForca()){
            removerAnimal(jogadores.get(0).getListaCartas(), 0);
            return jogadores.get(1).getNickName();
        }
        else{
            return "empate";
        }
    }
    
    public static String compararDefesa(){
        ArrayList<Animal> listaCartasJogadorUm = jogadores.get(0).getListaCartas();
        ArrayList<Animal> listaCartasJogadorDois = jogadores.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(0).getDefesa() > listaCartasJogadorDois.get(0).getDefesa()){
            removerAnimal(jogadores.get(1).getListaCartas(), 0);
            return jogadores.get(0).getNickName();
        }
        else if(listaCartasJogadorUm.get(0).getForca() < listaCartasJogadorDois.get(0).getForca()){
            removerAnimal(jogadores.get(0).getListaCartas(), 0);
            return jogadores.get(1).getNickName();
        }
        else{
            return "empate";
        }
    }
    
    public static String compararVelocidade(){
        ArrayList<Animal> listaCartasJogadorUm = jogadores.get(0).getListaCartas();
        ArrayList<Animal> listaCartasJogadorDois = jogadores.get(1).getListaCartas();
        
        if(listaCartasJogadorUm.get(0).getVelocidade() > listaCartasJogadorDois.get(0).getVelocidade()){
            removerAnimal(jogadores.get(1).getListaCartas(), 0);
            return jogadores.get(0).getNickName();
        }
        else if(listaCartasJogadorUm.get(0).getForca() < listaCartasJogadorDois.get(0).getForca()){
            removerAnimal(jogadores.get(0).getListaCartas(), 0);
            return jogadores.get(1).getNickName();
        }
        else{
            return "empate";
        }
    }
    
    public static void selecaoDeCartas(Jogador jogador){
        
        //Gerar copia do baralho para gerar a lista
        ArrayList<Animal> baralhoAux = new ArrayList();
        
        for(int i = 0; i< baralho.size(); i++){
            baralhoAux.add(baralho.get(i));
        }
        
        //Gerar lista de cartas para visualização
        for(int j = 0; j < baralho.size()/2; j++){
            String lista = "";

            for(int i=0; i < baralhoAux.size(); i++){
                lista += i + " - " + baralhoAux.get(i).getNome() + "\n";
            }

            //Visualização do menu de cartas do jogador
            int posicaoDaCarta = Integer.parseInt(
                    JOptionPane.showInputDialog(
                        "SELEÇÃO DE CARTAS DO JOGADOR: " + jogador.getNickName() + "\n" + lista + "\nEscolha uma carta:"));

            jogador.addAnimal(baralhoAux.get(posicaoDaCarta));
            baralhoAux.remove(posicaoDaCarta);
        }
    }
    
    public static void exibirAnimais(){
        JOptionPane.showMessageDialog(null, "BARALHO DE ANIMAIS: \n"
            + baralho.toString());
    }
    
    public static void removerAnimal(ArrayList lista, int posicao){
        lista.remove(posicao);
    }
}