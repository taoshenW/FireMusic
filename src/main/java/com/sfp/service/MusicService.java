package com.sfp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sfp.domain.Music;
import com.sfp.domain.repository.MusicRepository;

@Service
public class MusicService {
		
	@Autowired
	MusicRepository musicRepository;
	
	public Music findById(int id){
		return musicRepository.findOne(id);
	}
	
}
