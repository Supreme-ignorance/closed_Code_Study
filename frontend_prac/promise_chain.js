function taskOne(code){
  return new Promise((resolve, reject) => {
    if (code === "1000"){
      resolve("socket connected.")
    }
    if (code === "4000"){
      reject("connection lost.")
    }
  })
}

function taskTwo(msg){
  return new Promise((resolve, reject) => {
    resolve(msg.toUpperCase())
  })
}

taskOne("1000")
  .then((response) => {
    console.log(response)
    return taskTwo(response)
  })
  .then((response) => {
    console.log(response)
  })
  .catch((error) => {
    console.log(error)
    return taskTwo(error)
  })
  .then((response) => {
    console.log(response)
  })