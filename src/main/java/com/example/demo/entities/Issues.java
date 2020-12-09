package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)

@Entity
@Table(name="BugTrackingIssues")

@Component
public class Issues {

	@Id
	int id;
	String summary;
	String description;
	String project;
	String priority;
	String severity;
	String assignedTo;
	
	
}
