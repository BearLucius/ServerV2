package bip.online.biplio2024.service;

import bip.online.biplio2024.entity.BookEntity;
import bip.online.biplio2024.repository.BookRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class BookService {
    private final BookRepo repo;

    public List<BookEntity> findAll(){
        return repo.findAll();
    }

    public Optional<BookEntity> findById(Long id){
        return repo.findById(id);
    }

    public BookEntity save (@Valid BookEntity data){
        return repo.save(data);
    }

    public void update (BookEntity data){
        repo.save(data);
    }
}
