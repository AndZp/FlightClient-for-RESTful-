/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.ws.handlers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class CallbackHandler extends AddressingHandler {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isOutbound = (Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
      
//        if (!isOutbound) {
            try {

                if (context.getMessage().getSOAPBody().getFault() != null) {
                    System.out.println(context.getMessage().getSOAPBody().getFault().getFaultString());
                }

                SOAPEnvelope envelope = context.getMessage().getSOAPPart()
                        .getEnvelope();
                SOAPHeader header = envelope.getHeader();
                
                System.out.println(getMessageID(header));

                /* store in application context the relatesTo field */
                context.put(AddressingHandler.RELATES_TO, getRelatesTo(header));
                context.setScope(AddressingHandler.RELATES_TO, Scope.APPLICATION);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
//        }

        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        try {
            System.out.println(context.getMessage().getSOAPBody().getFault().getFaultString());
        } catch (SOAPException ex) {
            Logger.getLogger(CallbackHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
}