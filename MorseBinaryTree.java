// Classe que representa a árvore binária de Morse
class MorseBinaryTree {
    
    private Node raiz; // Nodo raiz da árvore

    // Construtor: cria uma árvore vazia com a raiz sendo um nodo vazio
    public MorseBinaryTree() {
        raiz = new Node(); // Inicializa a raiz
    }

    // Método para inserir um caractere e seu código Morse na árvore
    public void inserir(String codigoMorse, char caractere) {
        Node atual = raiz; // Começa a partir da raiz

        // Percorre cada símbolo do código Morse
        for (int i = 0; i < codigoMorse.length(); i++) {
            char simbolo = codigoMorse.charAt(i); // Obtém o símbolo atual ('.' ou '-')
            
            // Se o símbolo for '.', vai para o filho à esquerda
            if (simbolo == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new Node(); // Cria um novo nodo à esquerda, se não existir
                }
                atual = atual.esquerda; // Move para o próximo nodo à esquerda
            }
            // Se o símbolo for '-', vai para o filho à direita
            else if (simbolo == '-') {
                if (atual.direita == null) {
                    atual.direita = new Node(); // Cria um novo nodo à direita, se não existir
                }
                atual = atual.direita; // Move para o próximo nodo à direita
            }
        }
        atual.caractere = caractere; // Atribui o caractere no final do caminho
    }

    // Método para buscar um caractere usando o código Morse
    public char buscar(String codigoMorse) {
        Node atual = raiz; // Começa pela raiz

        // Percorre cada símbolo do código Morse
        for (int i = 0; i < codigoMorse.length(); i++) {
            char simbolo = codigoMorse.charAt(i); // Obtém o símbolo atual ('.' ou '-')
            
            // Se o símbolo for '.', move para o filho à esquerda
            if (simbolo == '.') {
                atual = atual.esquerda;
            }
            // Se o símbolo for '-', move para o filho à direita
            else if (simbolo == '-') {
                atual = atual.direita;
            }

            // Se chegar a um nodo nulo, o caractere não foi encontrado
            if (atual == null) {
                return '\0'; // Retorna '\0' indicando que não achou
            }
        }

        return atual.caractere; // Retorna o caractere encontrado no final do caminho
    }

    // Método para exibir toda a árvore (de forma simples)
    public void exibirArvore() {
        exibirRecursivo(raiz, ""); // Chama o método recursivo para mostrar a árvore
    }

    // Método recursivo para exibir a árvore
    private void exibirRecursivo(Node nodo, String prefixo) {
        if (nodo == null) { // Se o nodo for nulo, não faz nada
            return;
        }

        // Imprime o caractere, se houver
        if (nodo.caractere != '\0') {
            System.out.println(prefixo + nodo.caractere);
        }

        // Exibe recursivamente os filhos esquerdo e direito
        exibirRecursivo(nodo.esquerda, prefixo + ". ");
        exibirRecursivo(nodo.direita, prefixo + "- ");
    }

    // Classe interna para representar um nodo da árvore
    private class Node {
        char caractere; // O caractere armazenado no nodo
        Node esquerda;  // Filho à esquerda
        Node direita;   // Filho à direita

        // Construtor: cria um nodo vazio
        public Node() {
            caractere = '\0'; // Caractere vazio por padrão
            esquerda = null;  // Nenhum filho à esquerda
            direita = null;   // Nenhum filho à direita
        }
    }
}
