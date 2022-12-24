package dev.titane.users.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private List<Long> borrowedBooksIds;

}
