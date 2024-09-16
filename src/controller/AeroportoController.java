package controller;

import java.util.concurrent.Semaphore;

public class AeroportoController extends Thread {
	
	private Semaphore pista1;
	private Semaphore pista2;
	private int iDAviao;
	int escolha;
	
	public AeroportoController(Semaphore pista1, Semaphore pista2, int iDAviao) {
		this.pista1 = pista1;
		this.pista2 = pista2;
		this.iDAviao = iDAviao;
	}
	
	@Override
	public void run() {

		decolagem();
		
	}

	private void decolagem() {
		escolha = (int)((Math.random()*2)+1);
		if (escolha == 1) {
			//pista 1
			System.out.println("O avião #" + iDAviao + " está se dirigindo à pista 1.");
			try {
				pista1.acquire();
				manobrar();
				taxiar();
				decolar();
				afastar();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			} finally {
				pista1.release();
			}
			
			
		} else {
			//pista 2
			System.out.println("O avião #" + iDAviao + " está se dirigindo à pista 2.");
			try {
				pista2.acquire();
				manobrar();
				taxiar();
				decolar();
				afastar();
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			} finally {
				pista2.release();
			}
		}
		
		
	}
	
	private void manobrar() {
		int tempo = (int) ((Math.random() * 401)+300);
		try {
			System.out.println("Avião #" + iDAviao + " está manobrando na pista " + escolha);
			sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void taxiar() {
		int tempo = (int) ((Math.random() * 501)+500);
		try {
			System.out.println("Avião #" + iDAviao + " está taxiando na pista " + escolha);
			sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void decolar() {
		int tempo = (int) ((Math.random() * 201)+600);
		try {
			System.out.println("Avião #" + iDAviao + " está decolando na pista " + escolha);
			sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void afastar() {
		int tempo = (int) ((Math.random() * 500)+300);
		try {
			System.out.println("Operativos estão se afastando da área. Preparar para próximo avião...");
			sleep(tempo);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}
