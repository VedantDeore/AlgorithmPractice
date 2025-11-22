package main

import (
    "container/heap"
    "math"
)

type Item struct {
    time int
    node int
}

type PriorityQueue []Item

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
    // min-heap based on time
    return pq[i].time < pq[j].time
}

func (pq PriorityQueue) Swap(i, j int) { pq[i], pq[j] = pq[j], pq[i] }

func (pq *PriorityQueue) Push(x interface{}) {
    *pq = append(*pq, x.(Item))
}

func (pq *PriorityQueue) Pop() interface{} {
    old := *pq
    n := len(old)
    item := old[n-1]
    *pq = old[:n-1]
    return item
}

func networkDelayTime(times [][]int, n int, k int) int {
    // adjList[u] = list of [v, time]
    adjList := make([][][]int, n+1)
    for i := 0; i <= n; i++ {
        adjList[i] = [][]int{}
    }

    m := len(times)
    for i := 0; i < m; i++ {
        u := times[i][0]
        v := times[i][1]
        t := times[i][2]
        adjList[u] = append(adjList[u], []int{v, t})
    }

    dist := make([]int, n+1)
    for i := 0; i <= n; i++ {
        dist[i] = math.MaxInt32
    }
    dist[k] = 0

    pq := &PriorityQueue{}
    heap.Init(pq)
    heap.Push(pq, Item{time: 0, node: k})

    for pq.Len() > 0 {
        curr := heap.Pop(pq).(Item)
        time := curr.time
        node := curr.node

        if time > dist[node] {
            continue
        }

        for _, neighbour := range adjList[node] {
            adjNode := neighbour[0]
            edgeWeight := neighbour[1]

            if time+edgeWeight < dist[adjNode] {
                dist[adjNode] = time + edgeWeight
                heap.Push(pq, Item{time: dist[adjNode], node: adjNode})
            }
        }
    }

    mintime := 0
    for i := 1; i <= n; i++ {
        if dist[i] == math.MaxInt32 {
            return -1
        }
        if dist[i] > mintime {
            mintime = dist[i]
        }
    }
    return mintime
}
