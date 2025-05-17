public class Principal {
    public static void main(String[] args) {
        String caminhoEntrada = "marketing_campaign.csv";
        String caminhoSaida = "consumidores_filtrados.csv";

        // Instanciar a lista
        // Pode ser do tipo ArrayConsumidores() ou ListaEncadeadaConsumidores()
        ColecaoDeConsumidores listaConsumidores = new ListaEncadeadaConsumidores();

        // Ler o arquivo
        listaConsumidores = ManipuladorCSV.lerCSV(caminhoEntrada, listaConsumidores);

        // Escrever no arquivo destino
        ManipuladorCSV.escreverCSV(listaConsumidores, caminhoSaida);

        // Instanciar os tipos de ordenação
        Ordenador ordenarEscolaridade = new OrdenarBubbleSort();
        Ordenador ordenarAnoNascimento = new OrdenarQuickSort();

        listaConsumidores.ordenar(ordenarAnoNascimento);

        ManipuladorCSV.escreverCSV(listaConsumidores, "ordenado_ano_nascimento.csv");

        listaConsumidores.ordenar(ordenarEscolaridade);

        ManipuladorCSV.escreverCSV(listaConsumidores, "ordenado_escolaridade.csv");
    }
}