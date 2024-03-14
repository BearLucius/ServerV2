package bip.online.biplio2024.repository;

import bip.online.biplio2024.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepo extends JpaRepository<PublisherEntity, Long> {
}
