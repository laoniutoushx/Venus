(function($,window,document){
	/*格式化地址，把?后面的字符串去掉*/
	$.formatHref = function(href) {
		var index = href.lastIndexOf("?");
		if(index>0) {
			return href.substr(0,index);
		} else {
			return href;
		}
	}
})(jQuery,window,document)