function reverseString(number){
    const strNumber = number.toString();
    const arrStr = strNumber.split('');
    const reserseStr = arrStr.reverse().join('');
    return parseInt(reserseStr);
}

const newStr = reverseString(1234);
console.log(newStr);