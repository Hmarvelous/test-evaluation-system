package online.shixun.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("online.shixun.project.mapper")
public class TestEvaluationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestEvaluationSystemApplication.class, args);
	}

}
