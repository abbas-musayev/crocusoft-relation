package com.example.crocusoftrelation.controller;

import com.example.crocusoftrelation.dto.request.AddressRequestDto;
import com.example.crocusoftrelation.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

//    Address save edilende Studentin sadece Id-sini vermesi bes edir
//    Ona gore Biz Requestde Student Obyekti yox tekce Long id goturek

    @PostMapping
    public ResponseEntity<String> save(@RequestBody AddressRequestDto request){
        return ResponseEntity.ok(addressService.saveAddress(request));
    }



}
