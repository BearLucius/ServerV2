package bip.online.biplio2024.service;

import bip.online.biplio2024.entity.AuthorEntity;
import bip.online.biplio2024.repository.AuthorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepo repo;

    public List<AuthorEntity> findAll(){
    return repo.findAll();
    }

    public Optional<AuthorEntity> findById(Long id){
    return repo.findById(id);
    }

    public AuthorEntity save (AuthorEntity data){
    return repo.save(data);
    }

    public void update (AuthorEntity data){
    repo.save(data);
    }
    }


