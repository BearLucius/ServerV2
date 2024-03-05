package bip.online.biplio2024.repository;

import bip.online.biplio2024.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<AuthorEntity, Long> {

}
