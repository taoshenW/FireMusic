// 
// Decompiled by Procyon v0.5.30
// 

package com.sfp.util;

import java.io.IOException;
import java.math.BigInteger;

import static org.mockito.Mockito.verify;

import java.io.File;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

	public static String md5(String source) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(source.getBytes());
		return new BigInteger(1, md.digest()).toString(16);
	}

	public static String saveImage(MultipartFile file, String location) throws IllegalStateException, IOException {
		String originFileName = file.getOriginalFilename();
		// String prefix =
		// originFileName.substring(originFileName.lastIndexOf("."));
		String prefix = StringUtils.getFilenameExtension(originFileName);
		String filename = String.valueOf(String.valueOf(System.currentTimeMillis())) + "." + prefix;
		File targetFile = new File(location, filename);
		file.transferTo(targetFile);
		return filename;
	}

	public static void deleteImage(String path) {
		File file = new File(path);
		if (file.exists())
			file.delete();
	}

}
