package syed.osama.hassan.server_management.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import syed.osama.hassan.server_management.model.Server;
import syed.osama.hassan.server_management.repo.ServerRepo;
import syed.osama.hassan.server_management.service.ServerService;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 *
 * @author Syed Osama Hassan
 */
@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService
{
    private final ServerRepo serverRepo;

    @Override
    public Server create(Server server)
    {
        log.info("SAVING NEW SERVER | SERVER_NAME", server.getName());
        return null;
    }

    @Override
    public Server ping(String ipAddress)
    {
        return null;
    }

    @Override
    public Collection<Server> list(int limit)
    {
        return null;
    }

    @Override
    public Server get(Long id)
    {
        return null;
    }

    @Override
    public Server update(Server server)
    {
        return null;
    }

    @Override
    public Boolean delete(Long id)
    {
        return null;
    }
}
