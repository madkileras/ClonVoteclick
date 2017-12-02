package cl.voteclick;

import cl.voteclick.model.*;
import cl.voteclick.utils.VotationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class VoteClickApplication {
	public static void main(String[] args) {
		SpringApplication.run(VoteClickApplication.class,args);
	}
}
