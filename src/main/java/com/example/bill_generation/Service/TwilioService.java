package com.example.bill_generation.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwilioService {
    @Value("${twilio.account_sid}")
    private String account_sid;

    @Value("${twilio.auth_token}")
    private String auth_token;

    @Value("${twilio.phone_number}")
    private String fromWhatsAppNumber;

    @PostConstruct
    public void initTwilio() {
        Twilio.init(account_sid, auth_token);
    }

    public void successfullyBuy(String toPhoneNumber, String messageText) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:" + fromWhatsAppNumber),
                messageText
        ).create();
    }

    public void OutOfStoc(String toPhoneNumber, String messageText) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:" + fromWhatsAppNumber),
                messageText
        ).create();
    }

    public void UnsuccessfullyBuy(String toPhoneNumber, String messageText) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:" + fromWhatsAppNumber),
                messageText
        ).create();
    }

    public void UpdateMessage(String toPhoneNumber, String messageText) {
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:" + fromWhatsAppNumber),
                messageText
        ).create();
    }
}
