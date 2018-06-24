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
import cn.zhb.core.entity.LayuiMapResponse;
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
	@ResponseBody
	public void getUploads(MultipartFile file) {
		LayuiMapResponse lmr = new LayuiMapResponse();
		
		
		if(file != null) {
			String uploadPath = propUtils.getUploadPath();//默认路径
			String saveName = UUID.randomUUID().toString();//uuid 32位作为文件名
			int year = dateUtils.gerNowYear();
			String uploadPathFolder = uploadPath + File.separator + year;
			String uploadPathFileName = uploadPathFolder +File.separator + saveName;
			//保存附件到文件
			try {
				attachService.saveFile(uploadPathFileName, file.getBytes());
			} catch (IOException e) {
				lmr.setCode(1);
				lmr.setMsg(e.getMessage());
				e.printStackTrace();
			}
			//保存附件资料到数据库
			if(lmr.getCode() == 0) {
				String fileName = file.getName();
				String suffix = getSuffix(fileName);
				Attach attach = new Attach();
				attach.setAbstractName(saveName);
				attach.setCreateDate(dateUtils.getLongNowDate());
				attach.setOriginName(fileName);
				attach.setPath(uploadPathFolder);
				attach.setSize(file.getSize());
				attach.setSuffix(suffix);
			}
		}
		
		
	}
	
	public String getSuffix(String name) {
		String sffix = "";
		String[] splits = name.split(".");
		if(splits != null && splits.length > 0) {
			sffix = splits[splits.length-1];
		}
		return sffix;
	}
	
}
