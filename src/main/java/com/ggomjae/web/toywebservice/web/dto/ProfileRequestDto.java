package com.ggomjae.web.toywebservice.web.dto;

import com.ggomjae.web.toywebservice.domain.Profile.Profile;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProfileRequestDto {

    private String filePath;
    private Long profileValue;

    public Profile toEntity(){
        Profile profile = Profile.builder()
                .filePath(filePath)
                .profileValue(profileValue)
                .build();
        return profile;
    }

    @Builder
    public ProfileRequestDto(String filePath,Long profileValue) {

        this.filePath = filePath;
        this.profileValue = profileValue;
    }
}
