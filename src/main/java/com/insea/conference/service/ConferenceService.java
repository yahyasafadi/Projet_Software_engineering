package com.insea.conference.service;

import com.insea.conference.domain.Conference;
import com.insea.conference.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    public Conference save(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public List<Conference> findAll() {
        return conferenceRepository.findAll();
    }
}