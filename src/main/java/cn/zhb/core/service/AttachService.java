package cn.zhb.core.service;

import java.io.IOException;

import cn.zhb.core.entity.Attach;

public interface AttachService {
	void saveFile(String path, byte[] bts) throws IOException;
	void save(Attach attach);
}
