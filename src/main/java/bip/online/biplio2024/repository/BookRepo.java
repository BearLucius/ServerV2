package bip.online.biplio2024.repository;

import bip.online.biplio2024.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<AuthorEntity,Long> {
}
