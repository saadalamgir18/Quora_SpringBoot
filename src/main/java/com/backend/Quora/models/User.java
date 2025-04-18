package com.backend.Quora.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel {

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true)
    private String email;

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "user")
    private List<Question> questions = new ArrayList<>();;


}
