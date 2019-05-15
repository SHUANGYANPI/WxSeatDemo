const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

//获取系统时间  时：分
const formatHourMinute = date =>{
  const hour = date.getHours()
  const minute = date.getMinutes()

  return [hour,minute].map(formatNumber).join(':')
}


const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

module.exports = {
  formatTime: formatTime,
  formatHourMinute:formatHourMinute
}

