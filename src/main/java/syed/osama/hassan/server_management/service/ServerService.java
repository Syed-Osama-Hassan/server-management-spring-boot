package syed.osama.hassan.server_management.service;

import syed.osama.hassan.server_management.model.Server;

import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author Syed Osama Hassan
 */
public interface ServerService
{
    /**
     * Create new Server
     *
     * @param server
     * @return
     */
    Server create(Server server);

    /**
     * Ping server and return updated server
     *
     * @param ipAddress
     * @return
     */
    Server ping(String ipAddress) throws IOException;

    /**
     * Return all servers by limit
     *
     * @param limit
     * @return
     */
    Collection<Server> list(int limit);

    /**
     * Get server by id
     *
     * @param id
     * @return
     */
    Server get(Long id);

    /**
     * Update server
     *
     * @param server
     * @return
     */
    Server update(Server server);

    /**
     * Delete Server by id
     *
     * @param id
     * @return
     */
    Boolean delete(Long id);
}
