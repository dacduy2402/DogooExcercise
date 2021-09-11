let Calculator = function () {}

Calculator.prototype.add = function (a, b) {
    return a + b;
}

Calculator.prototype.subtract = function (a, b) {
    return a - b;
}

Calculator.prototype.multiply = function (a, b) {
    return a * b;
}

Calculator.prototype.divide = function (a, b) {
  if (b === 0) {
    return 'Can not divide for Zero';
  }

  return a/b;
}

Calculator.prototype.power = (a) => {
  return a * a;
}


Calculator.prototype.abs = (a) => {
  if (a >= 0) {
    return a
  } else {
    return -1 * a;
  }
}

Calculator.prototype.sqrt = (a) => {
  if (a < 0) {
    return 'Can not calculator';
  } else {
    return Math.sqrt(a);
  }
}

let cal = new Calculator();

console.log("Sum: 1 + 2 = " + cal.add(1,2));
console.log("Subtract: 1 - 2 = " + cal.add(1,2));
console.log("Divide: 1/0 = " + cal.divide(1, 0));
console.log("Divide: 1/2 = " + cal.divide(1, 2));
console.log("Multiply: 3 * 2 = " + cal.multiply(3, 2));
console.log("Power of 3  = " + cal.power(3));
console.log("ABS of -3  = " + cal.abs(-3));
console.log("ABS of 3  = " + cal.abs(3));
console.log("Square root of 3  = " + cal.sqrt(3));
console.log("Square root of 4 = " + cal.sqrt(4));

// Bai 2

let Fibonacci = function () {}

Fibonacci.prototype.get = function (count) {
  if (count < 0) return "OOPS";
  if (count == 0) return 0;
  let a = 0;
  let b = 1;
  for (let i = 1; i < count; i++) {
      const temp = b;
      b = a + b;
      a = temp;
  }
  return b;
}

let fib = new Fibonacci();

console.log("Fibonacci at 8 is ", fib.get(8));

// Bai 3

let LeapYear = function () {};

LeapYear.prototype.isLeapYears  = function(year) {
	return year % 4 === 0 && ( year % 100 !== 0 || year % 400 == 0)
}

let leapYear = new LeapYear();

console.log("2025 is leap year? ", leapYear.isLeapYears(2025));
console.log("2028 is leap year? ", leapYear.isLeapYears(2028));


// Bai 4

var ArrayUtils = function () {};

ArrayUtils.prototype.removeFromArray  = function(...args) {
	const array = args[0];
	const newArray = [];
	array.forEach((item) => {
	  if (!args.includes(item)) {
		newArray.push(item);
	  }
	});
	return newArray;
}

let arrayUtils = new ArrayUtils();

console.log("remove  3, 4 from [1, 2, 3, 4] => " + arrayUtils.removeFromArray([1, 2, 3, 4], 3, 4));

// Bai 5
let NumberUtils = function () {};

NumberUtils.prototype.reverse = (n) => {
  n = n + "";

	return Number(n.split("").reverse().join(""));
}

let numberUtils = new NumberUtils();

console.log("Reverse number of 123456 is " + numberUtils.reverse(123456));

//Bai 6
function js_style() 
{
  //font styles added by JS:
  text.style.fontSize = "24pt";
  text.style.fontFamily = "Comic Sans MS";
  text.style.color = "red";
}

// Bai 7

const filterNonUnique = (arr) => {
  return arr.filter(i => arr.indexOf(i) === arr.lastIndexOf(i))
}

console.log('Remove non unique ' + filterNonUnique([1,1,2,3,4,4,5,6,7]));





