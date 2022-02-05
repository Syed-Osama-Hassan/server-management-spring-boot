package syed.osama.hassan.server_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import syed.osama.hassan.server_management.model.Server;

/**
 *
 * @author Syed Osama Hassan
 */
public interface ServerRepo extends JpaRepository<Server, Long>
{
    Server findByIpAddress(String ipAddress);
}
