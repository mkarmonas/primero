import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecturaEscritura {

	public LecturaEscritura() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		//escribir
		try {
			FileWriter escritor = new FileWriter("Mi archivo",false);
			escritor.write("Hola mundo");
			escritor.write("\r\n");
			escritor.write("En un lugar de la mancha......");
			escritor.close();
			
			System.out.println("Fin de zona: escribir");
		} catch (IOException e) {
			System.out.println("Pete en escribir");
			e.printStackTrace();
		}
		
		System.out.println("Fin de la zona escritura");
		
		//leer
		try {
			FileReader lector = new FileReader("Mi archivo");
			
			int character;
			
			while( (character=lector.read()) != -1 ) {
				System.out.print((char)character);
			}
			lector.close();
			
			System.out.println("Fin de zona: leer");
			
		} catch (IOException e) {
			System.out.println("Pete en leer");
			e.printStackTrace();
		}
		
		//escribir con bufferWriter
		try {
			FileWriter escritor2 = new FileWriter("Mi archivo 2",false);
			BufferedWriter buffEscritor = new BufferedWriter(escritor2);
			
			buffEscritor.write("Hola mundo Buffered");
			buffEscritor.newLine();
			buffEscritor.write("En un lugar buffered......");
			buffEscritor.close();
			
			System.out.println("Fin de zona: bufferWriter");

		} catch (IOException e) {
			System.out.println("Pete en bufferWriter");
			e.printStackTrace();
		}
		
		//leer con bufferWriter
		try {
			FileReader lector2 = new FileReader("Mi archivo 2");
			BufferedReader buffLector = new BufferedReader(lector2);
			
			String linea;
			while( (linea=buffLector.readLine() ) != null ) {
				System.out.println(linea);
			}
			
			lector2.close();
			
			System.out.println("Fin de zona: bufferReader");

		} catch (IOException e) {
			System.out.println("Pete en bufferReader");
			e.printStackTrace();
		}
		
		
		//Creamos un fichero para jugador
		Jugador jugador = new Jugador();
		
		jugador.setNombre("Manolo");
		jugador.setApellidos("Fernández Fernández");
		jugador.setEdad(23);
		jugador.setPosicion("Lateral");
		
		String nombreFichero = jugador.getNombre() +" "+
		                       jugador.getApellidos() +".txt";
		
		try {
			
			FileWriter jugEscritor = new FileWriter(nombreFichero, false);
			BufferedWriter buffJugador = new BufferedWriter(jugEscritor);
			buffJugador.write(jugador.getNombre());
			buffJugador.newLine();
			buffJugador.write(jugador.getApellidos());
			buffJugador.newLine();
			buffJugador.write( Integer.toString(jugador.getEdad()) );
			buffJugador.newLine();
			buffJugador.write(jugador.getPosicion());
			buffJugador.newLine();
			
			buffJugador.close();
			
		} catch (IOException e) {
			System.out.println("Pete en jugador");
			e.printStackTrace();
		}
		
		
	}

}
