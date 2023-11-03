package vn.ladystudio.servicef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ladystudio.servicef.model.SessionEntity;

import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<SessionEntity, String> {
    Optional<SessionEntity> findByUserId(String userId);
}
