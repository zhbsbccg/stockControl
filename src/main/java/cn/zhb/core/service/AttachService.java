package cn.zhb.core.service;

import java.io.IOException;

public interface AttachService {
	void saveFile(String path, byte[] bts) throws IOException;
}
