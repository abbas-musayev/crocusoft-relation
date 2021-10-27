package com.example.crocusoftrelation.service.impl;

import com.example.crocusoftrelation.dao.entity.Address;
import com.example.crocusoftrelation.dao.entity.Student;
import com.example.crocusoftrelation.dao.repo.AddressRepo;
import com.example.crocusoftrelation.dao.repo.StudentRepo;
import com.example.crocusoftrelation.dto.request.StudentRequestDto;
import com.example.crocusoftrelation.exception.CustomNotFoundException;
import com.example.crocusoftrelation.service.AddressService;
import com.example.crocusoftrelation.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final AddressService addressService;
    private final ModelMapper modelMapper;

    @Override
    public String saveStudent(StudentRequestDto request) {
        if (request.getId()!=null || request.getId()!=0)
            throw new CustomNotFoundException("The id of the course must be 0 or null");
//     Student save olunanda addreside qeyd edilmelidi ve bu zaman Yeni Address save olunur
        Student map = modelMapper.map(request, Student.class);

        addressService.saveAddress(request.getAddress());

        studentRepo.save(map);

        return null;
    }
}
