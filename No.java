public class No {
	private Consumidor consumidor;
	private No proximo;

	public No(Consumidor c) {
		this.consumidor = c;
		this.proximo = null;
	}

	public Consumidor getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(Consumidor c) {
		this.consumidor = c;
	}

	public No obterProximo() {
		return proximo;
	}

	public void definirProximo(No proximo) {
		this.proximo = proximo;
	}

}
