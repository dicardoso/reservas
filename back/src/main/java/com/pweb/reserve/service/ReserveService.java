package com.pweb.reserve.service;

import com.pweb.reserve.model.Reserve;
import com.pweb.reserve.repository.ReserveRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {

    @Autowired
    ReserveRepository reserveRepository;

    public List<Reserve> list(){
        return reserveRepository.findAll();
    }

    public Optional<Reserve> search(Long id) {
        return reserveRepository.findById(id);
    }

    public Reserve insert(Reserve reserve){
        return reserveRepository.save(reserve);
    }

    public Reserve update(Long id, Reserve newReserve){
        Optional<Reserve> oldReserve = reserveRepository.findById(id);
        Reserve reserve = oldReserve.get();
        BeanUtils.copyProperties(newReserve, reserve, "id");
        return reserveRepository.save(reserve);
    }

    public void delete(Long id) {
        reserveRepository.deleteById(id);
    }
}
