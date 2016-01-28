/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.ukrelektro.flight.ws.handlers;

import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext.Scope;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class AddHeadersHandler extends AddressingHandler {

    public boolean handleMessage(SOAPMessageContext context) {
        Boolean isOutbound = (Boolean) context
                .get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (isOutbound) {
            try {
                SOAPEnvelope envelope = context.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();

                /* extract the generated MessageID */
                String messageID = getMessageID(header);
                context.put(AddressingHandler.MESSAGE_ID, messageID);
                context.setScope(AddressingHandler.MESSAGE_ID, Scope.APPLICATION);

                /* change ReplyTo address */
                setReplyTo(header, (String) context.get(AddressingHandler.REPLY_TO));
                
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        return true;
    }

  
    
    
}