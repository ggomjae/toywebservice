package com.ggomjae.web.toywebservice.domain.Profile;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @Column
    private Long profileValue;

    @Builder
    public Profile(Long id, String filePath, Long profileValue) {
        this.id = id;
        this.filePath = filePath;
        this.profileValue = profileValue;
    }

}
