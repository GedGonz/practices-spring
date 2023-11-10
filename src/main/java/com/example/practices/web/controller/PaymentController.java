package com.example.practices.web.controller;

import com.example.practices.domain.dto.PaymentDto;
import com.example.practices.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<List<PaymentDto>> getAll(){
        return new ResponseEntity<>(paymentService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<List<PaymentDto>> getByClient(@PathVariable("id") String clientId){

        return paymentService.getByClient(clientId).
                map(resp -> new ResponseEntity<>(resp, HttpStatus.OK)).
                orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<PaymentDto> save(@RequestBody PaymentDto paymentDto){
        return new ResponseEntity<>(paymentService.save(paymentDto), HttpStatus.OK);
    }
}
