package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.AuthorEntity;
import bip.online.biplio2023.repository.AuthorRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class AuthorService {
    private final AuthorRepo repo;

    public List<AuthorEntity> findAll() {
return repo.findAll();
    }
    public Optional<AuthorEntity> findById(Long id) {
        return repo.findById(id);
    }
        public AuthorEntity save (@Valid AuthorEntity data) {
            return repo.save(data);
        }
            public void update (AuthorEntity data) {
                repo.save(data);
            }
    public void delete (Long id) {
        repo.deleteById(id);
    }
}
