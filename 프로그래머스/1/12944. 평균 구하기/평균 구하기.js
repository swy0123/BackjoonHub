function solution(arr) {
    var answer = 0;
    arr.forEach(item => answer += item);
    return answer/arr.length;
}