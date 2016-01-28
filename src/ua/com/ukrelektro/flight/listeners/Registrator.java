package ua.com.ukrelektro.flight.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua.com.ukrelektro.flight.enums.ListenerType;
import ua.com.ukrelektro.flight.ws.interfaces.WSResultListener;

public class Registrator {

    private static Registrator instance;

    private Registrator() {
    }

    public static Registrator getInstance() {
        if (instance == null) {
            instance = new Registrator();
        }

        return instance;
    }

    private Map<ListenerType, List<WSResultListener>> mapListeners = new HashMap<>();

    public void addListener(WSResultListener listener, ListenerType listenerType) {
        List<WSResultListener> list = mapListeners.get(listenerType);

        if (list == null) {
            list = new ArrayList<>();
            mapListeners.put(listenerType, list);
        }

        if (!list.contains(listener)) {
            list.add(listener);
        }

    }

    public List<WSResultListener> getListeners(ListenerType listenerType) {
        return mapListeners.get(listenerType);
    }

}
