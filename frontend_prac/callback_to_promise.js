let isHungry = true;
let isThirsty = true;

function checkCatStatusPromise(){
  return new Promise((resolve, reject) => {
    // check 수행
    if(!isHungry && !isThirsty){
      resolve("Cat is happy")
    }
    if(isHungry && isThirsty){
      reject("cat is very angry")
    }
    if(isHungry){
      reject("cat is Hungry")
    }
    if(isThirsty){
      reject("cat is Thirsty")
    }
  })
}

checkCatStatusPromise()
  .then((responce)=>{
    console.log(`responce : ${responce}`)
  })
  .catch((responce)=>{
    console.log(`responce : ${responce}`)
  })