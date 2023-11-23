import javax.swing.*;
import java.util.Stack;

public class Hanoi {
    static Stack<Integer> origem = new Stack<>();
    static Stack<Integer> destino = new Stack<>();
    static Stack<Integer> auxiliar = new Stack<>();
    static int movimentos = 0;
    static StringBuilder movimentosStr = new StringBuilder();

    static void mover(int n, Stack<Integer> origem, Stack<Integer> destino, Stack<Integer> auxiliar) {
        if (n > 0) {
            mover(n - 1, origem, auxiliar, destino);
            destino.push(origem.pop());
            movimentos++;
            desenharTorre();
            mover(n - 1, auxiliar, destino, origem);
        }
    }

    static void desenharTorre() {
        movimentosStr.append("Movimento ").append(movimentos).append(":\n")
                     .append("Origem: ").append(origem).append("\n")
                     .append("Destino: ").append(destino).append("\n")
                     .append("Auxiliar: ").append(auxiliar).append("\n\n");
    }

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Quantos discos deseja adicionar?", "Torres de Hanói", JOptionPane.QUESTION_MESSAGE);
        int n = Integer.parseInt(input);
        for (int i = n; i > 0; i--) {
            origem.push(i);
        }
        desenharTorre();
        mover(n, origem, destino, auxiliar);
        
        JTextArea textArea = new JTextArea(20, 30);
        textArea.setText(movimentosStr.toString());
        textArea.setCaretPosition(0);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane, "Solução", JOptionPane.INFORMATION_MESSAGE);
    }
}