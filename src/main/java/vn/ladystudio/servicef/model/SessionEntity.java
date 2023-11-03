package vn.ladystudio.servicef.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "f_session")
public class SessionEntity {

    @Id
    private String userId;

    private String sessionId;
    private Date lastLogin;
    private Date lastLogout;

}
