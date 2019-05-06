package com.shastha.kafka.service;



import java.util.ArrayList;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;
import com.shastha.kafka.CustomerEntry;
import com.shastha.kafka.CustomerId;

@Component
public class CustomerService 
{
	ArrayList<CustomerEntry>list=new ArrayList<CustomerEntry>();
	public void readMessage(ConsumerRecord<CustomerId,CustomerEntry> record)
	{

	list.add(record.value());
		
	}
	public ArrayList<CustomerEntry> getMessage()
	{
		return list;
	}


		
}
