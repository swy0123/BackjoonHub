const fs = require('fs');
let str = fs.readFileSync('/dev/stdin').toString().trim();

let num = 0;
let cnt = 0;
if(str.length>1) cnt++;
while(str.length>0){
    num += parseInt(str.charAt(str.length-1));
    str = str.substring(0, str.length-1);
}

while(num>=10){
    cnt++;
    let tmp = 0;
    while(num>0){
        tmp+= num%10;
        num = parseInt(num/10);
    }
    num = tmp;
}

console.log(cnt);
console.log(num%3===0?"YES":"NO");