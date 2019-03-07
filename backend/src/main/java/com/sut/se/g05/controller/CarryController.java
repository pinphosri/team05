package com.sut.se.g05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import com.sut.se.g05.entity.*;
import com.sut.se.g05.entity.Package;
import com.sut.se.g05.repository.*;

import java.text.ParseException;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CarryController {
    @Autowired
    private CarryRepository carryRepository;
    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private ReceiverRepository receiverRepository;


    @GetMapping("/carrys")
    public Collection<Carry> carry() {
        return carryRepository.findAll().stream().collect(Collectors.toList());
    }
    

    @GetMapping("/packages")
    public Collection<Package> packages() {
        return packageRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/carrys/{codenamecarry}/{namecarry}/{packageId}/{date}/{carryNumber}/{status}/{receivers}/{nameprovince}")
    public Carry newCarry(

            @PathVariable String codenamecarry, @PathVariable String namecarry,
            @PathVariable Long packageId, @PathVariable Date date,
            @PathVariable String carryNumber, @PathVariable String status,
            @PathVariable Long receivers, @PathVariable Long nameprovince

    ) throws ParseException {
        Carry newCarry = new Carry();

        Optional<Package> packages = packageRepository.findById(packageId);
        Optional<Province> province = provinceRepository.findById(nameprovince);
        Optional<Receiver> receiver = receiverRepository.findById(receivers);

        newCarry.setCodenamecarry(codenamecarry);
        newCarry.setNamecarry(namecarry);
        newCarry.setPackageId(packages.get());
        newCarry.setDate(date);
        newCarry.setCarryNumber(carryNumber);
        newCarry.setStatus(status);
        newCarry.setReceiver(receiver.get());
        newCarry.setProvince(province.get());
        return carryRepository.save(newCarry);

    }

}