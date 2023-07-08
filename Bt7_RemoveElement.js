function removeElement(arr){
    let counts = [];
    arr.forEach(element => {
        counts[element] = (counts[element] || 0) + 1;
        console.log(counts);
    });
    return arr.filter(element => counts[element] == 1);
}
const output = removeElement([1, 2, 3, 3, 4, 5])
console.log(output);

  