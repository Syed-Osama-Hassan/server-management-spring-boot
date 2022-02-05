package syed.osama.hassan.server_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syed.osama.hassan.server_management.enumeration.Status;
import syed.osama.hassan.server_management.model.Response;
import syed.osama.hassan.server_management.model.Server;
import syed.osama.hassan.server_management.service.impl.ServerServiceImpl;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

/**
 *
 * @author Syed Osama Hassan
 */

@RestController
@RequestMapping("/server")
@RequiredArgsConstructor
public class ServerController
{
    private final ServerServiceImpl serverService;

    @GetMapping("/list")
    public ResponseEntity<Response>  getServers()
    {
        return ResponseEntity.ok(
          Response.builder().timestamp(LocalDateTime.now())
                  .data(Map.of("servers", serverService.list(30)))
                  .message("Servers Retrieved")
                  .status(HttpStatus.OK)
                  .statusCode(HttpStatus.OK.value())
                  .build()
        );
    }

    @GetMapping("/ping/{ipAddress}")
    public ResponseEntity<Response>  pingServer(@PathVariable String ipAddress) throws IOException {
        Server server = serverService.ping(ipAddress);

        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now())
                        .data(Map.of("server", server))
                        .message(server.getStatus() == Status.SERVER_UP ? "Ping Success" : "Ping Failed")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response>  saveServer(@RequestBody @Valid Server server) throws IOException {

        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.create(server)))
                        .message("Server Created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response>  getServer(@PathVariable Long id) {

        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now())
                        .data(Map.of("server", serverService.get(id)))
                        .message("Server Retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response>  deleteServer(@PathVariable Long id) {

        return ResponseEntity.ok(
                Response.builder().timestamp(LocalDateTime.now())
                        .data(Map.of("deleted", serverService.delete(id)))
                        .message("Server deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(value = "/image/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[]  getServerImage(@PathVariable String fileName) throws IOException {
        System.out.println(System.getProperty("user.home") + "Downloads/server/");
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Downloads/server/" + fileName));
    }

}
