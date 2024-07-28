package com.vchdev.services;

import com.vchdev.dao.ProfileRepository;
import com.vchdev.dao.entity.Profile;
import org.springframework.stereotype.Service;

@Service
public class ProfileService extends AbstractService<Profile, ProfileRepository> {
    public ProfileService(ProfileRepository repository) {
        super(repository);
    }
}
