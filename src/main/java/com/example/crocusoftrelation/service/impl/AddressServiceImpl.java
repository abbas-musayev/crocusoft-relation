package com.example.crocusoftrelation.service.impl;

import com.example.crocusoftrelation.dao.entity.Address;
import com.example.crocusoftrelation.dao.repo.AddressRepo;
import com.example.crocusoftrelation.dto.request.AddressRequestDto;
import com.example.crocusoftrelation.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    @Override
    public String saveAddress(AddressRequestDto request) {
        Address map = modelMapper.map(request, Address.class);

        addressRepo.save(map);

        return "AddressSaved";
    }
}
