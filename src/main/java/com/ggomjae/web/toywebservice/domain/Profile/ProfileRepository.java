package com.ggomjae.web.toywebservice.domain.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    @Query("SELECT p FROM Profile p WHERE p.profileValue = ?1 ")
    Profile getProfile(Long bno);

    @Transactional
    @Modifying
    @Query("DELETE FROM Profile p WHERE p.profileValue = ?1")
    void deleteProfile(Long bno);
}
