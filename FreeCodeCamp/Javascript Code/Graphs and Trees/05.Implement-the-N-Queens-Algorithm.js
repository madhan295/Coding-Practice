function dfsNQueens(n) {
  if (n < 1) {
    return [];
  }

  const results = [];

  const isValid = (board, row, col) => {
    for (let i = 0; i < row; i++) {
      const prevCol = board[i];
      const columnDistance = Math.abs(prevCol - col);
      const rowDistance = row - i;

      if (prevCol === col || columnDistance === rowDistance) {
        return false;
      }
    }
    return true;
  };

  const solve = (row, currentBoard) => {
    if (row === n) {
      results.push([...currentBoard]);
      return;
    }

    for (let col = 0; col < n; col++) {
      if (isValid(currentBoard, row, col)) {
        currentBoard.push(col);
        solve(row + 1, currentBoard);
        currentBoard.pop();
      }
    }
  };

  solve(0, []);
  return results;
}