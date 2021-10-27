package com.example.crocusoftrelation.service;

import com.example.crocusoftrelation.dto.request.AddressRequestDto;
import com.example.crocusoftrelation.dto.request.StudentRequestDto;

public interface AddressService {

    String saveAddress(AddressRequestDto request);
}
