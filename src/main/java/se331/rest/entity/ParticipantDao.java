package se331.rest.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ParticipantDao {
    Page<Participant> getParticipant(Pageable pageRequest);
    Optional<Participant> findById(Long id);
}
