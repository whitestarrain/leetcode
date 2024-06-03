// Created by Bob at 2024/03/26 21:12
// leetgo: dev
// https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/

// @lc code=begin

// TODO: graph class
#include <stdlib.h>
#include <string.h>

typedef struct
{
    int   node_num;
    int **edges;
    int   edge_size;
    int  *edge_col_size;
} Graph;

Graph *graphCreate(int n, int **edges, int edgesSize, int *edgesColSize)
{
    Graph *graph = malloc(sizeof(Graph));
    memset(graph, 0, sizeof(Graph));
    graph->node_num      = n;
    graph->edges         = edges;
    graph->edge_col_size = edgesColSize;
    return graph;
}

void graphAddEdge(Graph *obj, int *edge, int edgeSize)
{
    int **new_edges =
        malloc((obj->edge_size + 1) * (*obj->edge_col_size) * sizeof(int));
    memcpy(new_edges,
           obj->edges,
           (obj->edge_size) * (*obj->edge_col_size) * sizeof(int));
}

int graphShortestPath(Graph *obj, int node1, int node2)
{
    return 0;
}

void graphFree(Graph *obj) {}

/**
 * Your Graph struct will be instantiated and called as such:
 * Graph* obj = graphCreate(n, edges, edgesSize, edgesColSize);
 * graphAddEdge(obj, edge, edgeSize);

 * int param_2 = graphShortestPath(obj, node1, node2);

 * graphFree(obj);
*/

// @lc code=end

int main(int argc, char *argv[])
{
    return EXIT_SUCCESS;
}
