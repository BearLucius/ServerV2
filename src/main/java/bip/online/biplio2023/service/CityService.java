package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.CityEntity;
import bip.online.biplio2023.repository.CityRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class CityService {

    private final CityRepo repo;

    public List<CityEntity> findAll() {
        return repo.findAll();
    }
    public Optional<CityEntity> findById(Long id) {
        return repo.findById(id);
    }
    public CityEntity save (CityEntity data) {
        return repo.save(data);
    }
    public void update (CityEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }
}

