/*
 *验证用户名是否符合规范的方法
 *1.验证用户名的输入格式是否正确和是否为空
 *2.验证用户名输入是否唯一（ajax）
 */
function checkUsername(username) {
    //alert(nameOnly_ok);
    //验证用户名的输入格式
    var username_ok = checkField(username, $("usernameMsg"), /^[a-zA-Z0-9_]{1,20}$/, "对不起用户名不能为空！", "对不起用户名不能是字母，数字，下划线以外的数！");
    //alert(nameOnly(username));
    //用户名的格式正确的条件成立则验证用户名是否唯一
    return username_ok;
}
/*
 *用户ID验证
 */
function checkUserId(userid)
{
    var userid_ok=checkField(userid,$("UserIdMsg"),/^{3}$/,"对不起用户编号不能为空！","对不起用户编号只能由三位数字组成！");
    return userid_ok;
}
    /*
     *用户密码验证
     */
function checkPassword(password)
{
    var password_ok=checkField(password,$("passwordMsg"),/^[a-zA-Z0-9]{5,20}$/,"对不起密码不能为空！","对不起密码只能由字母、数字组成且必须五位及五位以上！");
    return password_ok;
}

function checkPassword1(password)
{
    var password_ok=checkField(password,$("passwordMsg1"),/^[a-zA-Z0-9]{5,20}$/,"对不起密码不能为空！","对不起密码只能由字母、数字组成且必须位及五位以上！");
    return password_ok;
}

function checkPassword2(password)
{
    var password_ok=checkField(password,$("passwordMsg2"),/^[a-zA-Z0-9]{5,20}$/,"对不起密码不能为空！","对不起密码只能由字母、数字组成且必须位及五位以上！");
    return password_ok;
}

    /*
     *用户密码验证
     */
 function checkPhone(phone)
 {
     var phone_ok=checkField(phone,$("phoneMsg"),/^[0-9]{11}$/,"对不起电话不能为空！","对不起电话只能由11位数字组成！");
     return phone_ok;
 }