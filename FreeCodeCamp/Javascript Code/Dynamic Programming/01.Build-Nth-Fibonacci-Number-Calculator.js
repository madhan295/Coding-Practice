function fibonacci(n) {
  let sequence = [0, 1];

  if (n === 0) {
    return sequence[0];
  }
  if (n === 1) {
    return sequence[1];
  }

  for (let i = 2; i <= n; i++) {
    let nextValue = sequence[i - 1] + sequence[i - 2];
    sequence.push(nextValue);
  }

  return sequence[n];
}