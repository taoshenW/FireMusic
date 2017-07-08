package com.sfp.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sfp.domain.Music;
import com.sfp.service.MusicService;

@Controller
public class MusicController {

	@Value("${music.path}")
	private String MUSICPATH;
	@Autowired
	MusicService musicService;

	@RequestMapping("/music")
	public String index() {
		return "index";
	}

	@ResponseBody
	@RequestMapping("/music/play/id/{id}")
	public Music play(@PathVariable int id) {
		Music music = musicService.findById(id);
		music.setAbsolutePath(MUSICPATH);
		return music;
	}

	@RequestMapping("/music/download/id/{id}")
	public ResponseEntity<InputStreamResource> downloadFile(@PathVariable int id) throws IOException {
		Music music = musicService.findById(id);
		String filePath = MUSICPATH + "//" + music.getPath();
		FileSystemResource file = new FileSystemResource(filePath);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(music.getPath(), "UTF-8"));
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		return ResponseEntity.ok().headers(headers).contentLength(file.contentLength())
				.contentType(MediaType.parseMediaType("application/octet-stream"))
				.body(new InputStreamResource(file.getInputStream()));
	}
	
	@ResponseBody
	@RequestMapping("/music/share/musicid/{mid}/userid/{uid}")
	public void share(@PathVariable int mid,@PathVariable int uid){

	}

}
