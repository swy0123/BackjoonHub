const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const array = input.slice(1,).map((item)=>
    item.trim()
)

const sum = (str) =>{
    let sum = 0
    for(let i=0; i<str.length; i++){
        const curC = str.charAt(i)
        if(curC >= '0' && curC <= '9'){
            sum += Number(curC)
        }
    }
    return sum
}

array.sort((a,b)=>{
    if(a.length < b.length){
        return -1
    }
    else if(a.length > b.length){
        return 1
    }
    else{
        const sumA = sum(a)
        const sumB = sum(b)
        
        if(sumA < sumB){
            return -1
        }
        else if(sumA > sumB){
            return 1
        }
        else{
            if(a < b) return -1;
            if(a > b) return 1;
            if(a === b) return 0;
        }
    }
})

console.log(array.join('\n'));
