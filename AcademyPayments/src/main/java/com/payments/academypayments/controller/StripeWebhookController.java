package com.payments.academypayments.controller;

import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.net.Webhook;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/webhook")
public class StripeWebhookController {

    @Value("${stripe.webhook.secret}")
    private String webhookSecret;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //TODO: TERMINAR ESSA PARTE DO WEBHOOK
//    @PostMapping
//    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) {
//        try {
//            Event event = Webhook.constructEvent(payload, sigHeader, endpointSecret);
//            if ("checkout.session.completed".equals(event.getType())) {
//                System.out.println("Pagamento confirmado! Criando evento...");
//                String sessionId = event.getData().getObject().getId();
//                String customerEmail = event.getData().getObject().getString("customer_email");
//                PaymentConfirmedEvent paymentEvent = new PaymentConfirmedEvent(sessionId, customerEmail);
//                rabbitTemplate.convertAndSend("payment.exchange", "payment.success", paymentEvent);
//                System.out.println("Evento de pagamento enviado para RabbitMQ!");
//            }
//            return ResponseEntity.ok("Recebido com sucesso");
//        } catch (SignatureVerificationException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Assinatura inválida");
//        }
//    }

}
