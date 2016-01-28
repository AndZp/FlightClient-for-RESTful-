/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.ws.interfaces;

import ua.com.ukrelektro.flight.enums.ListenerType;

public interface WSResultListener {
    void notify(Object object, ListenerType listenerType);
}
