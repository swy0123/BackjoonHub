const parseTime = (time) => {
    const [min, sec] = time.split(":")
    const num = Number(min)*60 + Number(sec)
    return num
}
const parseNum = (num) => {
    const min = Math.floor(num / 60).toString().padStart(2, '0')
    const sec = (num%60).toString().padStart(2, '0')
    return `${min}:${sec}`
}

const getNextState = (pos, command, op_start, op_end, video_len) => {
    let curPos = pos
    if(command === 'next'){
        curPos += 10
        if(curPos > video_len) curPos = video_len
    }
    else if(command === 'prev'){
        curPos -= 10
        if(curPos < 0) curPos = 0
    }
    if(curPos >= op_start && curPos <= op_end){
        return op_end
    }
    return curPos
}

function solution(video_len, pos, op_start, op_end, commands) {
    let curPos = parseTime(pos)
    const opStart = parseTime(op_start)
    const opEnd = parseTime(op_end)
    const videoLen = parseTime(video_len)
    
    curPos = getNextState(curPos, "", opStart, opEnd, videoLen)
    
    commands.forEach((command)=>{
        curPos = getNextState(curPos, command, opStart, opEnd, videoLen)
    })
    
    return parseNum(curPos)
}