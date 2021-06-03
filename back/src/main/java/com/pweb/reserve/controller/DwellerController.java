package com.pweb.reserve.controller;

import com.pweb.reserve.model.Dweller;
import com.pweb.reserve.service.DwellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dweller")
public class DwellerController {

    @Autowired
    DwellerService dwellerService;

    @CrossOrigin
    @GetMapping("/listDweller")
    public ResponseEntity<?> list(){
        List<Dweller> dwellers = dwellerService.list();
        return new ResponseEntity<>(dwellers, HttpStatus.OK);
    }

    @GetMapping("/searchDweller/{id}")
    public ResponseEntity<?> search(Long id) {
        Optional<Dweller> dweller = dwellerService.search(id);
        return new ResponseEntity<>(dweller, HttpStatus.OK);
    }

    @PostMapping("/insertDweller")
    public ResponseEntity<?> insert(@RequestBody Dweller newDweller) {
        Dweller dweller = dwellerService.insert(newDweller);
        return new ResponseEntity<>(dweller, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDweller/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        dwellerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateDweller/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Dweller newDweller){
        Dweller dweller = dwellerService.update(id, newDweller);
        return new ResponseEntity<>(dweller, HttpStatus.OK);
    }

}
