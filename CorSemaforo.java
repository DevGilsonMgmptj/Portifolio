
public enum CorSemaforo {

	VERDE(20000), AMARELO(3000), VERMELHO(10000);
	
	private int tempoEspera;
	
	CorSemaforo(int tempoEspera){
		this.tempoEspera = tempoEspera;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}
	
}
