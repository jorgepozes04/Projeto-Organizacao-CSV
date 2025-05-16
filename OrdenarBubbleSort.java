public class OrdenarBubbleSort implements Ordenador {
    public void ordenar(ColecaoDeConsumidores colecao) {
        boolean existiuTroca;
        do {
            existiuTroca = false;
            for (int i = 0; i < colecao.obterTotalDeConsumidores() - 1; i++) {
                if (colecao.obterConsumidor(i).getNivelEscolaridade() > colecao.obterConsumidor(i + 1)
                        .getNivelEscolaridade()) {
                    colecao.trocarPosicao(i, i + 1);
                    existiuTroca = true;
                }
            }
        } while (existiuTroca);
    }
}
