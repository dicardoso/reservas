package com.pweb.reserve.service;

import com.pweb.reserve.model.Area;
import com.pweb.reserve.repository.AreaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

    @Autowired
    AreaRepository areaRepository;

    public List<Area> list(){
        return areaRepository.findAll();
    }

    public Optional<Area> search(Long id) {
        return areaRepository.findById(id);
    }

    public Area insert(Area area){
        return areaRepository.save(area);
    }

    public Area update(Long id, Area newArea){
        Optional<Area> oldArea = areaRepository.findById(id);
        Area area = oldArea.get();
        BeanUtils.copyProperties(newArea, area, "id");
        return areaRepository.save(area);
    }

    public void delete(Long id) {
        areaRepository.deleteById(id);
    }
}
