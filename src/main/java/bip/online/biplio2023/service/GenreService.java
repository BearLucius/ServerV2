package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.GenreEntity;
import bip.online.biplio2023.repository.GenreRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class GenreService {

    private final GenreRepo repo;

    public List<GenreEntity> findAll() {
        return repo.findAll();
    }
    public Optional<GenreEntity> findById(Long id) {
        return repo.findById(id);
    }
    public GenreEntity  save (GenreEntity data) {
        return repo.save(data);
    }
    public void update ( GenreEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }
}

