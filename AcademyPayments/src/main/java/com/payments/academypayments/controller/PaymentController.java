package com.payments.academypayments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("payments")
public class PaymentController {


    @GetMapping
    public RedirectView paymentSuccess(){
        return new RedirectView("");
    }

    @GetMapping
    public RedirectView paymentCancel(){
        return new RedirectView("");
    }
}
