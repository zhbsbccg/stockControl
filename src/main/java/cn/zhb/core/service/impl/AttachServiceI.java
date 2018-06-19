package cn.zhb.core.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import cn.zhb.core.service.AttachService;

@Service("attachService")
public class AttachServiceI implements AttachService {
	public void saveFile(String path, byte[] bts) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		IOUtils.write(bts, fos);
		IOUtils.closeQuietly(fos);
	}
}
