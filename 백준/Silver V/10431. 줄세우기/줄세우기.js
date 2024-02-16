let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// let input = fs.readFileSync('./input.txt').toString().trim().split('\n');
let n = parseInt(input[0]);

for (let i=0; i<n; i++) {
    let line = input[i+1].split(' ').map(Number);
    let tmp = [];
    let res = 0, idx;
    for(let j=1; j<=20; j++){
        // console.log(res, tmp)
        if(j===1) tmp.push(line[j]);
        else{
            idx = tmp.length;
            let cnt = 0;
            while(idx>0){
                if(tmp[idx-1]>line[j]) {
                    cnt++;
                    idx--;
                }
                else{
                    break;
                }
            }
            tmp.splice(idx, 0, line[j]);
            res+=cnt;
        }
    }
    console.log((i+1), res)
}