package patron.factorymethod.abstracta;

import java.util.ArrayList;
import java.util.List;

/* Es un patr�n creacional, que permite crear distintos �productos� (objetos),
 * sin necesidad de especificar la clase exacta del objeto que necesita ser creado
 * ---> Permite distintas creaciones de objetos, dependiendo del contexto.
 * ---> En Java, se implementa normalmente con una clase abstracta (para el creador)  */
public abstract class MazeGame {
	/*{Permite crearle al laberito habitaciones, pero no define el tipo}*/
	/*{En BD esta ser�a el manejador de conexiones: makeRoom() ser�a makeConnection(),
	 * y conectar�a a Derby (MagicMazeGame) o MySQL (OrdinaryMazeGame).}*/
	/*{Suele ser singleton.}*/
	private final List<Room> rooms = new ArrayList<>();
	public MazeGame() {
		//#regionabstractfactory
		Room room1 = makeRoom();
		Room room2 = makeRoom();
		//#endregion
		room1.connect(room2);
		rooms.add(room1);
		rooms.add(room2);
	}
	//#regionfactorymethod
	/*{M�todo creador: No puede hacerse un new de Room, ya que esta clase es abstracta.
	 * Si le definiera el tipo a Room, se queda atado al subtipo y pierde flexibilidad el c�digo}*/ 
	abstract protected Room makeRoom();
	//#endregion
}