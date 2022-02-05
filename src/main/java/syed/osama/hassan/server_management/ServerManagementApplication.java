package syed.osama.hassan.server_management;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import syed.osama.hassan.server_management.enumeration.Status;
import syed.osama.hassan.server_management.model.Server;
import syed.osama.hassan.server_management.repo.ServerRepo;

@SpringBootApplication
public class ServerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerManagementApplication.class, args);
	}


	@Bean
	CommandLineRunner run(ServerRepo serverRepo)
	{
		return args -> {
			serverRepo.save(new Server("192.168.1.160", "Windows 10", "16 GB", "Work",
					"http://localhost:8080/server/image/server1.jpg", Status.SERVER_UP));

			serverRepo.save(new Server("192.168.1.58", "Linux Mint", "8 GB", "Work 2",
					"http://localhost:8080/server/image/server2.jpg", Status.SERVER_UP));

			serverRepo.save(new Server("192.168.1.90", "Ubuntu", "32 GB", "Work 3",
					"http://localhost:8080/server/image/server3.jpg", Status.SERVER_DOWN));

			serverRepo.save(new Server("192.168.1.1", "MacOS", "16 GB", "Work 4",
					"http://localhost:8080/server/image/server4.jpg", Status.SERVER_UP));
		};
	}

}
