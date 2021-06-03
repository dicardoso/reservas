package com.pweb.reserve.controller;

import com.pweb.reserve.model.Area;
import com.pweb.reserve.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/areas")
public class AreaController {

    @Autowired
    AreaService areaService;

    @CrossOrigin
    @GetMapping("/listAreas")
    public ResponseEntity<?> list(){
        List<Area> areas = areaService.list();
        return new ResponseEntity<>(areas, HttpStatus.OK);
    }

    @GetMapping("/searchArea/{id}")
    public ResponseEntity<?> search(Long id) {
        Optional<Area> area = areaService.search(id);
        return new ResponseEntity<>(area, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/insertArea")
    public ResponseEntity<?> insert(@RequestBody Area newArea) {
        Area area = areaService.insert(newArea);
        return new ResponseEntity<>(area, HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping("/deleteArea/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        areaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateArea/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Area newArea){
        Area area = areaService.update(id, newArea);
        return new ResponseEntity<>(area, HttpStatus.OK);
    }

}
