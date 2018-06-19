package cn.zhb.core.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页存储内容, 表格内容
 * @author zhb
 *
 */
public class TablePage<T extends BaseEntity> {
	private List<T> rows = new ArrayList<T>();//行代码

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	
	
}
