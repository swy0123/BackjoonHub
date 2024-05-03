function solution(a) {
    var answer = 1;
    let tmp = Infinity;
    for(let i=0; i<a.length; i++){
        if(tmp>a[i]) tmp = a[i];
    }
    let end = a.length-1;
    let start = 0;
    let min = Infinity;
    let min2 = Infinity;
    while(a[start]>tmp){
        if(min > a[start]){
            min = a[start];
            answer++;
        }
        start++;
    }
    while(a[end]>tmp){
        if(min2 > a[end]){
            min2 = a[end];
            answer++;
        }
        end--;
    }
    return answer;
}