1. Identify the state(s).
2. Draw the state-space tree.
3. DFS/backtrack on the state-space tree.

```
function dfs(node, state):
    if state is a solution:
        report(state) # e.g. add state to final result list
        return

    for child in children:
        if child is a part of a potential solution:
            state.add(child) # make move
            dfs(child, state)
            state.remove(child) # backtrack
```