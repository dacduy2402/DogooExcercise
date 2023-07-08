function fibonacci(number){
    if(number <= 0){
        return 0;
    }
    if (number == 1) {
        return 1;
    }
    else{
        const arr = [0,1];
        for (let i = 2; i <= number; i++) {
            arr[i] = arr[i - 1] + arr[i -2];
        }
        return arr[number];
    }
}
console.log(fibonacci(0));
console.log(fibonacci(6));

