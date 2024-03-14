package bip.online.biplio2024.service;


import bip.online.biplio2024.entity.GenreEntity;
import bip.online.biplio2024.repository.GenreRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class GenreService {
    private final GenreRepo repo;

    public List<GenreEntity> findAll(){
        return repo.findAll();
    }

    public Optional<GenreEntity> findById(Long id){
        return repo.findById(id);
    }

    public GenreEntity save (@Valid GenreEntity data){
        return repo.save(data);
    }

    public void update (GenreEntity data){
        repo.save(data);
    }
}
