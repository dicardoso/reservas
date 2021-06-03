package com.pweb.reserve.repository;

import com.pweb.reserve.model.Dweller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DwellerRepository extends JpaRepository<Dweller, Long> {
}
