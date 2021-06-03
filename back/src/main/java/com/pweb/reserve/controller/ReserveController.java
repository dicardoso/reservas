package com.pweb.reserve.controller;

import com.pweb.reserve.model.Area;
import com.pweb.reserve.model.Reserve;
import com.pweb.reserve.service.AreaService;
import com.pweb.reserve.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserves")
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @CrossOrigin
    @GetMapping("/listReserves")
    public ResponseEntity<?> list(){
        List<Reserve> reserves = reserveService.list();
        return new ResponseEntity<>(reserves, HttpStatus.OK);
    }

    @GetMapping("/searchReserve/{id}")
    public ResponseEntity<?> search(Long id) {
        Optional<Reserve> reserve = reserveService.search(id);
        return new ResponseEntity<>(reserve, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/insertReserve")
    public ResponseEntity<?> insert(@RequestBody Reserve newReserve) {
        Reserve reserve = reserveService.insert(newReserve);
        System.out.println(reserve);
        return new ResponseEntity<>(reserve, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteReserve/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        reserveService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/updateArea/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Reserve newReserve){
        Reserve reserve = reserveService.update(id, newReserve);
        return new ResponseEntity<>(reserve, HttpStatus.OK);
    }

}
