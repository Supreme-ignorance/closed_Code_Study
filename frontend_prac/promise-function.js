function p() {
  return new Promise ((resolve, reject) => {
    console.log('작업 수행중입니다.')

    resolve("작업이 완료됐어요.")
  })
}

p()
  .then((response) => {
    console.log(response)
  })