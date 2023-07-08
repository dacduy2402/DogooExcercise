function removeFromArray(arr, number){
    return arr.filter(item => item !== number);
}

const newArr = removeFromArray([1, 2, 3, 4], 3);
console.log(newArr);