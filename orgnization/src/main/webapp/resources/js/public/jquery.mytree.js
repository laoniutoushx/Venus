(function($,window,document){
	var MyTree = {
		init:function(elem,opts) {
			var self = this;
			self.elem = elem;
			self.$elem = $(elem);
			self.opts = $.extend({},$.fn.mytree.opts,opts);
			self.topts = parseOpts(self.opts);
			self.mytree = $.fn.zTree.init(self.$elem, self.topts);
			self.loadSuccess();
			self.bindClick();
			self.bindEvent();
		},
		loadSuccess:function() {
			var self = this;
			self.mytree.setting.callback.onAsyncSuccess = function() {
				if(self.opts.expandAll) {
					self.mytree.expandAll(true);
				}
				if(self.opts.initCheckCname!="") {
					initCheckNode(self.opts.initCheckCname,self.mytree);
				}	
			};
		},
		bindClick:function() {
			var self = this;
			self.mytree.setting.callback.onClick = function(event,treeId,treeNode) {
				$(self.opts.srcElement).attr("src",self.opts.rootHref+"/"+treeNode.id);
			}
		},
		bindEvent:function() {
			var self = this;
			if(typeof self.opts.onComplete==="function"&&self.opts.onComplete) {
				self.opts.onComplete.call(self.elem,self.mytree);
			}
		}
	};
	function initCheckNode(cname,tree) {
		$("."+cname).each(function() {
			var id = $(this).val();
			var node = tree.getNodeByParam("id",id,null);
			tree.checkNode(node,true,true);
		});
	}
	function parseOpts(opts) {
		var topts={};
		for(var key in opts) {
			var index = key.indexOf("_");
			if(index>0) {
				var k = key.substr(0,index);
				var v = key.substr(index+1);
				//alert(k+","+v+","+opts[key]);
				if(!topts[k])topts[k] = {};
				topts[k][v] = opts[key];
			} else {
				topts[key] = opts[key];
			}
		}
		return topts;
	}
	$.fn.mytree = function(opts) {
		return this.each(function(){
			var mt = Object.create(MyTree);
			mt.init(this,opts);
		});
	};
	$.fn.mytree.opts = {
		//setting[data][simpleData]={xxx}
		data_simpleData:{
			enable: true,
			idKey: "id",
			pIdKey: "pid",
			rootPId: -1
		},
		view_dblClickExpand:false,
		view_selectedMulti:false,
		async_enable: true,
		async_url:"treeAll",
		srcElement:"#cc",
		rootHref:"orgs",
		expandAll:true,
		initCheckCname:"",
		onComplete:null
	};
})(jQuery,window,document)