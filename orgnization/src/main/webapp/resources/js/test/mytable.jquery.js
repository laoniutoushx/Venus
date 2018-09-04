//某些浏览器不支持Object.create,手动添加这个方法
if(typeof Object.create!="function") {
	Object.prototype.create = function(obj) {
		var F = function(){};
		F.prototype = obj;
		return new F();
	}
}
(function($,window,document){
	var MyTable = {
		init:function(elem,options) {
			var self = this;
			self.options = $.extend({},$.fn.mytable.options,options);
			self.elem = elem;
			self.$elem = $(elem);
			self.display();//渲染表格
			self.addEvent();
		},
		display:function() {
			var self = this;
			self.$elem.addClass("mytable");
			self.$elem.css("width",self.options.width);
			if(self.options.headBg)
				self.$elem.find("thead").addClass("headBg");
			if(self.options.evenBg)
				self.$elem.find("tbody tr:even").addClass("evenBg");
			if(self.options.hoverBg) {
				self.$elem.find("tbody tr").hover(function(){
					$(this).addClass("hoverBg");
				},function(){
					$(this).removeClass("hoverBg");
				});
			}
		},
		addEvent:function() {
			var self = this;
			if(typeof self.options.onComplete==="function"&&self.options.onComplete) {
				//完成了对onComplete的调用，第一个参数是上下文，第二和第三个参数是共享给onComplete的参数
				self.options.onComplete.call(self.elem,self,self.$elem);
			}
			if(typeof self.options.onTdClick==="function"&&self.options.onTdClick) {
				self.$elem.find("tbody tr td").on("click",{mt:self},self.options.onTdClick);
			}
		}
	};
	
	$.fn.mytable = function(options){
		//为了满足多个元素的展示，使用each来遍历多个元素
		//此处的this就是jquery的this
		return this.each(function(){
			var mt = Object.create(MyTable);
			mt.init(this,options);
		});
	};
	/**
	 * 自定义的options的常量
	 */
	$.fn.mytable.options = {
		width:700,
		headBg:true,
		evenBg:true,
		hoverBg:true,
		onComplete:null,
		onTdClick:null
	};
})(jQuery,window,document);