package se331.rest.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizerDao {
    Page<Organizer> getOrganizer(Pageable pageRequest);

}
