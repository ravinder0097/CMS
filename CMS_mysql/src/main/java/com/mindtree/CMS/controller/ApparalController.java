package com.mindtree.CMS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.CMS.model.Apparal;
import com.mindtree.CMS.service.ApparalService;

import io.swagger.annotations.ApiOperation;
import lombok.NonNull;

@RestController
@RequestMapping(value = "Apparal")
public class ApparalController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private ApparalService apparalService;

	@RequestMapping(value = "/overview", method = RequestMethod.GET)
	@ApiOperation(value = "Gets All the Available Apparal Details")
	public List<Apparal> getAllBook() {
		logger.trace("Entering in getAllBook");
		return apparalService.getAllApparals();
	}

	@RequestMapping(value = "/getBook", method = RequestMethod.GET)
	@ApiOperation(value = "Gets Apparal by given id")
	public Apparal getApparal(@RequestParam(required = true) long apparalId) {
		logger.trace("Entering in getApparal");
		return apparalService.getApparal(apparalId);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ApiOperation(value = "Create Apparal")
	public Apparal create(@RequestBody(required = true) @NonNull Apparal apparal) {
		logger.trace("Entering in create");
		return apparalService.create(apparal);
	}

}
