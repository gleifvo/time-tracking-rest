package timetracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class TimeTrackingApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TimeTrackingApp.class, args);
    }
}
