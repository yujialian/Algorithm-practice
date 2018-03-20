function pow(x, n) {
  if(n == 1) {
    return x;
  }
  return x*pow(x, n-1);
}
let x = prompt("x?", '');
let n = prompt("n?", '');
alert(pow(x, n));
