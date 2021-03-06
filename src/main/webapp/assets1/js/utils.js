function $(e){
	return document.getElementById(e);
}

String.prototype.trim=function(){
	return this.replace(/(^\s+)|(\s+$)/g, "");
}

/**
 * 验证表单域的值是否符合指定的格式
 * fieldObj是传入的表单对象  比如：username表单中传入的this对象
 * msgOb是指表单后面的span对象  用来显示验证的具体情况包括js和Ajax验证
 * re表示正则表达式
 * nullMsg输入如果为空的消息
 * errorMsg输入信息错误的消息
 */
function checkField(fieldObj,msgObj,re,nullMsg,errorMsg){
	msgObj.innerHTML="";
	var v=fieldObj.value.replace(/(^\s+)|(\s+$)/g,"");
	var flag=true;
	if(v.length==0){
		msgObj.innerHTML=nullMsg;
		flag=false;
	}else{
		if(!re.test(v)){
			msgObj.innerHTML=errorMsg;
			flag=false;
		}
	}
	return flag;
}
