function solution(s)
{
    let max = 1;
    for(let i=0; i<s.length; i++){
        let start = i;
        let end = i;
        while(s.charAt(start)===s.charAt(end)){
            end++;
            start--;
            if(start<0 || end>s.length-1) break;
        } 
        max = max > end-start-1 ? max : end-start-1;
        
        start = i;
        end = i+1;
        while(s.charAt(start)===s.charAt(end)){
            end++;
            start--;
            if(start<0 || end>s.length-1) break;
        }
        max = max > end-start-1 ? max : end-start-1;
        
    }
    // console.log(max)

    return max;
}