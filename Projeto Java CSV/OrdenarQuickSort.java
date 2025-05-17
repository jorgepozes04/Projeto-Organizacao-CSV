public class OrdenarQuickSort implements Ordenador {
    public void ordenar(ColecaoDeConsumidores colecao) {
        quickSort(colecao, 0, colecao.obterTotalDeConsumidores() - 1);
    }

    private void quickSort(ColecaoDeConsumidores colecao, int inicio, int fim) {
        if (inicio < fim) {
            int pi = partition(colecao, inicio, fim);
            quickSort(colecao, inicio, pi - 1);
            quickSort(colecao, pi + 1, fim);
        }
    }

    private int partition(ColecaoDeConsumidores colecao, int inicio, int fim) {
        int esquerda = inicio, direita = fim;
        Consumidor pivo = colecao.obterConsumidor(inicio);

        while (esquerda < direita) {
            while (colecao.obterConsumidor(esquerda).getAnoNascimento() <= pivo.getAnoNascimento()
                    && esquerda < fim) {
                esquerda++;
            }
            while (colecao.obterConsumidor(direita).getAnoNascimento() > pivo.getAnoNascimento()
                    && direita > inicio) {
                direita--;
            }
            if (esquerda < direita) {
                colecao.trocarPosicao(esquerda, direita);
            }
        }

        colecao.alterarConsumidor(inicio, colecao.obterConsumidor(direita));
        colecao.alterarConsumidor(direita, pivo);
        return direita;
    }
}
