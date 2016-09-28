package com.example.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document(collection="myEntity")
@EqualsAndHashCode
@Data
public class MyEntity {
	
	@Id
	String id;

	DateTime myJodaTime;
	
}
