package com.example.crocusoftrelation.mapper;

import com.example.crocusoftrelation.dao.entity.Address;
import com.example.crocusoftrelation.dto.request.AddressRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper{

    Address dtoToEntity(AddressRequestDto dto);
}
