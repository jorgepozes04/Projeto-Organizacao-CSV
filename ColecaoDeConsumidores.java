public interface ColecaoDeConsumidores {

    public void adicionarConsumidor(Consumidor c);

    public boolean excluirConsumidor(int id);

    public Consumidor obterConsumidor(int posicao);

    public int obterTotalDeConsumidores();

    public boolean trocarPosicao(int posicao1, int posicao2);

    public boolean alterarConsumidor(int posicao, Consumidor novoConsumidor);

    public String toCSV(ColecaoDeConsumidores colecao, int indice);

    public void ordenar(Ordenador ordenador);
}
