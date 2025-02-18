const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const ret = Array.from({length:input.length-1})


const getAnswer = (str)=>{
    const arr = str.split('');
    let stack = 0
    let answer = 0

    for(let i=0; i<arr.length; i++){
        if(arr[i]==='{') stack++;
        else{
            if(stack>0) stack--;
            else {
                answer++;
                stack++;
            }
        }
    }
    answer += stack/2

    return answer
    
    console.log(arr)
}

for(let i=0; i<input.length-1; i++){
    ret[i] = `${i+1}. ${getAnswer(input[i].trim())}`
}

console.log(ret.join('\n'))