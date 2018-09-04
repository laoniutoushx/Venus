(function($,document,window){
	//Siderbar的对象
	var AdminTable = {
		init:function(elem,opts) {
			var self = this;
			self.elem = elem;
			self.$elem = $(elem);
			self.opts = $.extend({},$.fn.admintable.opts,opts);
			self.initDisplay();
		},
		initDisplay:function() {
			var self = this;
			self.$elem.addClass("list_table");
			self.$elem.find("tbody tr:odd").css("background","#eee");
			self.$elem.find("tbody tr").hover(function(){
				$(this).addClass("trHover");
			},function(){
				$(this).removeClass("trHover");
			});
			if(self.opts.showCheckbox) {
				self.initCheckbox();
			}
		},
		initCheckbox:function() {
			var self = this;
			var ic = self.opts.idColumn;
			self.$elem.find("tbody tr").each(function() {
				var id = $(this).find("td:eq("+ic+")").attr("objId");
				$(this).append("<td align='center'><input type='checkbox' class='obj_check' value="+id+"/></td>")
			});
			self.checkAll = $("<td align='center'><input type='checkbox' id='checkAll'></td>");
			self.$elem.find("thead tr[showCheck=1]").append(self.checkAll);
			self.checkAll.find("input").on("click",checkObj);
		}
	};
	function checkObj() {
		var self = this;
		var check = $(this).attr("checked");
		if(check) {
			$(".obj_check").attr("checked",true);
		} else {
			$(".obj_check").attr("checked",false);
		}
	};
	$.fn.admintable = function(opts) {
		return this.each(function(){
			var at = Object.create(AdminTable);
			at.init(this,opts);
		});
	};
	//存储初始化的设置，有可能不用
	$.fn.admintable.opts = {
		idColumn:0,//id所在列
		showCheckbox:true//是否显示checkbox
	};
})(jQuery,document,window);