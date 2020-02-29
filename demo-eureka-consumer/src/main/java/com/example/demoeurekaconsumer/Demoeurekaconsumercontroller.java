package com.example.demoeurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class Demoeurekaconsumercontroller {

	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
    RestTemplate rsttmp;
	
	@GetMapping("/display")
	public String display()
	{
		
		//Application application =
			//      eurekaClient.getApplication("EurekaProducer");
			//    InstanceInfo instanceInfo = application.getInstances().get(0);
			 //   String hostname = instanceInfo.getHostName();
			  //  System.out.println(hostname);
			    
			 //   int port = instanceInfo.getPort();
			 //   System.out.println(port);
			 //   String uri = "http://"+hostname+":"+port+"/display";
		//RestTemplate rsttmp =new RestTemplate();
		return rsttmp.getForObject("http://EurekaProducer/display", String.class);
//The above url will work only if we are using ribbon client load balancer along with load balanced enabled on RestTemplate
		
	}
	@Bean
	@LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
}
