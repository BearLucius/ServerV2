package bip.online.biplio2024.service;

import bip.online.biplio2024.entity.BookEntity;
import bip.online.biplio2024.repository.BookRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepo repo;

    public List<BookEntity> findAll(){
        return repo.findAll();
    }

    public Optional<BookEntity> findById(Long id){
        return repo.findById(id);
    }

    public BookEntity save (BookEntity data){
        return repo.save(data);
    }

    public void update (BookEntity data){
        repo.save(data);
    }
}
