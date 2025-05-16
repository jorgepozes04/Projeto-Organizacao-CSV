public class Consumidor {
    private int id;
    private int anoNascimento;
    private String escolaridade;
    private int nivelEscolaridade;
    private String estCivil;
    private double rendaAnual;
    private int vinhos;
    private int carnes;
    private int comprasSite;
    private int comprasLojas;

    public Consumidor(int id, int anoNascimento, String escolaridade, String estCivil, double rendaAnual,
            int vinhos, int carnes, int comprasSite, int comprasLojas) {
        this.id = id;
        this.anoNascimento = anoNascimento;
        this.escolaridade = escolaridade;
        this.estCivil = estCivil;
        this.rendaAnual = rendaAnual;
        this.vinhos = vinhos;
        this.carnes = carnes;
        this.comprasSite = comprasSite;
        this.comprasLojas = comprasLojas;
        atribuirNivel(escolaridade);
    }

    private void atribuirNivel(String escolaridade) {
        switch (escolaridade) {
            case "Basic":
                this.nivelEscolaridade = 1;
                break;

            case "2n Cycle":
                this.nivelEscolaridade = 2;
                break;

            case "Graduation":
                this.nivelEscolaridade = 3;
                break;

            case "Master":
                this.nivelEscolaridade = 4;
                break;

            case "PhD":
                this.nivelEscolaridade = 5;
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public int getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public int getVinhos() {
        return vinhos;
    }

    public void setVinhos(int vinhos) {
        this.vinhos = vinhos;
    }

    public int getCarnes() {
        return carnes;
    }

    public void setCarnes(int carnes) {
        this.carnes = carnes;
    }

    public int getComprasSite() {
        return comprasSite;
    }

    public void setComprasSite(int comprasSite) {
        this.comprasSite = comprasSite;
    }

    public int getComprasLojas() {
        return comprasLojas;
    }

    public void setComprasLojas(int comprasLojas) {
        this.comprasLojas = comprasLojas;
    }
}