package lotofacil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;


public class LotofacilGUI extends JFrame{
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Apostar de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Apostar de A a Z");
    private JButton jButtonAposta3 = new JButton("Apostar par ou ímpar");
    private JLabel jLabelMensagem = new JLabel("Exemplo de Simples Janela");

    private static void aposta1() {
        String input = JOptionPane.showInputDialog(null, "Digite sua aposta, de 0 a 100: ");
        Random rnd = new Random();
        int sorteio = rnd.nextInt(101);
        int numeroDigitado = Integer.parseInt(input);
        if(numeroDigitado == sorteio){
            JOptionPane.showMessageDialog(null, "Você ganhou milzão.");
        }else{
            JOptionPane.showMessageDialog(null, "Você perdeu!, o número sorteado foi: " + sorteio);
        }
    }
    private static void aposta2() throws IOException {
        char letraSorteada = 'J';
        String input = JOptionPane.showInputDialog(null, "Digite a letra de A a Z ");

        if (input != null && input.length() == 1) {
            char letraApostada = input.toUpperCase().charAt(0);
            if (Character.isLetter(letraApostada)) {
                if (letraApostada == letraSorteada) {
                    JOptionPane.showMessageDialog(null, "Você ganhou quinhentão.");
                } else {
                    JOptionPane.showMessageDialog(null, "Você perdeu!, a letra sorteada foi: " + letraSorteada + "\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não é uma letra válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite uma única letra.");
        }
    }

    private static void aposta3() {
        String input = JOptionPane.showInputDialog(null, "Digite um número de 0 a 100:");
        int numeroDigitado = Integer.parseInt(input);
        if(numeroDigitado % 2 == 0){
            JOptionPane.showMessageDialog(null, "Você ganhou cenzão.");
        }else{
            JOptionPane.showMessageDialog(null, "Você perdeu! A aposta correta era um número par");
        }
    }

    // Construtor
    public LotofacilGUI(){
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        painel.add(jButtonAposta1); painel.add(jButtonAposta2); painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela

        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta1();
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    aposta2();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta3();
            }
        });

    }
    public static void main(String[] args) {new LotofacilGUI();}
}
