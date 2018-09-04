(function($,document,window){
	//Siderbar的对象
	var Sidebar = {
		init:function(elem,opts) {
			var self = this;
			self.elem = elem;
			self.$elem = $(elem);
			self.opts = $.extend({},$.fn.adminsidebar.opts,opts);
			self.initDisplay();
			self.initEvent();
		},
		initDisplay:function() {
			var self = this;
			self.$elem.addClass("sidebar_dl");
			self.$elem.find("dl").addClass("toggle");
			self.$elem.find("dl dt").addClass("toggleHeader");
			self.$elem.find("dl dd a").addClass("toggleHref");
			self.initStatus();
		},
		initStatus:function() {
			var self = this;
			self.$elem.find("dl[status='hide']").find("dd").css("display","none");
		},
		initEvent:function() {
			var self = this;
			self.$elem.find("dl dt").on("click",function() {
				var dle = $(this).parent("dl");
				var status = dle.attr("status");
				if(status=="hide") {
					dle.attr("status","show");
					dle.find("dd").slideDown(200);
				} else {
					dle.attr("status","hide");
					dle.find("dd").slideUp(200);
				}
			});
		}
	};
	$.fn.adminsidebar = function(opts) {
		return this.each(function(){
			var sidebar = Object.create(Sidebar);
			sidebar.init(this,opts);
		});
	};
	//存储初始化的设置，有可能不用
	$.fn.adminsidebar.opts = {
			
	};
})(jQuery,document,window);