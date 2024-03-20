package bip.online.biplio2023.service;

import bip.online.biplio2023.entity.PublisherEntity;
import bip.online.biplio2023.repository.PublisherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class PublisherService {

    private final PublisherRepo repo;

    public List<PublisherEntity> findAll() {
        return repo.findAll();
    }
    public Optional<PublisherEntity> findById(Long id) {
        return repo.findById(id);
    }
    public PublisherEntity save (PublisherEntity data) {
        return repo.save(data);
    }
    public void update (PublisherEntity data) {
        repo.save(data);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

}


