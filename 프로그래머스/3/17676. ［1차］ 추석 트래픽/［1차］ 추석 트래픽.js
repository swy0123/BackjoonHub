function solution(lines) {
    var answer = 0;
    
    let min = [];
    for(let i=0; i<lines.length; i++){
        let cur = lines[i].split(' ');
        let tmp = cur[1].split(':').map(Number);
        let len = cur[2].slice(0, -1);
        let end = tmp[0]*3600+tmp[1]*60+tmp[2];
        min.push({end:Number(end)*1000, len:Number(len)*1000});
    }
    min.sort((a, b) => a.end-b.end);
    let arr = [];
    for(let i=0; i<min.length; i++){
        arr.push({val:Number(min[i].end+999), type:'end'});
        let start = Number(min[i].end-min[i].len);
        // if(end%1000>0) end = (end/1000 +1)*1000;
        arr.push({val:start, type:'start'});
    }
    arr.sort((a, b) => a.val-b.val);
    let cur = 0;
    for(let i=0; i<arr.length; i++){
        if(arr[i].type==='start') cur++;
        else cur--;
        answer = answer > cur ? answer : cur;
    }
    return answer;
}