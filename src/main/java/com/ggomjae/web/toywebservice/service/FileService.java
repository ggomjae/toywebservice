package com.ggomjae.web.toywebservice.service;


import com.ggomjae.web.toywebservice.domain.Profile.Profile;
import com.ggomjae.web.toywebservice.domain.Profile.ProfileRepository;
import com.ggomjae.web.toywebservice.web.dto.ProfileRequestDto;
import com.ggomjae.web.toywebservice.web.dto.ProfileResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class FileService {

    private final ProfileRepository profileRepository;

    @Transactional
    public Long save(ProfileRequestDto profileRequestDto){

        return profileRepository.save(profileRequestDto.toEntity()).getId();
    }

    @Transactional
    public ProfileResponseDto findById (Long id){

        Profile entity = profileRepository.getProfile(id);

        return new ProfileResponseDto(entity);
    }

    @Transactional
    public void deleteProfile(Long id){

        profileRepository.deleteProfile(id);
    }
}
