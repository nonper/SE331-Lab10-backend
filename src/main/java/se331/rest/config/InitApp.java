package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;
import se331.rest.entity.Participant;
import se331.rest.repository.EventRepository;
import se331.rest.repository.OrganizerRepository;
import se331.rest.repository.ParticipantRepository;

import javax.transaction.Transactional;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1= organizerRepository.save(Organizer.builder()
                .name("CAMT")
                .build());
        org2= organizerRepository.save(Organizer.builder()
                .name("CMU")
                .build());
        org3= organizerRepository.save(Organizer.builder()
                .name("ChiangMai")
                .build());
        Participant par1, par2, par3, par4, par5;
        par1= participantRepository.save(Participant.builder()
                .name("Suhayb Farrow")
                .telNo("202-555-0198")
                .build());
        par2= participantRepository.save(Participant.builder()
                .name("Abdallah Key")
                .telNo("202-555-0175")
                .build());
        par3= participantRepository.save(Participant.builder()
                .name("Jacque Travers")
                .telNo("202-555-0165")
                .build());
        par4= participantRepository.save(Participant.builder()
                .name("Damien Valencia")
                .telNo("202-555-0172")
                .build());
        par5= participantRepository.save(Participant.builder()
                .name("Nico Trejo")
                .telNo("202-555-0113")
                .build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        tempEvent.getParticipants().add(par1);
        tempEvent.getParticipants().add(par2);
        tempEvent.getParticipants().add(par3);
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        tempEvent.getParticipants().add(par1);
        tempEvent.getParticipants().add(par2);
        tempEvent.getParticipants().add(par5);
        par1.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par5.getEventHistory().add(tempEvent);
        org1.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        tempEvent.getParticipants().add(par1);
        tempEvent.getParticipants().add(par3);
        tempEvent.getParticipants().add(par4);
        par1.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        par4.getEventHistory().add(tempEvent);
        org2.getOwnEvents().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        tempEvent.getParticipants().add(par4);
        tempEvent.getParticipants().add(par2);
        tempEvent.getParticipants().add(par3);
        par4.getEventHistory().add(tempEvent);
        par2.getEventHistory().add(tempEvent);
        par3.getEventHistory().add(tempEvent);
        org3.getOwnEvents().add(tempEvent);
    }
}
