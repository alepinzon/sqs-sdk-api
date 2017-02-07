package org.example.sqs.listeners;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public class JmsListenerSample {

    @JmsListener(destination = "test-sdk")
    public void readMessage(String requestJSON) throws JMSException {
        try {
            System.out.println("Received: "+requestJSON);
        } catch (Exception ex) {
            throw new JMSException("Encountered error while parsing message.");
        }
    }
}
