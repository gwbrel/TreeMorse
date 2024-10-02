import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Cria a árvore binária Morse
        MorseBinaryTree arvore = new MorseBinaryTree();

        // Insere o código Morse para as letras A-Z e os números 0-9
        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');
        arvore.inserir("-----", '0');
        arvore.inserir(".----", '1');
        arvore.inserir("..---", '2');
        arvore.inserir("...--", '3');
        arvore.inserir("....-", '4');
        arvore.inserir(".....", '5');
        arvore.inserir("-....", '6');
        arvore.inserir("--...", '7');
        arvore.inserir("---..", '8');
        arvore.inserir("----.", '9');

        // Testa a busca de alguns códigos Morse
        System.out.println("\nResultados de busca:");
        System.out.println("'.-' representa: " + arvore.buscar(".-"));
        System.out.println("'...' representa: " + arvore.buscar("..."));
        System.out.println("'--' representa: " + arvore.buscar("--"));
        System.out.println("'.----' representa: " + arvore.buscar(".----"));

        // Entrada do usuário para decodificar mensagens Morse
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nDigite uma mensagem em código Morse (separe com espaço, ou 'q' para sair):");
            String entrada = scanner.nextLine().trim(); // Lê a entrada do usuário

            if (entrada.equalsIgnoreCase("q")) { // Sai do loop se o usuário digitar 'q'
                break;
            }

            // Decodifica a mensagem em Morse
            System.out.print("Mensagem decodificada: ");
            String[] codigosMorse = entrada.split(" "); // Divide os caracteres Morse

            for (String codigo : codigosMorse) {
                char resultado = arvore.buscar(codigo); // Busca o caractere
                if (resultado != '\0') {
                    System.out.print(resultado); // Exibe o caractere encontrado
                } else {
                    System.out.print("?"); // Exibe '?' se não for encontrado
                }
            }
            System.out.println(); // Linha final após a decodificação
        }
        scanner.close(); // Fecha o scanner
        System.out.println("Programa encerrado.");
    }
}

// Classe básica para a árvore binária de código Morse
class MorseBinaryTree {
    Node raiz; // Nodo raiz da árvore

    // Construtor: cria uma árvore vazia
    public MorseBinaryTree() {
        raiz = new Node();
    }

    // Insere um caractere e seu código Morse na árvore
    public void inserir(String codigoMorse, char caractere) {
        Node atual = raiz; // Começa na raiz
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') { // Se for '.', vai para a esquerda
                if (atual.esquerda == null) {
                    atual.esquerda = new Node();
                }
                atual = atual.esquerda;
            } else if (simbolo == '-') { // Se for '-', vai para a direita
                if (atual.direita == null) {
                    atual.direita = new Node();
                }
                atual = atual.direita;
            }
        }
        atual.caractere = caractere; // Atribui o caractere no nodo final
    }

    // Busca o caractere associado a um código Morse
    public char buscar(String codigoMorse) {
        Node atual = raiz; // Começa na raiz
        for (char simbolo : codigoMorse.toCharArray()) {
            if (simbolo == '.') {
                atual = atual.esquerda;
            } else if (simbolo == '-') {
                atual = atual.direita;
            }
            if (atual == null) { // Se não encontrar o caminho, retorna '\0'
                return '\0';
            }
        }
        return atual.caractere; // Retorna o caractere no nodo final
    }

    // Classe interna para os nós da árvore
    class Node {
        char caractere = '\0'; // Caractere armazenado no nodo (inicialmente vazio)
        Node esquerda; // Nodo filho à esquerda
        Node direita;  // Nodo filho à direita
    }
}
