package com.man.urlshortner.cronjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.man.urlshortner.helper.UrlDetailServiceHelper;

@Component
@ConditionalOnProperty(prefix = "cron.job.control",name = "enabled",havingValue ="true",matchIfMissing = true )
public class Schedular {

	@Autowired
	public UrlDetailServiceHelper urlDetailServiceHelper;
	
	@Scheduled(cron = "${cron.for.url.status.update}")
	public void updateStatusOfUrl() {
		urlDetailServiceHelper.run();
	}
	
}
