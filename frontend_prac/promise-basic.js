const p = new Promise((resolve, reject) => {
  // 1. 작업을 수행
  let task = true;
  // 작업 (성공할 수도 있고 실패할 수도 있는)을 수행

  // 2. 작업의 수행 결과를 결정
  if (task){
    resolve("작업이 성공했습니다.")
  } else reject("작업이 실패했습니다.")
});

p.then(responce => {
  console.log(`p 프라미스가 resolve됨: ${response}`);
})