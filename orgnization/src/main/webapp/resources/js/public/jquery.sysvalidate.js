/**
 * KongHao
 */
(function($,document){
	$.fn.sysvalidate = function(opts) {
		var validate = $.fn.validate;
		opts = initRulesAndMessages(opts);
		var options = $.extend($.fn.validate.prototype,$.fn.sysvalidate.opts,opts);
		validate.call(this,options);
		return this;
	};
	/**
	 * 初始化规则,如果设置了replaceR或者replaceM会完全替换规则和消息，否则只是在rules中添加
	 */
	function initRulesAndMessages(opts) {
		if(opts&&opts.rules) {
			if(opts.replaceR) {
				$.fn.sysvalidate.opts.rules = opts.rules
			} else {
				$.fn.sysvalidate.opts.rules = $.extend($.fn.sysvalidate.opts.rules,opts.rules);
			}
			delete opts.rules;
		}
		if(opts&&opts.messages) {
			if(opts.replaceM) {
				$.fn.sysvalidate.opts.messages = opts.messages
			} else {
				$.fn.sysvalidate.opts.messages = $.extend($.fn.sysvalidate.opts.messages,opts.messages);
			}
			delete opts.messages;
		}
		return opts;
	};
	$.fn.sysvalidate.opts = {
		rules:{
			username:"required",
			password:"required",
			name:"required",
			typeId:{
				min:1,
			},
			confirmPwd:{
				equalTo:"#password"
			},
			email:{
				required:true,
				email:true
			},
			sn:"required"
		},
		messages:{
			username:"用户名不能为空",
			password:"用户密码不能为空",
			confirmPwd:"两次输入的密码不正确",
			typeId:{
				min:"类型id不能为空",
			},
			email:{
				required:"邮件不能为空",
				email:"邮件格式不正确"
			},
			name:"名称不能为空",
			sn:"标识不能为空"
		},
		errorElement:"span",
		errorClass:"errorContainer"
	};
})(jQuery);