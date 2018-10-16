function isMobilephoneNum(mobileNum){
    var mobilephoneNumPat=/^1d{10}|01d{10}$/;
    var matchArray=mobileNum.match(mobilephoneNumPat);
    if(matchArray!=null){
        return true;
    }
}
function isDigital(str){
    var digitalPot=/^d*$/;
    var matchArray=str.match(digitalPot);
    if(matchArray!=null){
        return true;
    }
}
function isEnglish(name) {
    if(name.length == 0)
        return false;
    for(i = 0; i < name.length; i++) {
        if(name.charCodeAt(i) > 128)
            return false;
    }
    return true;
}
function isChinese(name) {
    if(name.length == 0)
        return false;
    for(i = 0; i < name.length; i++) {
        if(name.charCodeAt(i) > 128)
            return true;
    }
    return false;
}
function contain(str,charset){
    var i;
    for(i=0;i<charset.length;i++){
        if(str.indexOf(charset.charAt(i))>=0){
            return true;
        }
        return false;
    }
}
function textSelect() {
    var obj = document.activeElement;
    if(obj.tagName == "TEXTAREA")
    {
        obj.select();
    }
    if(obj.tagName == "INPUT" )   {
        if(obj.type == "text")
            obj.select();
    }
}
function textOnly(){
    var i= window.event.keyCode ;
    //8=backspace
    //9=tab
    //37=left arrow
    //39=right arrow
    //46=delete
    //48~57=0~9
    //97~122=a~z
    //65~90=A~Z
    //95=_
    if (!((i<=57 && i>=48)||(i>=97 && i<=122)||(i>=65 && i<=90)||(i==95)||(i==8)||(i==9)||(i==37)||(i==39)||(i==46))){
        //window.event.keyCode=27;
        event.returnValue=false;
        return false;
    } else {
        //window.event.keyCode=keycode;
        return true;
    }
}
function isDate(date){
    var r = date.match(/^(d{1,4})(-||)(d{1,2})(d{1,2})$/);
    if(r==null){
        return false;
    }
    if (r[1]<1 || r[3]<1 || r[3]-1>12 || r[4]<1 || r[4]>31) {
        return false;
    }
    var d= new Date(r[1], r[3]-1, r[4]);
    if(d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]){
        return true;
    }
}
function minLength(strin，minLen) {
    var len=0;
    for(var i=0;i<strin.length;i++)
    {
        if(strin.charCodeAt(i)>256)
        {
            len += 2;
        } else {
            len++;
        }
    }
    if(len>minLen){
        return true;
    }
}
function minLength(strin，minLen) {
    var len=0;
    for(var i=0;i<strin.length;i++)
    {
        if(strin.charCodeAt(i)>256)
        {
            len += 2;
        } else {
            len++;
        }
    }
    if(len>minLen){
        return true;
    }
}
function isEmpty(strin){
    alert('1')
    if(strin==''){
        alert('1')
    }
}
var form1=document.getElementById('planTitle1');
var disp=document.getElementById('limitNone');
var submit=document.getElementById('submitBut1');
submit.onclick=function () {
    // alert('1')
    // alert(form1.value)
    if(form1.i=='')
        alert('1')

}


