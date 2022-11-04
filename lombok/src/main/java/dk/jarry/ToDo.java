package dk.jarry;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter
// @Setter
// @NoArgsConstructor
@Data
public class ToDo {

    private String subject;
    private String body;
    private Integer privority;

}
