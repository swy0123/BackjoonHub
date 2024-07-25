let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n')
let [n, m, r] = input[0].split(' ').map(Number)
input.shift()
let arr = input.map((node) => node.split(' ').map(Number))
const graph = Array.from(Array(n+1), () => new Array())
const v  = new Array(n+1).fill(0);
for(let i=0; i<m; i++){
    let [from, to] = arr[i]
    graph[from].push(to)
    graph[to].push(from)
}

for(let i=0; i<graph.length; i++){
    graph[i].sort((a,b)=>b-a)
}
let cnt = 1
const dfs = (node) => {
    if(v[node]===0){
        v[node] = cnt
        cnt++
        for(let i=0; i<graph[node].length; i++){
            dfs(graph[node][i])
        }
    }    
}
dfs(r); 
v.shift();
console.log(v.join('\n'))