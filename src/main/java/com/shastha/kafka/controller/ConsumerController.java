package com.shastha.kafka.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shastha.kafka.CustomerEntry;
import com.shastha.kafka.CustomerId;
import com.shastha.kafka.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class ConsumerController 
{
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/view")
	@KafkaListener(topics= {"customer-details"})
	public void viewCustomer(ConsumerRecord<CustomerId, CustomerEntry> customerRecord)
	{
		System.out.println();
		customerService.readMessage(customerRecord);
	}
	@RequestMapping("all")
	public String getAll()
	{
	 return	customerService.getMessage().toString();
	}

}
