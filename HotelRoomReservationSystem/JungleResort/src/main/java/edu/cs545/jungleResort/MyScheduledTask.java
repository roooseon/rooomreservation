package edu.cs545.jungleResort;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import edu.cs545.jungleResort.service.IRoomService;

@Component
public class MyScheduledTask {

	@Autowired
	IRoomService roomService;
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	//schedular runs in every 24 hours!!
	@Scheduled(fixedRate = 86400000)
	public void scheduledJob() {

		System.out.println("scheduled Job ran at " + dateFormat.format(new Date()));
		
		roomService.scheduledTask();

	}
}
