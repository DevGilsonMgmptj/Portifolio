public class ThreadSemaforo implements Runnable{
	
	private CorSemaforo cor;
	private boolean parar;
	private boolean corMudou;
	
	public ThreadSemaforo() {
		this.cor = CorSemaforo.VERDE;
		
		
	new Thread(this).start();	
	}
	public void run() {
		while(!parar) {
			switch(this.cor) {
			case VERMELHO:
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case AMARELO:
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			
			case VERDE:
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			default:
				break;		
			}
			this.mudarCor();	
		}
		}
		


private synchronized void mudarCor() {
	switch(this.cor) {
	case VERMELHO:
		this.cor = CorSemaforo.VERDE;
		break;
	case VERDE:
		this.cor = CorSemaforo.AMARELO;
		break;
	case AMARELO:
		this.cor = CorSemaforo.VERMELHO;
		break;
	default:
		break;
	}
	this.corMudou = true;
	notify();
}
public synchronized void esperaCorMudar() {
	while(!this.corMudou) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	this.corMudou = false;
}
 public synchronized void desligaarSemaforo() {
	 this.parar;
 }
public CorSemaforo getCor() {
	return cor;
}

}