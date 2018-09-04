(function($,window,document){
	var InsertInput = {
		init:function(elem,pc,opts) {
			var self = this;
			self.elem = elem;
			self.$elem = $(elem);
			self.$pc = pc;
			self.opts = $.extend($.fn.insertinput.opts,opts);
			self.oldHtml = self.$pc.html();
			self.initDisplay();
			self.initEvent();
		},
		initEvent:function() {
			var self = this;
			self.$cancel.on("click",function(event){
				self.$pc.html(self.oldHtml);
				event.stopPropagation();
			});
			self.$txt.on("click",function(event){event.stopPropagation();});
			self.$submit.on("click",function(event){
				var val = self.$txt.val();
				if(val=="") {
					alert("请输入要设置的值");
					return false;
				}
				if(!parseInt(val)) {
					alert("输入的值只能是数字");
					return false;
				}
				var keys = self.opts.keys;
				var data = {};
				data[self.opts.valKey] = val;
				for(var i=0;i<keys.length;i++) {
					data[keys[i]] = self.$elem.attr(keys[i]);
				}
				$.post(self.opts.url,data,self.opts.success);
				event.stopPropagation();
			});
		},
		initDisplay:function() {
			var self = this;
			self.$pc.html("");
			var val;
			if(self.opts.initVal) {
				val = self.$elem.attr(self.opts.initVal);
			}
			if(val)
				self.$pc.append("<input type='text' class='insertinput_txt' value='"+val+"'/>");
			else 
				self.$pc.append("<input type='text' class='insertinput_txt'/>");
			self.$pc.append("<span class='insertinput_submit'>"+self.opts.submitTxt+"</span>");
			self.$pc.append("<span class='insertinput_cancel'>取消</span>");
			self.$txt = self.$pc.find(".insertinput_txt");
			self.$submit = self.$pc.find(".insertinput_submit");
			self.$cancel = self.$pc.find(".insertinput_cancel");
			self.$submit.hover(function(){$(this).addClass("insertinput_hover")},function(){$(this).removeClass("insertinput_hover")});
			self.$cancel.hover(function(){$(this).addClass("insertinput_hover")},function(){$(this).removeClass("insertinput_hover")});
		}
	};
	
	$.fn.insertinput = function(opts) {
		//获取父类元素
		if(!opts.delegateObj) {
			alert("必须输入一个事件委派的关联对象");
			return false;
		}
		var pc = opts.pc||$.fn.insertinput.opts.pc;
		return this.each(function(){
			var parent = $(this).parent(pc);
			var self = this;
			parent.on("click",opts.delegateObj,function(event) {
				var insertInput = Object.create(InsertInput);
				insertInput.init(self,parent,opts);
				event.preventDefault();
			});
		});
	};
	
	$.fn.insertinput.opts = {
		url:null,
		pc:"div",
		submitTxt:"更新",
		initVal:null,
		valKey:"value",
		success:function(data) {
			window.location.reload();
		}
	};
})(jQuery,window,document);