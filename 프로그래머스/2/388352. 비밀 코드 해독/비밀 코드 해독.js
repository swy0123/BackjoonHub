let cq, cans,
    canswer = 0;
function solution(n, q, ans) {
    cq = q
    cans = ans
    var answer = 0;
    qq = q
    gen(n, 0, 0, [])
    return canswer;
}
// const setQ = (q)=> {return t}
// const getQ = ()=> {return t}

const gen = (n, idx, m, arr) =>{
    const newArr = [...arr]
    if(newArr.length >= 5) {
        for(let i=0; i<cq.length; i++){
            let count = 0;
            for(let j=0; j<newArr.length; j++){
                if(cq[i].indexOf(newArr[j]) !== -1){
                    count++
                }
                if(count > cans[i]) break;
            }
            if(count !== cans[i]) return 
        }
        canswer++;
        return 
    }
    newArr.push(0)
    for(let i=m+1; i<=n; i++){
        newArr[idx] = i;
        gen(n, idx+1, i, newArr);
    }
    
}