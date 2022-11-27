package se.nackademin.client.data;

import se.nackademin.core.repositories.eventrepository.EventRepository;
import se.nackademin.core.repositories.eventrepository.models.Event;
import se.nackademin.core.repositories.eventrepository.datasources.SocketInputQueue;
import se.nackademin.core.repositories.eventrepository.datasources.SocketOutputQueue;
import se.nackademin.core.repositories.eventrepository.models.HostId;

import java.net.Socket;

public class ClientEventRepository implements EventRepository {

	private SocketOutputQueue<Event> socketOutputQueue;
	private final SocketInputQueue<Event> socketInputQueue;
	private HostId clientId;

	public ClientEventRepository() {
		this.socketInputQueue = new SocketInputQueue<>();
		new Thread(socketInputQueue).start();
	}

	public void connect(Socket socket) {
		socketOutputQueue = new SocketOutputQueue<>(socket);
		new Thread(socketOutputQueue).start();
		socketInputQueue.connect(socket);

	}

	public void setSourceId(HostId hostIdId) {
		this.clientId = hostIdId;
	}

	public Event getEvent() {
		return socketInputQueue.take();
	}

	public void sendEvent(Event event) {
		event.setSource(clientId);
		switch (event.getDestination()) {
			case SELF -> socketInputQueue.put(event);
			case SERVER -> socketOutputQueue.put(event);
		}
	}

}
