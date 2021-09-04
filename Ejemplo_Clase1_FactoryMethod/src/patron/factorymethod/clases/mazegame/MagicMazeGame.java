package patron.factorymethod.clases.mazegame;

import patron.factorymethod.abstracta.MazeGame;
import patron.factorymethod.abstracta.Room;
import patron.factorymethod.clases.room.MagicRoom;

public class MagicMazeGame extends MazeGame{
	/*{En BD esta ser�a la conexi�n o podr�a ser los DAO. Por ejemplo la conexi�n a Derby}*/
	@Override
	protected Room makeRoom() {
		//#regionfactorymethod
		return new MagicRoom();
		//#endregion
	}
}
