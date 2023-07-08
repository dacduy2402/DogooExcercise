function clearSreen() {
    document.getElementById("display").value = "";
}

function displayValue(value) {
    document.getElementById("display").value += value;
    console.log(value);
}

function calculate(){
    let p = document.getElementById("display").value;
    let q = eval(p);
    document.getElementById('display').value = q;
}

function square() {
    let p = document.getElementById("display").value;
    let q = Math.pow(p,2);
    document.getElementById('display').value = q;
}

function squareRoot(){
    let p = document.getElementById("display").value;
    let q = Math.sqrt(p);
    document.getElementById('display').value = q;
}

function absolute() {
    let p = document.getElementById("display").value;
    let q = Math.abs(p);
    document.getElementById('display').value = q;
}
