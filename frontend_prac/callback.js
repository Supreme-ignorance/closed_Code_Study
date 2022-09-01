let isHungry = false;
let isThirsty = false;

/**
 * 1. 함수를 파라미터로 넘겨준다
 * @param {*} callback : 2. 제대로 동작했다면 callback을 불러줘.
 * @param {*} errorCallback : 3. 나중에 에러가 나면 errorCallback을 불러줘.
 */
function catCallback(callback, errorCallback){
  if (!isHungry && !isThirsty){
    callback();
  } 
  if (isHungry && isThirsty){
    errorCallback();
  } 
  if (isHungry){
    errorCallback();
  }
  if (isThirsty){
    errorCallback();
  }
}

catCallback(
  (message) => {
    console.log("cat is happy")
  },
  (error) => {
    console.log("cat is angry") 
  }
)