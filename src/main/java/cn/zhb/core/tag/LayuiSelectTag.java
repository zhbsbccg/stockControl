package cn.zhb.core.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.beetl.core.Tag;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

import cn.zhb.core.entity.SelectItem;
import cn.zhb.core.service.SelectItemService;

/**
 * layui界面封装标签select
 * @author Administrator
 *
 */

@Service
@Scope("prototype")
public class LayuiSelectTag extends Tag {
	@Resource
	private SelectItemService selectItemService;
	
	//默认值
	private boolean isEmpty = false;
	
	@Override
	public void render() {
		Map attrs = (Map) args[1];
		
		if(attrs.containsKey("isEmpty")) {
			
			isEmpty = Boolean.valueOf( (String) attrs.get("isEmpty"));
			
		}
		String type = (String) attrs.get("type");
		String attr = (String) attrs.get("attr");
		StringBuffer html = new StringBuffer();
		if(StringUtils.isEmpty(type)) {
			return;
		}
		html.append("<select ").append(attr).append(" >");
		if(isEmpty) {
			html.append("<option value=\"\">请选择</option>");
		}
		//获取type
		List<SelectItem> selectList = selectItemService.getByType(type);
		selectList.forEach(v -> 
			html.append("<option").append(" value='").append(v.getName()).append("'>").append(v.getName()).append("</option>")
			);
		html.append("</select>");
		try {
			super.ctx.byteWriter.writeString(html.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
