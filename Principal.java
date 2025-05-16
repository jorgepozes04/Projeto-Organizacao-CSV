public class Principal {
    public static void main(String[] args) {
        String caminhoEntrada = "marketing_campaign.csv";
        String caminhoSaida = "consumidores_filtrados.csv";

        ColecaoDeConsumidores listaConsumidores = new ListaEncadeadaConsumidores();

        listaConsumidores = ManipuladorCSV.lerCSV(caminhoEntrada, listaConsumidores);
        ManipuladorCSV.escreverCSV(listaConsumidores, caminhoSaida);

        Ordenador ordenarEscolaridade = new OrdenarBubbleSort();
        Ordenador ordenarAnoNascimento = new OrdenarQuickSort();

        listaConsumidores.ordenar(ordenarAnoNascimento);

        ManipuladorCSV.escreverCSV(listaConsumidores, "ordenado_ano_nascimento.csv");

        listaConsumidores.ordenar(ordenarEscolaridade);

        ManipuladorCSV.escreverCSV(listaConsumidores, "ordenado_escolaridade.csv");
    }
}