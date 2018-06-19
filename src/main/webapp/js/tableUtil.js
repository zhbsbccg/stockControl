/**
 * 
 */
(function($) {
	
	/**
	 * table对象构造函数
	 */
	var TableDom = function(ele, param) {
		//参数初始化及使用， 定义对象的内容。
		this.$ele = ele;
		this.defaultParam = {
				
		}
		var _setting = $.extend({}, this.defaultParam, param);
		//检查参数
		if(!_setting.dataFun ) {
			throw new Error("ajaxFun参数不能为空");
		}
		this.setting = _setting;
	}
	//定义tableDom的行为
	TableDom.prototype = {
			//获取行数据
			getRowData: function(key) {
				var trObj = this.$ele.find("#tr-" + key);//获取需要处理的dom
				var dataObj = {};
				//获取字段配置
				var fields = this.setting.fields;
				$.each(fields, function(k, v) {
					
				});
				
				
				return dataObj;
				
			},
			//只读行
			readRow : function(key) {
				//this.ele.find
				var parentObj = this.$ele.find("#tr-" + key);//获取需要处理的dom
				parentObj.find("div[name=isEdit]").hide();
				parentObj.find("div[name=isRead]").show();
			},
			//编辑行
			editRow : function(key) {
				var parentObj = this.$ele.find("#tr-" + key);//获取需要处理的dom
				parentObj.find("div[name=isRead]").hide();
				parentObj.find("div[name=isEdit]").show();                
			},
			init: function() {
				//初始化表头
				this.clearThead();//清空表头
				var theadHtml = this.createThead();
				this.$ele.append(theadHtml);
				//创建表身tbody,调用内容，传入回调函数
				this.setting.dataFun.call(this, this.refreshTbody());
				
				
			}
			/**
			 * 刷新body内容，传入data
			 */
			,refreshTbody: function() {
				var setting = this.setting;
				var $ele = this.$ele;
				var _this = this;
				return function(data) {
					//清空表内容
					_this.clearTbody.call(_this);
					//生成表内容
					var tbodyHtml = _this.createTbody.call(_this, data);
					$ele.append(tbodyHtml);
				}
				
			}
			/**
			 * 创建表身<tbody>
			 * 表格输入状态 isedit isRead
			 * 
			 */
			,createTbody: function(data) {
				var tbodyDom = $("<tbody></tbody");
				//加入行
				if(data && data.rows) {
					var rows = data.rows;//行数据
					var fieldSet = this.setting.fields;
					for(var i = 0; i < rows.length; i++) {
						var rowData = rows[i];//行传入的数据
						var trDom = this.createTbodyTr(rowData, fieldSet);//创建行数据
						tbodyDom.append(trDom);
					}
				}
				//根据配置判断默认是编辑的还是只读的
				if(this.setting.fieldsDefaultType == "read") {
					tbodyDom.find("div[name=isEdit]").hide();
					tbodyDom.find("div[name=isRead]").show();
				} else if (this.setting.fieldsDefaultType == "edit") {
					tbodyDom.find("div[name=isRead]").hide();
					tbodyDom.find("div[name=isEdit]").show();
				}
				return tbodyDom;
			}
			/**
			 * 创建表身行数据
			 * @param rowNum 行数，
			 * @param fieldSet 字段设置数据
			 * @param setting 所有总设置
			 */
			,createTbodyTr: function(rowData, fieldSet) {
				var setting = this.setting;
				var trDom = $('<tr></tr>');
				var keyValue = rowData[setting.fieldsKey];//行主键
				//在tr上插入属性
				trDom.prop('id', 'tr-' + keyValue);
				//循环列，根据字段set
				for(var j = 0; j < fieldSet.length; j++) {
					//如果有名称，则一定要插入td
					var field = fieldSet[j];
					if(field.name) {
						var tdStr = this.createTd(rowData, field, keyValue);
						trDom.append(tdStr);
					}
					
				}
				return trDom;
				
			}
			/**
			 * 创建tddom
			 * @param rowData 当前行的数据
			 * @param field 当前字段配置
			 * @param keyValue 行主要键的值
			 */
			,createTd: function(rowData, field, keyValue) {
				var tdStr = "<td>";
				//根据index取值
				var value = this.createTdValue(rowData, field, keyValue);
				tdStr += value;
				tdStr += "</td>";
				
				return tdStr;
			}
			/**
			 * 创建td值的一些内容根据行属性
			 * @param rowData 行数据
			 * @param field 当前字段的配置
			 * @param keyValue 行主键值
			 */
			,createTdValue(rowData, field, keyValue) {
				var value = "";
				var htmlStr = "";
				if(field.index) {
					value = rowData[field.index];
				}
				var preName = field.index + "_" + keyValue;
				/*
				 * 判断是否有可编辑内容
				 */
				if(field.isEdit) {
					//如果是可编辑的，加入可编辑部分和不可编辑部分
					htmlStr += "<div name = 'isEdit'>";
					htmlStr += "<input name='" + preName + "' value = '" + value + "' fieldName='" + field.index + "'/>";
					htmlStr += "</div>";
					htmlStr += "<div name = 'isRead'>";
					htmlStr += value;
					htmlStr += "</div>";
				} else {
					htmlStr += value;
				}
				
				//查询是否有formatter
				if(field.readFormatter || field.editFormatter) {
					//运行formatter 覆写内容， 传入参数:主键值， 当前td值，行数据，已经拼接的html内容
					if(field.readFormatter) {
						htmlStr += "<div name = 'isRead'>";
						htmlStr += field.readFormatter.call(this, keyValue, value, rowData, htmlStr);
						htmlStr += "</div>";
					}
					if(field.editFormatter) {
						htmlStr += "<div name = 'isEdit'>";
						htmlStr += field.editFormatter.call(this, keyValue, value, rowData, htmlStr);
						htmlStr += "</div>";
					}
				}
			
				return htmlStr;
			}
			/**
			 * 清空表身
			 */
			,clearTbody: function() {
				this.$ele.remove("tbody");
			}
			,createThead: function() {
				//获取检查字段描述
				var fieldArr = this.setting.fields;
				if(!fieldArr || fieldArr.length <= 0) {
					throw new Exception("字段描述不能为空！");
				}
				var thead  = $("<thead></thead>");
				
				//生成表头
				var htmlStr = "<tr>";
				//生成列
				for(var i = 0;i < fieldArr.length; i++) {
					var field = fieldArr[i];
					if(field.name) {
						htmlStr += "<th>" + field.name + "</th>";
					}
				}
				htmlStr += "</tr>";
				thead.append(htmlStr);
				return thead;
			}
			,clearThead: function() {
				this.$ele.remove("thead");
			}
	}
	
	
	/**
	 * 表格生成工具
	 */
	$.fn.createTable = function(param) {
		//初始化及合并参数
		var tableDom = new TableDom(this, param);
		tableDom.init();
		
		
		return tableDom;
		
	}
	
	
})(jQuery);