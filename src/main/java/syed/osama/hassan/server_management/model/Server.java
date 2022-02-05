package syed.osama.hassan.server_management.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import syed.osama.hassan.server_management.enumeration.Status;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Syed Osama Hassan
 */
@Entity
@Data
@NoArgsConstructor
public class Server
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "IP address cannot be empty or null")
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;

    public Server(String ipAddress, String name, String memory, String type, String imageUrl, Status status) {
        this.ipAddress = ipAddress;
        this.name = name;
        this.memory = memory;
        this.type = type;
        this.imageUrl = imageUrl;
        this.status = status;
    }
}
