package SpringBootTask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    //@Scheduled(cron = "5 * * * * MON-FRI")
    //@Scheduled(cron = "0,1,2,3,4,5 * * * * MON-FRI")
    //@Scheduled(cron = "0-5 * * * * MON-FRI")
    @Scheduled(cron = "0/4 * * * * MON-FRI")
    public void schedule() {
        System.out.println("Scheduled...");
    }
}
