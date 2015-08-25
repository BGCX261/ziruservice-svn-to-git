/**
 * name获得cookies中的键值
 */
function getCookie(name) {
	var prefix = name + "=";
	var start = document.cookie.indexOf(prefix);
	if (start == -1) {
		return null;
	}
	var end = document.cookie.indexOf(";", start + prefix.length);
	if (end == -1) {
		end = document.cookie.length;
	}
	var value = document.cookie.substring(start + prefix.length, end);
	return unescape(value);
}
/**
 * 设置cookies中的值
 * 
 * @param name
 * @param value
 * @param expires
 * @param path
 * @param domain
 * @param secure
 */
function setCookie(name, value, expires, path, domain, secure) {
	document.cookie = name + "=" + escape(value)
			+ ((expires) ? "; expires=" + expires.toGMTString() : "")
			+ ((path) ? "; path=" + path : "")
			+ ((domain) ? "; domain=" + domain : "")
			+ ((secure) ? "; secure" : "");
}

/**
 * 根据选择功能菜单打开功能界面列表
 * 
 * @param url
 */
function loadFunction(url) {
	if (url) {
		$("#main").panel("refresh", url);
	}
}

/**
 * 角色选择表格
 */
(function($) {
	$.fn.roleselect = function(options) {
		options = options || {};
		return this.each(function() {
			var opts = $.extend({
				panelWidth : 500,
				idField : 'roleName',
				textField : 'roleName',
				mode : 'remote',
				pagination : true,
				fit : true,
				fitColumns : true,
				columns : [ [ {
					field : 'roleId',
					title : '角色ID',
					width : 60,
					hidden : true
				}, {
					field : 'roleName',
					title : '名称',
					width : 60
				}, {
					field : 'roleDesc',
					title : '描述',
					width : 150
				} ] ]
			}, options);

			$(this).combogrid(opts);
		});
	};
})(jQuery);