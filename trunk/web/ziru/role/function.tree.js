(function($){
	$.fn.newtree = function(_cb, val) {
		if(typeof _cb == "string") {
			return $.fn.tree.methods[_cb](this,val);
		}
		var _cb= _cb||{};
		return this.each(function(){
				var _cd=$.data(this,"tree");
				var _ce;
				if(_cd){
					_ce=$.extend(_cd.options,_cb);
					_cd.options=_ce;
				}else{
					_ce=$.extend({},$.fn.tree.defaults,$.fn.tree.parseOptions(this),_cb);
					$.data(this,"tree",{options:_ce,tree:_1(this)});
					var _cf=_4(this);
					_47(this,this,_cf);
				}
				if(_ce.data){
					_47(this,this,_ce.data);
				}else{
					if(_ce.dnd){
						_15(this);
					}else{
						_12(this);
					}
				}
				if(_ce.url){
					_56(this,this);
				}
			});
	};
})(jQuery);