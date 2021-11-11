package com.cooper.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadController {
	private static Logger logger = LoggerFactory.getLogger(ThreadController.class);
	
	@GetMapping(value = "/thread")
	public void threadMethod() {
		try {
			loop();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}
	
	static void loop() throws InterruptedException {
		long st = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.execute(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.print(i);
			}
		});
		
		executor.shutdown();
		executor.awaitTermination(1L, TimeUnit.SECONDS);
		logger.info("time: ", (System.currentTimeMillis() - st) / 1000);
	}
}
