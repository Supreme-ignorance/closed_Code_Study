function check_time() {
    let today = new Date();

    let hours = today.getHours();
    let minutes = today.getMinutes();
    let seconds = today.getSeconds();

    window.alert(
        '지금 시간은 ' + hours + '시' 
        + minutes + '분' 
        + seconds + '초'
    );
}