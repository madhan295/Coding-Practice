function dfs(graph, root) {
  const visited = [];
  const stack = [root];

  while (stack.length > 0) {
    const node = stack.pop();

    if (!visited.includes(node)) {
      visited.push(node);

      for (let i = graph[node].length - 1; i >= 0; i--) {
        if (graph[node][i] === 1 && !visited.includes(i)) {
          stack.push(i);
        }
      }
    }
  }

  return visited;
}