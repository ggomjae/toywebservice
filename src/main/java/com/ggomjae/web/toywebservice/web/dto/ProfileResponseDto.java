package com.ggomjae.web.toywebservice.web.dto;

import com.ggomjae.web.toywebservice.domain.Profile.Profile;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ProfileResponseDto {

    private Long id;
    private String filePath;
    private Long profileValue;

    public ProfileResponseDto(Profile entity){

        this.id = entity.getId();
        this.filePath = entity.getFilePath();
        this.profileValue = entity.getProfileValue();
    }
}
