import java.util.ArrayList;
import java.util.List;

public class ArrayConsumidores implements ColecaoDeConsumidores {
    private List<Consumidor> consumidores = new ArrayList<>();

    public void adicionarConsumidor(Consumidor c) {
        consumidores.add(c);
    }

    public boolean excluirConsumidor(int id) {
        for (Consumidor consumidor : consumidores) {
            if (consumidor.getId() == id) {
                consumidores.remove(consumidor);
                System.out.println("\n---Consumidor id " + id + " excluído!---\n");
                return true;
            }
        }
        return false;
    }

    public Consumidor obterConsumidor(int posicao) {
        if (validarPosicao(posicao)) {
            return consumidores.get(posicao);
        } else {
            System.out.println("\n---Posição não encontrada!---\n");
            return null;
        }
    }

    public int obterTotalDeConsumidores() {
        return consumidores.size();
    }

    public boolean trocarPosicao(int posicao1, int posicao2) {

        if (validarPosicao(posicao1) && validarPosicao(posicao2)) { // Verificar se as posições existem
            Consumidor auxiliar = consumidores.get(posicao1);
            consumidores.set(posicao1, consumidores.get(posicao2));
            consumidores.set(posicao2, auxiliar);
            return true;
        } else {
            return false;
        }
    }

    public boolean alterarConsumidor(int posicao, Consumidor novConsumidor) {
        if (validarPosicao(posicao)) {
            consumidores.set(posicao, novConsumidor);
            return true;
        }
        return false;
    }

    boolean validarPosicao(int posicao) {
        if (posicao <= this.consumidores.size() - 1) {
            return true;
        }
        return false;
    }

    public void ordenar(Ordenador ordenador) {
        ordenador.ordenar(this);
    }

    public String toCSV(ColecaoDeConsumidores consumidores, int i) {
        return consumidores.obterConsumidor(i).getId() + ", " +
                consumidores.obterConsumidor(i).getAnoNascimento() + ", " +
                consumidores.obterConsumidor(i).getEscolaridade() + ", " +
                consumidores.obterConsumidor(i).getEstCivil() + ", " +
                consumidores.obterConsumidor(i).getRendaAnual() + ", " +
                consumidores.obterConsumidor(i).getVinhos() + ", " +
                consumidores.obterConsumidor(i).getCarnes() + ", " +
                consumidores.obterConsumidor(i).getComprasSite() + ", " +
                consumidores.obterConsumidor(i).getComprasLojas();
    }
}
