package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Issues;
import com.example.demo.services.BugTrackingService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/rest")
public class BugTrackingController {

	@Autowired
	private BugTrackingService service;

	// Enter the url as localhost:6060/api/rest/issues for listing all values
	// Enter the url as example: localhost:6060/api/rest/issues?pagenum=0&pagesize=3
	// for pagination
	@GetMapping(path = "/issues")
	public List<Issues> findAllIssues(@RequestParam(defaultValue = "0") int pagenum, // Default Page Number
			@RequestParam(defaultValue = "10") int pagesize) { // Giving Default Page Size
		Pageable pageable = PageRequest.of(pagenum, pagesize); // Creating the view with respect to the given pagenum &
																// pagesize
		return this.service.findAll(pageable);
	}

	// Enter the url as example: localhost:6060/api/rest/issues/101 (102,103...) for
	// specific Issue
	@GetMapping(path = "/issues/{issueId}")
	public Optional<Issues> findyIssueById(@PathVariable("issueId") int id) {
		return this.service.findIssuesById(id);
	}

	// Enter the url as lcoalhost:6060/api/rest/issues and POST the data
	@PostMapping(path = "/issues")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Issues postIssue(@RequestBody Issues issue) {

		return this.service.saveIssue(issue);
	}

}
