
public class iPhone implements ReprodutorMusical, AparelhoTelefonico, NavegadorInternet{
	
	 // Métodos da ReprodutorMusical
    @Override
    public void tocar() {
        System.out.println("Tocando música...");
    }

    @Override
    public void pausar() {
        System.out.println("Música pausada.");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Música selecionada: " + musica);
    }

    // Métodos do AparelhoTelefonico
    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para: " + numero);
    }

    @Override
    public void atender() {
        System.out.println("Atendendo chamada...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz.");
    }

    // Métodos do NavegadorInternet
    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo página: " + url);
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Nova aba adicionada.");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada.");
    }
    public static void main(String[] args) {
    	iPhone meuIphone = new iPhone();
        //Testando
        
        meuIphone.selecionarMusica("ALONE - Navjaxx Beats");
        meuIphone.tocar();
        meuIphone.pausar();
        
        
        meuIphone.ligar("123456789");
        meuIphone.atender();
        meuIphone.iniciarCorreioVoz();
        
        
        meuIphone.exibirPagina("https://web.dio.me");
        meuIphone.adicionarNovaAba();
        meuIphone.atualizarPagina();
		
	}

}
