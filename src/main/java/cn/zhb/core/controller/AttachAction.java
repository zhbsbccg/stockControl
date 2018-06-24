package cn.zhb.core.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zhb.core.entity.Attach;
import cn.zhb.core.service.AttachService;
import cn.zhb.core.utils.DateUtils;
import cn.zhb.core.utils.PropUtils;

/**
 * 附件相关处理
 * @author Administrator
 *
 */
@Controller
public class AttachAction {
	
	private Logger logger = Logger.getLogger(AttachAction.class);
	
	@Resource
	private PropUtils propUtils;
	@Resource
	private AttachService attachService;
	@Resource
	private DateUtils dateUtils;
	
	
	@RequestMapping("/ajax/getUploads")
	public void getUploads(MultipartFile file) {
		
		if(file != null) {
			//首先保存文件
			String uploadPath = getSavePath();
			String saveName = UUID.randomUUID().toString();
			try {
				attachService.saveFile(uploadPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Attach attach = new Attach();
			
			
			
			
		}
		
		/*try {
			ServletInputStream inputStream = request.getInputStream();
			byte[] byteArray = IOUtils.toByteArray(inputStream);
			for(byte b : byteArray) {
				logger.error(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
			//logger.info(uploadField);
		
		
	}
	/**
	 * 获取保存路径
	 * @return
	 */
	public String getSavePath() {
		String uploadPath = propUtils.getUploadPath();
		int year = dateUtils.getNowYear();
		return uploadPath + File.separator + year + File.separator;
		
	}
}
