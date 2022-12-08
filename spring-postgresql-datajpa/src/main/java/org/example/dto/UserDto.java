package org.example.dto;

import lombok.Data;
import org.example.entitiy.Address;
import java.util.List;
@Data
public class UserDto {
    private long id;
    private String name;
    private String lastName;
    private List<String> adresler;
}
