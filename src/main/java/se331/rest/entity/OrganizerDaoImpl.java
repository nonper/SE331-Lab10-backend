package se331.rest.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import se331.rest.repository.OrganizerRepository;

import java.awt.print.Pageable;

@Repository
public class OrganizerDaoImpl implements OrganizerDao{
    @Autowired
    OrganizerRepository organizerRepository;
    @Override
    public Page<Organizer> getOrganizer(org.springframework.data.domain.Pageable pageRequest) {
        return organizerRepository.findAll(pageRequest);
    }
}
