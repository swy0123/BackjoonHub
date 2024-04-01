let [n, k] = (require('fs').readFileSync('dev/stdin')).toString().trim().split(' ').map(Number);

const path = new Map();
path.set(n, -1);
if(n>=k){
    let tmp = [];
    console.log(n-k);
    for(let i=n; i>=k; i--){
        tmp.push(i);
    }
    console.log(tmp.join(' '));
}
else{
    let q = [n];
    let v = Array(100001).fill(false);
    v[n] = true;
    let cn;
    while(q.length){
        cn = q.shift();
        if(cn>0 && cn<k && !v[cn*2]) {
            path.set(cn*2, cn);
            v[cn*2] = true;
            if(cn*2 === k) {
                cn = cn*2;
                break;
            }
            q.push(cn*2);
        }
        if(cn<k && !v[cn+1]) {
            path.set(cn+1, cn);
            v[cn+1] = true;
            if(cn+1 === k) {
                cn = cn+1;
                break;
            }
            q.push(cn+1);
        }
        if(cn>0 && !v[cn-1]) {
            path.set(cn-1, cn);
            v[cn-1] = true;
            if(cn-1 === k) {
                cn = cn-1;
                break;
            }
            q.push(cn-1);
        }
    }
    let ret = [];
    let cnt = 0;
    while(path.has(cn)){
        ret.push(cn);
        cn = path.get(cn);
        if(cn===-1) break;
        cnt++;
    }
    console.log(cnt);
    console.log(ret.reverse().join(' '));
    // console.log(v);
}