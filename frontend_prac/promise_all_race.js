function task_longtime(duration){
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(duration)
    }, duration)
  })
}

// task_longtime(1000)
//   .then((msg) => {
//     console.log(msg)
//     return task_longtime(1001)
//   })
//   .then((msg) => {
//     console.log(msg)
//   })

Promise.race([
  task_longtime(1000),
  task_longtime(2000),
  task_longtime(3000),
  task_longtime(4000),
  task_longtime(5000),
])
 .then((msg) => {
  console.log(msg)
})

Promise.all([
  task_longtime(1000),
  task_longtime(2000),
  task_longtime(3000),
  task_longtime(4000),
  task_longtime(5000),
])
 .then((msg) => {
  console.log(msg)
})