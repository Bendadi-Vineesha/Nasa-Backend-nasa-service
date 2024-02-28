package com.cts.nasa.nasaservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.nasa.nasaservice.exception.ImageNotFoundException;
import com.cts.nasa.nasaservice.model.Image;


@Service
public class ImageService {
	
	private static final String API_KEY ="mk7BsngYe5BfIawheH3QoILgSGHp9ZLiq4UfehAV";
	
	private static String API_URL;

	@Autowired
	private RestTemplate resttemplate;
	
	public Image getImageDetails(String date) {
		API_URL="https://api.nasa.gov/planetary/apod?api_key=" + API_KEY + "&date=" + date;
		//return resttemplate.getForObject(API_URL, Image.class);
		Image img = resttemplate.getForObject(API_URL, Image.class);
		if(img == null) {
			throw new ImageNotFoundException("imaged with the date" + date +"is not present");
		}
		else {
			return img;
		}
	}

	public Image getCurrentDayImage() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		API_URL="https://api.nasa.gov/planetary/apod?api_key=" + API_KEY;
		//return resttemplate.getForObject(API_URL,Image.class,headers);
		Image img = resttemplate.getForObject(API_URL,Image.class,headers);
		if(img == null) {
			throw new ImageNotFoundException("imaged of the day has not uploaded yet.. try after some time");
		}
		else {
			return img;
		}
	}
	
}
