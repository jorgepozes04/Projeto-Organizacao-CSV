public class ListaEncadeadaConsumidores implements ColecaoDeConsumidores {

	No noInicial = null;
	int totalDeElementos = 0;

	public void adicionarConsumidor(Consumidor consumidor) {
		No novoNo = new No(consumidor);
		No noAtual = this.noInicial;
		if (this.noInicial != null) {
			while (noAtual.obterProximo() != null) {
				noAtual = noAtual.obterProximo();
			}
			noAtual.definirProximo(novoNo);
		} else {
			this.noInicial = novoNo;
		}
		this.totalDeElementos++;
	}

	@Override
	public boolean excluirConsumidor(int id) {
		No noAtual = this.noInicial;
		No noAnterior = null;
		while (noAtual != null) {
			if (noAtual.getConsumidor().getId() == id) {
				noAnterior.definirProximo(noAtual.obterProximo());
				this.totalDeElementos--;
				System.out.println("\n---Consumidor id " + id + " excluído!---\n");
				return true;
			} else {
				noAnterior = noAtual;
				noAtual = noAtual.obterProximo();
			}
		}
		return false;
	}

	@Override
	public Consumidor obterConsumidor(int posicaoBuscada) {
		int posicaoAtual = 0;
		No noAtual = this.noInicial;
		while ((noAtual != null) && (posicaoAtual != posicaoBuscada)) {
			noAtual = noAtual.obterProximo();
			posicaoAtual++;
		}
		if (posicaoAtual == posicaoBuscada) {
			return noAtual.getConsumidor();
		}
		return null;
	}

	@Override
	public int obterTotalDeConsumidores() {
		return this.totalDeElementos;
	}

	public boolean trocarPosicao(int posicao1, int posicao2) {
		Consumidor consumidor1 = null, consumidor2 = null;
		No noAtual = this.noInicial;
		int posicaoAtual = 0;

		// Verificar se as posições solicitadas existem
		if (posicao1 < this.totalDeElementos && posicao2 < this.totalDeElementos) {

			// Encontrar e armazenar o consumidor das posições solicitadas
			while (posicaoAtual != posicao1) {
				noAtual = noAtual.obterProximo();
				posicaoAtual++;
			}
			if (posicaoAtual == posicao1) {
				consumidor1 = obterConsumidor(posicaoAtual);
			}

			while (posicaoAtual != posicao2) {
				noAtual = noAtual.obterProximo();
				posicaoAtual++;
			}
			if (posicaoAtual == posicao2) {
				consumidor2 = obterConsumidor(posicaoAtual);
			}

			// Reiniciar a lista
			posicaoAtual = 0;
			noAtual = this.noInicial;

			// Encontrar e realizar a troca dos consumidores
			while (posicaoAtual != posicao1) {
				noAtual = noAtual.obterProximo();
				posicaoAtual++;
			}

			if (posicaoAtual == posicao1) {
				noAtual.setConsumidor(consumidor2);
			}

			while (posicaoAtual != posicao2) {
				noAtual = noAtual.obterProximo();
				posicaoAtual++;
			}

			if (posicaoAtual == posicao2) {
				noAtual.setConsumidor(consumidor1);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean alterarConsumidor(int posicaoBuscada, Consumidor novoConsumidor) {
		int posicaoAtual = 0;
		No noAtual = this.noInicial;

		while (posicaoAtual != posicaoBuscada) {
			noAtual = noAtual.obterProximo();
			posicaoAtual++;
		}

		if (posicaoAtual == posicaoBuscada) {
			noAtual.setConsumidor(novoConsumidor);
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