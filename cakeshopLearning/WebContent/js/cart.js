
/**
 * 加入购物车
 */
function buy(goodid){
	$.post("user_addGoods", {goodsid:goodid}, function(data){
			if(data=="ok"){
				
				location.reload();
			layer.msg("商品添加成功！", {time:800}, function(){
				
			});
		}else if(data=="fail"){
			layer.msg("库存不足！请选择其他商品!", {time:800}, function(){
				
			});
		}
	});
}
/**
 * 购物车减去
 */
function lessen(goodsid){
	$.post("user_lessen", {goodsid:goodsid}, function(data){
		if(data=="ok"){
		location.reload();
		}
	});
}
/**
 * 购物车删除
 */
function deletes(goodsid){
	$.post("user_delete", {goodsid:goodsid}, function(data){
		if(data=="ok"){
			location.reload();
		}
	});
}