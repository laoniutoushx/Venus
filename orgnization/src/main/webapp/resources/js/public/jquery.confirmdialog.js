(function($,window,document) {
	$.fn.confirmdialog = function(opts) {
		var msg,msgOpts;
		if(typeof opts==="string") {
			msg = opts;
		} else {
			msgOpts = $.extend($.fn.confirmdialog.opts,opts);
		}
		return this.each(function() {
			$(this).on("click",function(event) {
				if(!msg) {
					var oper = $(this).attr("oper");
					msg = msgOpts[oper+"Msg"];
				}
				if(!confirm(msg)) {
					event.preventDefault();
				} 
			});
		});
	};
	$.fn.confirmdialog.opts = {
		deleteMsg:"删除操作不可逆，确定删除该对象吗？",
		confirmMsg:"这个操作不可逆，确定进行该操作吗?",
		updateMsg:"确定更新对象信息吗?",
		addMsg:"确定添加对象吗?"
	};
})(jQuery,window,document);