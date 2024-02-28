package com.cts.nasa.nasaservice.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.nasa.nasaservice.model.Image;
import com.cts.nasa.nasaservice.service.ImageService;

@RestController
@RequestMapping("/imagedetails")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

	@Autowired
	ImageService imageservice;

	@GetMapping(value = "/imgOfTheday", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Image getImageOfTheDay() {
		Image response = imageservice.getCurrentDayImage();
		return response;
//		if (response != null) {
//			logger.debug("Astronomy picture of the day" + response);
//			return response;
//		} else {
//			throw new RuntimeException("Astronomy  picture of the day have not uploaded yet...try after some time");
//		}
	}

	@GetMapping("/image/{date}")
	public Image getImage(@PathVariable String date) {
		logger.debug("fetching image details date" + date);
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
		LocalDate date1 = LocalDate.parse(date, formatter);
		if (date1.isAfter(LocalDate.now())) {
			throw new RuntimeException("specified date is greater than the current date");
		} else {
			Image response = imageservice.getImageDetails(date);
			return response;
		}
	}
}
