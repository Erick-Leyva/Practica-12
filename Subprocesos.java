/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subprocesos;

/**
 *
 * @author poo02alu07
 */
public class Subprocesos{
	public static void main(String[] args){
		ImprimirSubproceso subproceso1 = new ImprimirSubproceso("subproceso1");
		ImprimirSubproceso subproceso2 = new ImprimirSubproceso("subproceso2");
		ImprimirSubproceso subproceso3 = new ImprimirSubproceso("subproceso3");

		System.err.println("Iniciando subprocesos");

		subproceso1.start();//Invocamos a nuestro propio método run por medio del método run    
		subproceso2.start();
		subproceso3.start();

		System.err.println("Subprocesos iniciados, termina main\n");
	}
}

class ImprimirSubproceso extends Thread{
	private int tiempoInactividad;

	public ImprimirSubproceso(String nombre){
		super(nombre);

		tiempoInactividad = (int)(Math.random() * 5001);
	}

	public void run(){
		try{
			System.err.println(getName() + " estara inactivo durante " + tiempoInactividad+" milisegundos.");

			Thread.sleep(tiempoInactividad); /*La función sleep suspende temporalmente el proceso del hilo dado, en una cantidad
                                                         de milisegundos equivalente al valor de la variable tiempoInactividad*/
		}catch(InterruptedException excepcion){
			excepcion.printStackTrace();
		}

		System.err.println(getName() + " termino su inactividad");
	}
}

