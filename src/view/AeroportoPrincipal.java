package view;

import java.util.concurrent.Semaphore;

import controller.AeroportoController;

public class AeroportoPrincipal {

	
	
	public static void main(String[] args) {
		
		Semaphore pista1 = new Semaphore(1);
		Semaphore pista2 = new Semaphore(1);
		int nAvioes = 12;
		
		for (int i = 0; i < nAvioes; i++) {
			AeroportoController aeroCon = new AeroportoController(pista1, pista2, (i+1));
			aeroCon.start();
		}
		
		
		
	}
}
