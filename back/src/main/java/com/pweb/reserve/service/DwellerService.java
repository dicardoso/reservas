package com.pweb.reserve.service;

import com.pweb.reserve.model.Dweller;
import com.pweb.reserve.repository.DwellerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DwellerService {

    @Autowired
    DwellerRepository dwellerRepository;

    public List<Dweller> list(){
        return dwellerRepository.findAll();
    }

    public Optional<Dweller> search(Long id) {
        return dwellerRepository.findById(id);
    }

    public Dweller insert(Dweller dweller){
        return dwellerRepository.save(dweller);
    }

    public Dweller update(Long id, Dweller newDweller){
        Optional<Dweller> oldDweller = dwellerRepository.findById(id);
        Dweller dweller = oldDweller.get();
        BeanUtils.copyProperties(newDweller, dweller, "id");
        return dwellerRepository.save(dweller);
    }

    public void delete(Long id) {
        dwellerRepository.deleteById(id);
    }
}
