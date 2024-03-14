package bip.online.biplio2024.service;



import bip.online.biplio2024.entity.CityEntity;
import bip.online.biplio2024.repository.CityRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class CityService {
    private final CityRepo repo;

    public List<CityEntity> findAll(){
        return repo.findAll();
    }

    public Optional<CityEntity> findById(Long id){
        return repo.findById(id);
    }

    public CityEntity save (@Valid CityEntity data){
        return repo.save(data);
    }

    public void update (CityEntity data){
        repo.save(data);
    }
}

