package syed.osama.hassan.server_management.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import syed.osama.hassan.server_management.enumeration.Status;
import syed.osama.hassan.server_management.model.Server;
import syed.osama.hassan.server_management.repo.ServerRepo;
import syed.osama.hassan.server_management.service.ServerService;

import javax.transaction.Transactional;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

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
        log.info("SAVING NEW SERVER | SERVER_NAME={}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("PINGING SERVER | IP={}", ipAddress);

        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress inetAddress = InetAddress.getByName(ipAddress);
        server.setStatus(inetAddress.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);

        return server;
    }

    @Override
    public Collection<Server> list(int limit)
    {
        log.info("FETCHING ALL SERVERS");

        return serverRepo.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server get(Long id)
    {
        log.info("FETCHING SERVER BY ID={}", id);

        return serverRepo.findById(id).get();
    }

    @Override
    public Server update(Server server)
    {
        log.info("UPDATING SERVER | SERVER_NAME={}", server.getName());

        return serverRepo.save(server);
    }

    @Override
    public Boolean delete(Long id)
    {
        log.info("DELETING SERVER BY ID={}", id);
        serverRepo.deleteById(id);
        return Boolean.TRUE;
    }

    private String setServerImageUrl()
    {
        String [] servers = {"server1.jpg", "server2.jpg", "server3.jpg", "server4.jpg"};
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + servers[new Random().nextInt(4)]).toUriString();
    }
}
