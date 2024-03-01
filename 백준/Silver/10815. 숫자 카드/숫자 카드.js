const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let arr = input[1].trim().split(' ').map((val, idx)=>({val:parseInt(val), idx:idx})).sort((a, b)=>{return a.val-b.val});
let tmp = input[3].trim().split(' ').map((val, idx)=>({val:parseInt(val), idx:idx})).sort((a, b)=>{return a.val-b.val});

const binarySearch = (array, value) => {
    let start = -1;
    let end = array.length;
    while (end > start+1) {
        let mid = Math.floor((end - start) / 2)+start;
        if (array[mid].val === value) {
            return mid;
        } else if (array[mid].val > value) {
            end = mid;
        } else {
            start = mid;
        }
    }
    return false
}

let ret = Array(tmp.length).fill(0);
tmp.forEach(element => {
    if(binarySearch(arr, element.val)!==false){
        ret[element.idx]=1;
    }
});

console.log(ret.join(' '));