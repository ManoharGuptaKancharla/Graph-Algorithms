/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manohar_gupta
 */
public class DirectedGraph extends Graph{
    public DirectedGraph(int v){
        super(v);
    }
    @Override
    public void addEdge(int source,int dest){
        vertices[source].add(dest);
        vertexList[source].outdegree++;
        vertexList[dest].indegree++;
    }
    @Override
    public void removeEdge(int source,int dest){
        vertices[source].remove(dest);
        vertexList[source].outdegree--;
        vertexList[dest].indegree--;
    }
}
