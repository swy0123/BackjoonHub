const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n").map(v=>v.split(' ').map(Number));
const [N,M] = input[0]
const nums = input[1].sort((a,b)=>a-b)
const answer = [];
function sequence(arr,cnt){
  if(cnt==M){
    answer.push(arr.join(' '))
  }else{
    for(let i = 0; i<N; i++){
      if(nums[i]>=arr[arr.length-1]){
        arr.push(nums[i]);
        sequence(arr,cnt+1)
        arr.pop()
      }
    }
  }
}

for(let i = 0; i<N; i++){
  sequence([nums[i]],1);
}

console.log(answer.join('\n'))