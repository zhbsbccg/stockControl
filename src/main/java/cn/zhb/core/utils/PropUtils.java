package cn.zhb.core.utils;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropUtils {
	
	@Value("#{prop.filePath}")
	private String filePath;
	
	/**
	 * 获取文件上传路径
	 * @return
	 */
	public String getUploadPath() {
		String path = System.getProperty("user.dir") + File.separator + "attach";
		if(StringUtils.isNotEmpty(filePath)) {
			path = this.filePath;
		}
		return path;
	}
	
}
