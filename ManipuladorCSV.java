import java.io.*;

public class ManipuladorCSV {

    public static ColecaoDeConsumidores lerCSV(String caminho, ColecaoDeConsumidores lista) {

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha = br.readLine(); // cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split("\t");

                try {
                    int id = Integer.parseInt(dados[0]);
                    int yearBirth = Integer.parseInt(dados[1]);
                    String education = dados[2];
                    String maritalStatus = dados[3];
                    double income = Double.parseDouble(dados[4]);
                    int mntWines = Integer.parseInt(dados[9]);
                    int mntMeatProducts = Integer.parseInt(dados[10]);
                    int numWebPurchases = Integer.parseInt(dados[15]);
                    int numStorePurchases = Integer.parseInt(dados[17]);

                    Consumidor consumidor = new Consumidor(id, yearBirth, education, maritalStatus, income,
                            mntWines, mntMeatProducts, numWebPurchases, numStorePurchases);
                    lista.adicionarConsumidor(consumidor);
                } catch (Exception e) {
                    // Ignora registros com campos inválidos ou nulos
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return lista;
    }

    public static void escreverCSV(ColecaoDeConsumidores consumidores, String caminhoSaida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoSaida))) {
            bw.write(
                    "ID, Ano Nascimento, Escolaridade, Estado Civil, Renda Anual, Vinhos, Carnes, Compras em Sites, Compras em Lojas Físicas");
            bw.newLine();

            for (int i = 0; i < consumidores.obterTotalDeConsumidores(); i++) {
                String linha = consumidores.obterConsumidor(i).getId() + ", " +
                        consumidores.obterConsumidor(i).getAnoNascimento() + ", " +
                        consumidores.obterConsumidor(i).getEscolaridade() + ", " +
                        consumidores.obterConsumidor(i).getEstCivil() + ", " +
                        consumidores.obterConsumidor(i).getRendaAnual() + ", " +
                        consumidores.obterConsumidor(i).getVinhos() + ", " +
                        consumidores.obterConsumidor(i).getCarnes() + ", " +
                        consumidores.obterConsumidor(i).getComprasSite() + ", " +
                        consumidores.obterConsumidor(i).getComprasLojas();
                bw.write(linha);
                bw.newLine();
            }

            System.out.println("Arquivo exportado com sucesso: " + caminhoSaida);
        } catch (IOException e) {
            System.out.println("Erro ao escrever arquivo: " + e.getMessage());
        }
    }
}